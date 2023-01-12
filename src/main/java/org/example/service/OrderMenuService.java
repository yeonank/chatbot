package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.menu.MenuRepository;
import org.example.dto.req.order.MenuListRequestDto;
import org.example.dto.res.order.MenuListResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderMenuService {
    private final MenuRepository menuRepository;
    //private final ChatbotOrderMenuListResponseDto chatbotOrderMenuListResponseDto;

    public MenuListResponseDto menuList(MenuListRequestDto request){
        //List<ment> menus;
        if(request.getUserTypedMessage() == 1){//yes
            return MenuListResponseDto.of(menuRepository.findAll(), "1~10까지 메뉴를 골라주세요.");
        }else if(request.getUserTypedMessage() == 2){
            return MenuListResponseDto.of(null,"필요하시면 다시 불러주세요.");
        }else {
            return MenuListResponseDto.of(null, "주문을 종료합니다.");
        }
    }
}
