package org.example.dto.res.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.constants.SuccessCode;
import org.example.dto.BaseResponse;
import org.springframework.http.ResponseEntity;

@Getter
@NoArgsConstructor
public class MenuListResponse extends BaseResponse {
    private MenuListResponseDto data;

    private MenuListResponse(Boolean success, String msg, MenuListResponseDto data){
        super(success, msg);
        this.data = data;
    }

    public static ResponseEntity<MenuListResponse> newResponse(SuccessCode code, MenuListResponseDto data){
        MenuListResponse response = new MenuListResponse(true, code.getMsg(), data);
        return new ResponseEntity(response, code.getStatus());
    }
}
