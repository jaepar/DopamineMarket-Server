package Hackathon.DopamineMarket.domain.user.service;

import Hackathon.DopamineMarket.domain.user.domain.User;
import Hackathon.DopamineMarket.domain.user.dto.request.PostUserLoginRequest;
import Hackathon.DopamineMarket.domain.user.dto.response.PostUserLoginResponse;
import Hackathon.DopamineMarket.domain.user.exception.InvalidPasswordException;
import Hackathon.DopamineMarket.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static Hackathon.DopamineMarket.global.response.status.BaseExceptionResponseStatus.INVALID_PASSWORD_ERROR;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public PostUserLoginResponse login(PostUserLoginRequest loginRequest) {
        Optional<User> byNickname = userRepository.findByNickname(loginRequest.nickname());

        //닉네임에 해당하는 사용자가 존재하는 경우
        if(byNickname.isPresent()) {
            User user = byNickname.get();
            if(!user.getPassword().equals(loginRequest.password())) {
                throw new InvalidPasswordException(INVALID_PASSWORD_ERROR);
            }
            return new PostUserLoginResponse(user.getUserId(), user.getPassword());
        }

        User user = signUp(loginRequest.nickname(), loginRequest.password());
        return new PostUserLoginResponse(user.getUserId(), user.getPassword());
    }

    private User signUp(String nickname, String password) {
        User user = User.builder()
                .nickname(nickname)
                .password(password)
                .build();

        return userRepository.save(user);
    }

}

