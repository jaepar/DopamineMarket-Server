package Hackathon.DopamineMarket.domain.user.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("비밀번호가 올바르지 않습니다.");
    }
    public InvalidPasswordException(String message) {
        super(message);
    }
}

