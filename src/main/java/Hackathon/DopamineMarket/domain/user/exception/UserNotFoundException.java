package Hackathon.DopamineMarket.domain.user.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{
    private final ResponseStatus exceptionStatus;

    public UserNotFoundException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}