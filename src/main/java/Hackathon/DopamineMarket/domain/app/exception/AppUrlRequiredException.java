package Hackathon.DopamineMarket.domain.app.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;
import Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus;

public class AppUrlRequiredException extends RuntimeException {
    private final ResponseStatus exceptionStatus;

    public AppUrlRequiredException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}