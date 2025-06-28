package Hackathon.DopamineMarket.domain.routine.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;

public class InvalidRoutineCategoryException extends RuntimeException{
    private final ResponseStatus exceptionStatus;

    public InvalidRoutineCategoryException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}
