package Hackathon.DopamineMarket.domain.app.exception.handler;

import Hackathon.DopamineMarket.domain.app.exception.*;
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


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AppUrlFormatInvalidException.class)
    public BaseErrorResponse handleInvalidAppUrlFormat(AppUrlFormatInvalidException e) {
        log.error("[AppUrlFormatInvalidException]", e);
        return new BaseErrorResponse(INVALID_APP_URL_FORMAT, e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AppNotFoundException.class)
    public BaseErrorResponse handleAppNotFound(AppNotFoundException e) {
        log.error("[AppNotFoundException]", e);
        return new BaseErrorResponse(APP_NOT_FOUND, e.getMessage());
    }

}
