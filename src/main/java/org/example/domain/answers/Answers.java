package org.example.domain.answers;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Answers {//id intent questions(데이터 원본 저장)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)//외래키 설정...?
    private String intent;
    @Column(length = 100, nullable = false)
    private String answer;

    @Builder
    public Answers(String intent, String answer) {
        this.intent = intent;
        this.answer = answer;
    }
}
