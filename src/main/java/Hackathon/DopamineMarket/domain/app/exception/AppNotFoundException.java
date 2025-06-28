package Hackathon.DopamineMarket.domain.app.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;

public class AppNotFoundException extends RuntimeException {
    private final ResponseStatus exceptionStatus;

    public AppNotFoundException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}
