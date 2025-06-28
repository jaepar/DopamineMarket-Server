package Hackathon.DopamineMarket.domain.app.controller;

import Hackathon.DopamineMarket.domain.app.dto.request.PostAppCreateRequest;
import Hackathon.DopamineMarket.domain.app.dto.response.AppListResponse;
import Hackathon.DopamineMarket.domain.app.service.AppService;
import Hackathon.DopamineMarket.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apps")
@RequiredArgsConstructor
public class AppController {
    private final AppService appService;

    @PostMapping
    public BaseResponse<AppListResponse>  createApp(@RequestBody PostAppCreateRequest request) {
        return BaseResponse.ok(appService.createApp(request));
    }
}
