package Hackathon.DopamineMarket.domain.routine.dto.response;

import java.util.List;

public record GetRoutineListResponse(
        List<RoutineItem> fixedRoutines,
        List<RoutineItem> todayRoutines
) {
    public static GetRoutineListResponse of(List<RoutineItem> fixedRoutines, List<RoutineItem> todayRoutines) {
        return new GetRoutineListResponse(fixedRoutines, todayRoutines);
    }
}
