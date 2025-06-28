package Hackathon.DopamineMarket.domain.app.dto.response;


public record PostAppCreateResponse(
        Long appId,
        String appName,
        String url,
        int coinRequired,
        boolean isLocked
) {
    public static PostAppCreateResponse of(Long appId, String appName, String url, int coinRequired, boolean isLocked) {
        return new PostAppCreateResponse(appId, appName, url, coinRequired, isLocked);
    }
}