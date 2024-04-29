package umc.study.apiPayload.code;

public interface BaseCode {
    //status에서 두 개의 메서드를 오버라이드 할 것을 강제
    public ReasonDTO getReason();

    public ReasonDTO getReasonHttpMethod();
}
