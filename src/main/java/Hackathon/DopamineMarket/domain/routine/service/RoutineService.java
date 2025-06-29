package Hackathon.DopamineMarket.domain.routine.service;

import Hackathon.DopamineMarket.domain.routine.domain.Routine;
import Hackathon.DopamineMarket.domain.routine.domain.RoutineCategory;
import Hackathon.DopamineMarket.domain.routine.dto.request.PostRoutineCreateRequest;
import Hackathon.DopamineMarket.domain.routine.dto.response.GetRoutineListResponse;
import Hackathon.DopamineMarket.domain.routine.dto.response.PostRoutineCreateResponse;
import Hackathon.DopamineMarket.domain.routine.dto.response.RoutineItem;
import Hackathon.DopamineMarket.domain.routine.exception.AlreadyCompletedRoutineException;
import Hackathon.DopamineMarket.domain.routine.exception.InvalidRoutineCategoryException;
import Hackathon.DopamineMarket.domain.routine.exception.RoutineNotFoundException;
import Hackathon.DopamineMarket.domain.routine.exception.UserNotFoundException;
import Hackathon.DopamineMarket.domain.routine.repository.RoutineRepository;
import Hackathon.DopamineMarket.domain.user.domain.User;
import Hackathon.DopamineMarket.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.*;

@Service
@RequiredArgsConstructor
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final UserRepository userRepository;

    public PostRoutineCreateResponse createRoutine(PostRoutineCreateRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        RoutineCategory category;
        try {
            category = RoutineCategory.valueOf(request.category());
        } catch (IllegalArgumentException e) {
            throw new InvalidRoutineCategoryException(CATEGORY_NOT_FOUND);
        }

        Routine routine = Routine.builder()
                .user(user)
                .title(request.title())
                .category(category)
                .timer(request.timer())
                .isDaily(request.isDaily())
                .createdAt(LocalDateTime.now())
                .build();

        Routine saved = routineRepository.save(routine);
        return PostRoutineCreateResponse.of(saved.getRoudtineId());
    }

    public GetRoutineListResponse getRoutines(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        List<Routine> routines = routineRepository.findAllByUser(user);

        List<RoutineItem> fixed = new ArrayList<>();
        List<RoutineItem> todayOnly = new ArrayList<>();

        for (Routine r : routines) {
            RoutineItem item = new RoutineItem(
                    r.getRoudtineId(),
                    r.getTitle(),
                    r.getCategory().name(),
                    r.getTimer(),
                    r.isDaily(),
                    Boolean.TRUE.equals(r.getCompleted())
            );
            if (r.isDaily()) {
                todayOnly.add(item); // 오늘만 수행되는 루틴
            } else {
                fixed.add(item);     // 고정 루틴 (매일 반복)
            }
        }

        return GetRoutineListResponse.of(fixed, todayOnly);
    }

    @Transactional
    public void completeRoutine(Long routineId) {
        Routine routine = routineRepository.findById(routineId)
                .orElseThrow(() -> new RoutineNotFoundException(ROUTINE_NOT_FOUND));

        if (Boolean.TRUE.equals(routine.getCompleted())) {
            throw new AlreadyCompletedRoutineException(ROUTINE_ALREADY_COMPLETED);
        }

        routine.complete();
        routine.getUser().increaseCoin(1);
    }

    @Transactional
    public void deleteRoutine(Long routineId) {
        Routine routine = routineRepository.findById(routineId)
                .orElseThrow(() -> new RoutineNotFoundException(ROUTINE_NOT_FOUND));

        routineRepository.delete(routine);
    }

    @Transactional
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
//    @Scheduled(cron = "0 */1 * * * *") // 테스트용
    public void processDailyRoutines() {
        List<Routine> allRoutines = routineRepository.findAll();

        for (Routine routine : allRoutines) {
            if (!Boolean.TRUE.equals(routine.getCompleted())) {
                routine.getUser().decreaseCoin(1);
            }

            if (routine.isDaily()) {
                routineRepository.delete(routine);
            } else {
                routine.reset();
            }
        }
    }

}