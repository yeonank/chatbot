package org.example.dto.res.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.menu.Menu;

import java.util.List;

@Getter
@NoArgsConstructor
public class MenuListResponseDto {
    private List<Menu> menuList;
    private String answer;

    private MenuListResponseDto(List<Menu> menuList, String answer){
        this.menuList = menuList;
        this.answer = answer;
    }

    public static MenuListResponseDto of(List<Menu> menuList, String answer){
        return new MenuListResponseDto(menuList, answer);
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
