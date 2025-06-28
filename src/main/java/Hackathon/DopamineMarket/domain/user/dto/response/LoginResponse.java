package Hackathon.DopamineMarket.domain.user.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginResponse {

    @JsonProperty("user_id")
    @NotEmpty
    private final Long userId;
    @NotEmpty
    private final String nickname;
}
