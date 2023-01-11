package org.example.dto.res.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.constants.SuccessCode;
import org.example.dto.BaseResponse;
import org.springframework.http.ResponseEntity;

@Getter
@NoArgsConstructor
public class ChatbotOrderMenuListResponse extends BaseResponse {
    private ChatbotOrderMenuListResponseDto data;

    private ChatbotOrderMenuListResponse(Boolean success, String msg, ChatbotOrderMenuListResponseDto data){
        super(success, msg);
        this.data = data;
    }

    public static ResponseEntity<ChatbotOrderMenuListResponse> newResponse(SuccessCode code, ChatbotOrderMenuListResponseDto data){
        ChatbotOrderMenuListResponse response = new ChatbotOrderMenuListResponse(true, code.getMsg(), data);
        return new ResponseEntity(response, code.getStatus());
    }
}
