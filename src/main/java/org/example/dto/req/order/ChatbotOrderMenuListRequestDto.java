package org.example.dto.req.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.dto.res.order.ChatbotOrderMenuListResponseDto;

@Getter
@NoArgsConstructor
public class ChatbotOrderMenuListRequestDto {
    private int userTypedMessage;

    private ChatbotOrderMenuListRequestDto(int userTypedMessage){
        this.userTypedMessage = userTypedMessage;
    }

    public static ChatbotOrderMenuListRequestDto of(int userTypedMessage){
        return new ChatbotOrderMenuListRequestDto(userTypedMessage);
    }
}
