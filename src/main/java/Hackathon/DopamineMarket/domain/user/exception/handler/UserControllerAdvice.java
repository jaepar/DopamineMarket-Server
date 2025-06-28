package Hackathon.DopamineMarket.domain.user.exception.handler;

import Hackathon.DopamineMarket.domain.user.exception.InvalidPasswordException;
import Hackathon.DopamineMarket.global.response.BaseErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.INVALID_PASSWORD_ERROR;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RestControllerAdvice(basePackages = "Hackathon.DopamineMarket.domain.user")
public class UserControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidPasswordException.class)
    public BaseErrorResponse handleInvalidPassword(InvalidPasswordException e) {
        log.error("[InvalidPasswordException] ", e);
        return new BaseErrorResponse(INVALID_PASSWORD_ERROR, e.getMessage());
    }

}
