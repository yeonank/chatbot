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
        System.out.println("intent: " + intent);
        if (intent == null){
            return "응답 결과가 없습니다. 다시 입력해주세요.";
        } else if(intent.equals("__label__가격")){
            return "메뉴 이름을 알려주세요";
        }
        return answersRepository.findByIntent(intent).getAnswer();
    }
}
