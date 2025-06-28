package Hackathon.DopamineMarket.domain.app.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;


public class UserNotFoundException extends RuntimeException {
    private final ResponseStatus exceptionStatus;

    public UserNotFoundException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}
