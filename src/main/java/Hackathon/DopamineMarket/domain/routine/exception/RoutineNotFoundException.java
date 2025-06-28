package Hackathon.DopamineMarket.domain.routine.exception;

import Hackathon.DopamineMarket.global.response.status.ResponseStatus;

public class RoutineNotFoundException extends RuntimeException{
    private final ResponseStatus status;

    public RoutineNotFoundException(ResponseStatus status) {
        super(status.getMessage());
        this.status = status;
    }
}
