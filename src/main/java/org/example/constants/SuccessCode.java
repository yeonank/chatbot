package org.example.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.OK;

@Getter
@AllArgsConstructor
public enum SuccessCode {//todo enum 찾아보기
    //todo http status
    CREATE_ORDER_SUCCESS(OK, "주문 테이블 생성 성공."),
    LOAD_MENU_LIST_SUCCES(OK, "메뉴 리스트를 가져오는데 성공했습니다.");
    private final HttpStatus status;
    private final String msg;
}
