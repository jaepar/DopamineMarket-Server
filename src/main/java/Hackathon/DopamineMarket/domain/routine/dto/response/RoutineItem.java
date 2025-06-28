package Hackathon.DopamineMarket.domain.routine.dto.response;

public record RoutineItem(
        Long routineId,
        String title,
        String category,
        int timer,
        boolean isDaily,
        boolean completed
) {
}
