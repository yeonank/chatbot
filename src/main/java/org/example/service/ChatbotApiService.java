package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.answers.Answers;
import org.example.domain.answers.AnswersRepository;
import org.example.tokenization.JFastTexts;
import org.example.tokenization.TokenizeDataSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ChatbotApiService {
    public final AnswersRepository answersRepository;
    public final TokenizeDataSet tokenizeDataSet;
    public final JFastTexts jFastTexts;
    @Transactional(readOnly = true)
    public String getAnswers(String question){//
        //토큰화->의도분석
        System.out.println("typed: " + question);
        String tokenizedSentence = tokenizeDataSet.tokenizeQuestion(question);
        String intent = jFastTexts.getIntent(tokenizedSentence);
        return answersRepository.findByIntent(intent).getAnswer();
        //todo 가격인 경우 메뉴 테이블에서 추가적으로 찾기
    }
}
