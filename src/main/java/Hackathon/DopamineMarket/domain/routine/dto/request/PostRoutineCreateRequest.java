package Hackathon.DopamineMarket.domain.routine.dto.request;

public record PostRoutineCreateRequest(
        Long userId,
        String title,
        String category,
        int timer,
        boolean isDaily
){ }
