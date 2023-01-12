package org.example.dto.req.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuNumRequestDto {
    private int menuNum;

    private MenuNumRequestDto(int menuNum){
        this.menuNum = menuNum
    };
}
