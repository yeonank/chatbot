package org.example.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatbotApiResponseDto {
    private int status;
    private String responseMessage;
    private String answer;

    @Builder
    public ChatbotApiResponseDto(int status, String responseMessage, String answer){
        this.status = status;
        this.responseMessage = responseMessage;
        this.answer = answer;
    }
}
