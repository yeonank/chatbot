package org.example.dto.req.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuListRequestDto {
    private int userTypedMessage;

    private MenuListRequestDto(int userTypedMessage){
        this.userTypedMessage = userTypedMessage;
    }

    public static MenuListRequestDto of(int userTypedMessage){
        return new MenuListRequestDto(userTypedMessage);
    }
}
