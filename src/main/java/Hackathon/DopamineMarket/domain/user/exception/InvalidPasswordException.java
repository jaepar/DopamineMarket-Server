package Hackathon.DopamineMarket.domain.user.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;

public class InvalidPasswordException extends RuntimeException {

    private final ResponseStatus exceptionStatus;

    public InvalidPasswordException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }

}

