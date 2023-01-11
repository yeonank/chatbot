package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.*;
import org.example.dto.res.order.ChatbotOrderMenuListResponseDto;
import org.example.service.ChatbotApiService;
import org.example.service.OrderMenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController//@ResponseBody를 붙이면 json type으로 response를 보냄
public class ChatbotApiController {
    public final ChatbotApiService chatbotApiService;
    public final OrderMenuService orderMenuService;
    public Map<String, Object> datas = new HashMap<>();

    @PostMapping("/api/chatbot/answer/0")//주문인지 배달인지 뭔지 의도 구하기
    public ChatbotApiResponseDto getIntent(@RequestBody ChatbotApiRequestDto question){
        datas = chatbotApiService.getIntent(question.getTypedMessage());
        ChatbotApiResponseDto dto = ChatbotApiResponseDto.builder()
                .status(StatusCode.OK)
                .responseMessage(ResponseMessage.ANSWER_SUCCESS)
                .datas(datas)
                .build();
        return dto;
    }
    //todo 만약에 응답 실패한거면 응답 실패한 문장을 데이터베이스에 저장해놓기

    @PostMapping("/api/chatbot/answer/1")//주문하시겠습니까? yes no
    public ChatbotApiResponseDto getYesNo(@RequestBody ButtonAnswerRequestDto answer){
        datas = chatbotApiService.getYesNo(answer.getAnswer());
        ChatbotApiResponseDto dto = ChatbotApiResponseDto.builder()
                .status(StatusCode.OK)
                .responseMessage(ResponseMessage.ANSWER_SUCCESS)
                .datas(datas)
                .build();
        return dto;
    }

    @PostMapping("/api/chatbot/answer/2")//메뉴를 고르세요
    public ChatbotApiResponseDto getMenu(@RequestBody ButtonAnswerRequestDto answer){
        datas = chatbotApiService.getMenu(answer.getAnswer());
        ChatbotApiResponseDto dto = ChatbotApiResponseDto.builder()
                .status(StatusCode.OK)
                .responseMessage(ResponseMessage.ANSWER_SUCCESS)
                .datas(datas)
                .build();
        return dto;
    }

    @PostMapping("/api/chatbot/answer/3")//메뉴를 고르세요
    public ChatbotApiResponseDto getCount(@RequestBody ButtonAnswerRequestDto answer){
        datas = chatbotApiService.getMenu(answer.getAnswer());
        ChatbotApiResponseDto dto = ChatbotApiResponseDto.builder()
                .status(StatusCode.OK)
                .responseMessage(ResponseMessage.ANSWER_SUCCESS)
                .datas(datas)
                .build();
        return dto;
    }

    @PostMapping("/api/chatbot/answer/4")//메뉴를 고르세요
    public ChatbotOrderMenuListResponseDto test(@RequestBody ButtonAnswerRequestDto answer){
        orderMenuService.menuList(answer.getAnswer());
        return dto;
    }
}
