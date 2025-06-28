package Hackathon.DopamineMarket.domain.user.controller;

import Hackathon.DopamineMarket.domain.user.domain.User;
import Hackathon.DopamineMarket.domain.user.dto.request.LoginRequest;
import Hackathon.DopamineMarket.domain.user.dto.response.LoginResponse;
import Hackathon.DopamineMarket.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/users"))
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest);
        LoginResponse loginResponse = new LoginResponse(user.getUserId(), user.getPassword());
        return ResponseEntity.ok().body(loginResponse);
    }

}
