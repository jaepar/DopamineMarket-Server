package Hackathon.DopamineMarket.domain.app.exception;

import Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus;
import Hackathon.DopamineMarket.global.response.status.ResponseStatus;


public class AppAlreadyExistsException extends RuntimeException {
    private final ResponseStatus exceptionStatus;

    public AppAlreadyExistsException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}
