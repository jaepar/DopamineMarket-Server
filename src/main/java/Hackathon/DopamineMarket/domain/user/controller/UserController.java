package Hackathon.DopamineMarket.domain.user.controller;

import Hackathon.DopamineMarket.domain.user.dto.request.PostUserLoginRequest;
import Hackathon.DopamineMarket.domain.user.dto.response.GetUserInfoResponse;
import Hackathon.DopamineMarket.domain.user.dto.response.PostUserLoginResponse;
import Hackathon.DopamineMarket.domain.user.service.UserService;
import Hackathon.DopamineMarket.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/users"))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public BaseResponse<PostUserLoginResponse> login(@RequestBody PostUserLoginRequest loginRequest) {
        return BaseResponse.ok(userService.login(loginRequest));
    }

    @GetMapping
    public BaseResponse<GetUserInfoResponse> getUserById(@RequestParam(name = "userId") Long userId) {
        return BaseResponse.ok(userService.findUserById(userId));
    }
}
