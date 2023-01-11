package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.menu.MenuRepository;
import org.example.dto.req.order.ChatbotOrderMenuListRequestDto;
import org.example.dto.res.order.ChatbotOrderMenuListResponse;
import org.example.dto.res.order.ChatbotOrderMenuListResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderMenuService {
    private final MenuRepository menuRepository;
    //private final ChatbotOrderMenuListResponseDto chatbotOrderMenuListResponseDto;

    public ChatbotOrderMenuListResponseDto menuList(ChatbotOrderMenuListRequestDto request){
        //List<ment> menus;
        if(request.getUserTypedMessage() == 1){
            return ChatbotOrderMenuListResponseDto.of(menuRepository.findAll());
        }
    }
}
