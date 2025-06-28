package Hackathon.DopamineMarket.domain.app.service;

import Hackathon.DopamineMarket.domain.app.domain.App;
import Hackathon.DopamineMarket.domain.app.dto.request.PostAppCreateRequest;
import Hackathon.DopamineMarket.domain.app.dto.response.PostAppCreateResponse;
import Hackathon.DopamineMarket.domain.app.exception.AppAlreadyExistsException;
import Hackathon.DopamineMarket.domain.app.exception.AppNameRequiredException;
import Hackathon.DopamineMarket.domain.app.exception.UserNotFoundException;
import Hackathon.DopamineMarket.domain.app.repository.AppRepository;
import Hackathon.DopamineMarket.domain.user.domain.User;
import Hackathon.DopamineMarket.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.*;

@Service
@RequiredArgsConstructor
public class AppService {

    private final AppRepository appRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostAppCreateResponse createApp(PostAppCreateRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        if (request.appName() == null || request.appName().isBlank()) {
            throw new AppNameRequiredException(APP_NAME_REQUIRED);
        }

        if (request.url() == null || request.url().isBlank()) {
            throw new AppNameRequiredException(APP_URL_REQUIRED);
        }


        boolean exists = appRepository.existsByUserIdAndAppName(user.getUserId(), request.appName());
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
}