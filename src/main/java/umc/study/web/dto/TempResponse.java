package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class TempResponse {

    @Builder
    @Getter
    @AllArgsConstructor
    public static class TempTestDTO {
        String testString;
    }
}
