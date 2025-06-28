package Hackathon.DopamineMarket.global.response.status;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BaseExceptionResponseStatus implements ResponseStatus {
    SUCCESS(20000, "요청에 성공했습니다."),
    BAD_REQUEST(40000, "유효하지 않은 요청입니다."),
    NOT_FOUND(40400, "존재하지 않는 API입니다."),
    INTERNAL_SERVER_ERROR(50000, "서버 내부 오류입니다."),

    /**
     * 60000 : Routine
     */
    USER_NOT_FOUND(60000, "존재하지 않는 사용자입니다."),
    CATEGORY_NOT_FOUND(60001, "유효하지 않는 카테고리입니다."),
    ROUTINE_NOT_FOUND(60002, "존재하지 않는 루틴입니다."),
    ROUTINE_ALREADY_COMPLETED(60003, "이미 완료된 루틴입니다."),

    /**
     * 70000: User
     */
    INVALID_PASSWORD_ERROR(70000, "비밀번호가 올바르지 않습니다."),
    USER_NOT_FOUND_USER(70001, "존재하지 않는 사용자입니다."),

    //  80000 : App
    USER_NOT_FOUND_APP(80000, "존재하지 않는 사용자입니다."),
    APP_ALREADY_EXISTS(80001, "이미 동일한 앱이 존재합니다."),
    APP_NAME_REQUIRED(80002, "앱 이름은 필수 입력값입니다."),
    APP_URL_REQUIRED(80003, "앱 URL은 필수 입력값입니다."),
    APP_NOT_FOUND(80004, "존재하지 않는 앱입니다.")

    ;

    private final boolean success = false;
    private final int code;
    private final String message;

    @Override
    public boolean getSuccess() {
        return success;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
