package Hackathon.DopamineMarket.domain.routine.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;

public class AlreadyCompletedRoutineException extends RuntimeException{
    private final ResponseStatus status;

    public AlreadyCompletedRoutineException(ResponseStatus status) {
        super(status.getMessage());
        this.status = status;
    }
}
