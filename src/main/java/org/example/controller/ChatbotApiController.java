package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ChatbotApiRequestDto;
import org.example.dto.ChatbotApiResponseDto;
import org.example.dto.ResponseMessage;
import org.example.dto.StatusCode;
import org.example.service.ChatbotApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController//@ResponseBody를 붙이면 json type으로 response를 보냄
public class ChatbotApiController {
    public final ChatbotApiService chatbotApiService;

    @PostMapping("/api/chatbot/answer")
    public ChatbotApiResponseDto getAnswer(@RequestBody ChatbotApiRequestDto question){
        String answer = chatbotApiService.getAnswers(question.getTypedMessage());
        ChatbotApiResponseDto dto = ChatbotApiResponseDto.builder()
                .status(StatusCode.OK)
                .responseMessage(ResponseMessage.ANSWER_SUCCESS)
                .answer(answer)
                .build();
        return dto;
    }
    //todo 만약에 응답 실패한거면 응답 실패한 문장을 데이터베이스에 저장해놓기
    //todo response에 응답코드도 넣기
}
