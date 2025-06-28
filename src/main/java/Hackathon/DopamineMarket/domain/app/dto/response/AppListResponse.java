package Hackathon.DopamineMarket.domain.app.dto.response;


public record AppListResponse(
        Long appId,
        String appName,
        String url,
        int coinRequired,
        boolean isLocked
) {
    public static AppListResponse of(Long appId, String appName, String url, int coinRequired, boolean isLocked) {
        return new AppListResponse(appId, appName, url, coinRequired, isLocked);
    }
}