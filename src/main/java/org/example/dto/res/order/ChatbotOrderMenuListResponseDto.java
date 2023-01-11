package org.example.dto.res.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.menu.Menu;
import org.example.dto.req.order.ChatbotOrderMenuListRequestDto;

import java.util.List;

@Getter
@NoArgsConstructor
public class ChatbotOrderMenuListResponseDto {
    private List<Menu> menuList;

    private ChatbotOrderMenuListResponseDto(List<Menu> menuList){
        this.menuList = menuList;
    }

    public static ChatbotOrderMenuListResponseDto of(List<Menu> menuList){
        return new ChatbotOrderMenuListResponseDto(menuList);
    }

    /*@Getter
    public static class MenuList{
        private String menu_name;
        private int price;

        @Builder
        public MenuList(Menu menu){
            this.menu_name = menu.getMenu_name();
            this.price = menu.getPrice();
        }
    }*/
}
