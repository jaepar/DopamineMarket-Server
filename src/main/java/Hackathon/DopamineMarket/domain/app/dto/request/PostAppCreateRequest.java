package Hackathon.DopamineMarket.domain.app.dto.request;

public record PostAppCreateRequest(
        Long userId,
        String appName,
        String url
) {}