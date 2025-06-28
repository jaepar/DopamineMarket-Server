package Hackathon.DopamineMarket.domain.routine.exception.handler;

import Hackathon.DopamineMarket.domain.routine.exception.InvalidRoutineCategoryException;
import Hackathon.DopamineMarket.domain.routine.exception.UserNotFoundException;
import Hackathon.DopamineMarket.global.response.BaseErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.CATEGORY_NOT_FOUND;
import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.USER_NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RestControllerAdvice(basePackages = "Hackathon.DopamineMarket.domain.routine")
public class RoutineControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public BaseErrorResponse handleUserNotFound(UserNotFoundException e) {
        log.error("[UserNotFoundException]", e);
        return new BaseErrorResponse(USER_NOT_FOUND, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidRoutineCategoryException.class)
    public BaseErrorResponse handleInvalidCategory(InvalidRoutineCategoryException e) {
        log.error("[InvalidRoutineCategoryException]", e);
        return new BaseErrorResponse(CATEGORY_NOT_FOUND, e.getMessage());
    }
}
