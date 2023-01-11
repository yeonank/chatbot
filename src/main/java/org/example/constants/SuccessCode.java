package org.example.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.OK;

@Getter
@AllArgsConstructor
public enum SuccessCode {//todo enum 찾아보기
    //todo http status
    LOAD_MENU_LIST_SUCCES(OK, "게시글 카테고리 조회에 성공했습니다.");
    private final HttpStatus status;
    private final String msg;
}
