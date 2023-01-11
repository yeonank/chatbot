package org.example.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    NO_SPACE_ID_HEADER(BAD_REQUEST, "헤더에 order id 값이 없습니다");
    private final HttpStatus status;
    private final String msg;
}
