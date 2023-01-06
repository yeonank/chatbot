package org.example.domain.answers;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Answers {//id intent questions(데이터 원본 저장)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)//외래키 설정...?
    private String intent;
    @Column(nullable = false)
    private String answers;

    @Builder
    public Answers(String intent, String answers) {
        this.intent = intent;
        this.answers = answers;
    }
}
