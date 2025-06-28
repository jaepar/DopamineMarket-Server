package Hackathon.DopamineMarket.domain.app.dto.response;

public record AppItem(
        Long appId,
        String appName,
        String url,
        int coinRequired,
        boolean isLocked
) {
}