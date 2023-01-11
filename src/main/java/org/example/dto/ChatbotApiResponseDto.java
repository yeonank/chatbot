package org.example.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatbotApiResponseDto {
    private int status;
    private String responseMessage;

    public Map<String, Object> datas;
    /*private String answer;
    private Long id;*/

    @Builder
    public ChatbotApiResponseDto(int status, String responseMessage, String answer, Map<String, Object> datas){
        this.status = status;
        this.responseMessage = responseMessage;
        this.datas = datas;
    }
}
