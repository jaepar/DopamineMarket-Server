package Hackathon.DopamineMarket.domain.app.service;

import Hackathon.DopamineMarket.domain.app.domain.App;
import Hackathon.DopamineMarket.domain.app.dto.request.PostAppCreateRequest;
import Hackathon.DopamineMarket.domain.app.dto.response.GetAppListResponse;
import Hackathon.DopamineMarket.domain.app.dto.response.PostAppCreateResponse;
import Hackathon.DopamineMarket.domain.app.dto.response.PostAppExecuteResponse;
import Hackathon.DopamineMarket.domain.app.exception.AppAlreadyExistsException;
import Hackathon.DopamineMarket.domain.app.exception.AppNameRequiredException;
import Hackathon.DopamineMarket.domain.app.exception.AppNotFoundException;
import Hackathon.DopamineMarket.domain.app.exception.UserNotFoundException;
import Hackathon.DopamineMarket.domain.app.repository.AppRepository;
import Hackathon.DopamineMarket.domain.user.domain.User;
import Hackathon.DopamineMarket.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Hackathon.DopamineMarket.domain.app.dto.response.AppItem;

import java.util.List;

import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.*;

@Service
@RequiredArgsConstructor
public class AppService {

    private final AppRepository appRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostAppCreateResponse createApp(PostAppCreateRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_APP));

        if (request.appName() == null || request.appName().isBlank()) {
            throw new AppNameRequiredException(APP_NAME_REQUIRED);
        }

        if (request.url() == null || request.url().isBlank()) {
            throw new AppNameRequiredException(APP_URL_REQUIRED);
        }


        boolean exists = appRepository.existsByUserUserIdAndAppName(user.getUserId(), request.appName());
        if (exists) {
            throw new AppAlreadyExistsException(APP_ALREADY_EXISTS);
        }

        App app = App.builder()
                .user(user)
                .appName(request.appName())
                .url(request.url())
                .coinRequired(3)
                .isLocked(true)
                .build();


        appRepository.save(app);

        return PostAppCreateResponse.of(
                app.getAppId(),
                app.getAppName(),
                app.getUrl(),
                app.getCoinRequired(),
                app.getIsLocked()
        );
    }

    @Transactional
    public GetAppListResponse getApps(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_APP));

        List<App> apps = appRepository.findAllByUser(user);

        int userCoin = user.getCoin();

        List<AppItem> result = apps.stream()
                .map(app -> {
                    boolean isLocked = userCoin < app.getCoinRequired();
                    return new AppItem(
                            app.getAppId(),
                            app.getAppName(),
                            app.getUrl(),
                            app.getCoinRequired(),
                            isLocked
                    );
                })
                .toList();

        return GetAppListResponse.of(result);
    }

    @Transactional
    public void deleteApp(Long appId) {
        App app = appRepository.findById(appId)
                .orElseThrow(() -> new AppNotFoundException(APP_NOT_FOUND));
        appRepository.delete(app);
    }

    @Transactional
    public PostAppExecuteResponse executeApp(Long appId) {
        App app = appRepository.findById(appId)
                .orElseThrow(() -> new AppNotFoundException(APP_NOT_FOUND));

        User user = app.getUser();

        if (app.getIsLocked()) {
            return new PostAppExecuteResponse("");
        }

        user.decreaseCoin(app.getCoinRequired());

        return new PostAppExecuteResponse(app.getUrl());
    }
  
}