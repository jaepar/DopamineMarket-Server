package Hackathon.DopamineMarket.domain.app.exception.handler;

import Hackathon.DopamineMarket.domain.app.exception.AppAlreadyExistsException;
import Hackathon.DopamineMarket.domain.app.exception.AppNameRequiredException;
import Hackathon.DopamineMarket.domain.app.exception.AppUrlRequiredException;
import Hackathon.DopamineMarket.domain.app.exception.UserNotFoundException;
import Hackathon.DopamineMarket.global.response.BaseErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RestControllerAdvice(basePackages = "Hackathon.DopamineMarket.domain.app")
public class AppControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AppNameRequiredException.class)
    public BaseErrorResponse handleAppNameRequired(AppNameRequiredException e) {
        log.error("[AppNameRequiredException] {}", e.getMessage(), e);
        return new BaseErrorResponse(APP_NAME_REQUIRED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AppUrlRequiredException.class)
    public BaseErrorResponse handleAppUrlRequired(AppUrlRequiredException e) {
        log.error("[AppUrlRequiredException]", e);
        return new BaseErrorResponse(APP_URL_REQUIRED, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AppAlreadyExistsException.class)
    public BaseErrorResponse handleAppAlreadyExists(AppAlreadyExistsException e) {
        log.error("[AppAlreadyExistsException]", e);
        return new BaseErrorResponse(APP_ALREADY_EXISTS, e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public BaseErrorResponse handleUserNotFound(UserNotFoundException e) {
        log.error("[UserNotFoundException]", e);
        return new BaseErrorResponse(USER_NOT_FOUND_APP, e.getMessage());
    }
}
