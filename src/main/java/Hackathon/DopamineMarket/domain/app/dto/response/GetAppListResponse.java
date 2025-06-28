package Hackathon.DopamineMarket.domain.app.dto.response;

import java.util.List;

public record GetAppListResponse(
        List<AppItem> apps
) {
    public static GetAppListResponse of(List<AppItem> apps) {
        return new GetAppListResponse(apps);
    }
}