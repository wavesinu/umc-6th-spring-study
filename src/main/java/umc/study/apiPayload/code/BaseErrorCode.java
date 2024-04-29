package umc.study.apiPayload.code;

public interface BaseErrorCode {
    //status에서 두 개의 메서드를 오버라이드 할 것을 강제
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
