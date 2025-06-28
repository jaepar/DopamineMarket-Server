package Hackathon.DopamineMarket.domain.user.dto.response;


public record GetUserInfoResponse(
        String nickname,
        int coin
) {
    public static GetUserInfoResponse of(String nickname, int coin){
        return new GetUserInfoResponse(nickname, coin);
    }
}
