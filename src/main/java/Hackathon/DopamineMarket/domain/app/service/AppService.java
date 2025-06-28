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
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        if (request.getAppName() == null || request.getAppName().isBlank()) {
            throw new AppNameRequiredException(APP_NAME_REQUIRED);
        }

        if (request.getUrl() == null || request.getUrl().isBlank()) {
            throw new AppNameRequiredException(APP_URL_REQUIRED);
        }


        boolean exists = appRepository.existsByUserIdAndAppName(user.getUserId(), request.getAppName());
        if (exists) {
            throw new AppAlreadyExistsException(APP_ALREADY_EXISTS);
        }

        App app = App.builder()
                .user(user)
                .appName(request.getAppName())
                .url(request.getUrl())
                .coinRequired(3)
                .isLocked(true)
                .build();


        appRepository.save(app);

        return PostAppCreateResponse.builder()
                .appId(app.getAppId())
                .appName(app.getAppName())
                .url(app.getUrl())
                .coinRequired(app.getCoinRequired())
                .isLocked(app.getIsLocked())
                .build();
    }
}