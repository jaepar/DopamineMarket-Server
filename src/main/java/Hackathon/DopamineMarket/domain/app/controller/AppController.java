package Hackathon.DopamineMarket.domain.app.controller;

import Hackathon.DopamineMarket.domain.app.dto.request.PostAppCreateRequest;
import Hackathon.DopamineMarket.domain.app.dto.response.PostAppCreateResponse;
import Hackathon.DopamineMarket.domain.app.service.AppService;
import Hackathon.DopamineMarket.domain.user.domain.User;
import Hackathon.DopamineMarket.domain.user.repository.UserRepository;
import Hackathon.DopamineMarket.global.response.BaseResponse;
import Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public BaseResponse<PostAppCreateResponse>  createApp(@RequestBody PostAppCreateRequest request) {
        return BaseResponse.ok(appService.createApp(request));
    }
}
