package Hackathon.DopamineMarket.domain.app.controller;

import Hackathon.DopamineMarket.domain.app.dto.request.PostAppCreateRequest;
import Hackathon.DopamineMarket.domain.app.dto.response.GetAppListResponse;
import Hackathon.DopamineMarket.domain.app.dto.response.PostAppCreateResponse;
import Hackathon.DopamineMarket.domain.app.service.AppService;
import Hackathon.DopamineMarket.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apps")
@RequiredArgsConstructor
public class AppController {
    private final AppService appService;

    @PostMapping
    public BaseResponse<PostAppCreateResponse>  createApp(@RequestBody PostAppCreateRequest request) {
        return BaseResponse.ok(appService.createApp(request));
    }

    @GetMapping
    public BaseResponse<GetAppListResponse> getAppList(@RequestParam("userId") Long userId) {
        return BaseResponse.ok(appService.getApps(userId));
    }

    @DeleteMapping("/{appId}")
    public BaseResponse<Void> deleteApp(@PathVariable("appId") Long appId) {
        appService.deleteApp(appId);
        return BaseResponse.ok(null);
    }
}
