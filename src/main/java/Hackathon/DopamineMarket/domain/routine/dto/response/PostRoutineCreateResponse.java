package Hackathon.DopamineMarket.domain.routine.dto.response;

public record PostRoutineCreateResponse (
        Long routineId
){
    public static PostRoutineCreateResponse of(Long routineId) {
        return new PostRoutineCreateResponse(routineId);
    }
}