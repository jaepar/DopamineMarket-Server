package Hackathon.DopamineMarket.domain.routine.service;

import Hackathon.DopamineMarket.domain.routine.domain.Routine;
import Hackathon.DopamineMarket.domain.routine.domain.RoutineCategory;
import Hackathon.DopamineMarket.domain.routine.dto.request.PostRoutineCreateRequest;
import Hackathon.DopamineMarket.domain.routine.dto.response.PostRoutineCreateResponse;
import Hackathon.DopamineMarket.domain.routine.exception.InvalidRoutineCategoryException;
import Hackathon.DopamineMarket.domain.routine.exception.UserNotFoundException;
import Hackathon.DopamineMarket.domain.routine.repository.RoutineRepository;
import Hackathon.DopamineMarket.domain.user.domain.User;
import Hackathon.DopamineMarket.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.CATEGORY_NOT_FOUND;
import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.USER_NOT_FOUND;

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

}