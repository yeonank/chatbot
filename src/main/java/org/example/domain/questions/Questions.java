package org.example.domain.questions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Questions {//id intent questions(데이터 원본 저장)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  insert에 pk가 빠지고 데이터베이스의 auto_increment 동작이 수행
    private Long id;
    @Column(nullable = false)
    private String intent;
    @Column(nullable = false)
    private String questions;

    @Builder
    public Questions(String intent, String questions) {
        this.intent = intent;
        this.questions = questions;
    }
}
