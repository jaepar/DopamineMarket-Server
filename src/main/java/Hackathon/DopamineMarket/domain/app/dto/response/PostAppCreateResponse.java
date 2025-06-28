package Hackathon.DopamineMarket.domain.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostAppCreateResponse {
    private Long appId;
    private String appName;
    private String url;
    private int coinRequired;
    private boolean isLocked;  // 앱 URL

}
