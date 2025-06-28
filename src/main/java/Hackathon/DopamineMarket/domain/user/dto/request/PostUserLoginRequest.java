package Hackathon.DopamineMarket.domain.user.dto.request;

public record PostUserLoginRequest(
        String nickname,
        String password
){

    public static PostUserLoginRequest of(String nickname, String password){
        return new PostUserLoginRequest(nickname, password);
    }
}
