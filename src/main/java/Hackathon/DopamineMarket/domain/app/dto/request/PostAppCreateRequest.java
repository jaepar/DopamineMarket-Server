package Hackathon.DopamineMarket.domain.app.dto.request;

import lombok.Getter;

@Getter
public class PostAppCreateRequest {
    private Long userId;
    private String appName;
    private String url;
}
