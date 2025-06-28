package Hackathon.DopamineMarket.domain.user.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest {

    @NotEmpty
    private final String nickname;
    @NotEmpty
    private final String password;
}
