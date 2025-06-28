package Hackathon.DopamineMarket.domain.user.dto.response;

public record PostUserLoginResponse (
        Long userId,
        String nickname
) {
    public static PostUserLoginResponse of(Long userId, String nickname){
        return new PostUserLoginResponse(userId, nickname);
    }
}
