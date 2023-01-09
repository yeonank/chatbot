package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.questions.Questions;
import org.example.domain.questions.QuestionsRepository;
import org.example.tokenization.JFastTexts;
import org.example.tokenization.TokenizeDataSet;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JpaTestService {
    public final QuestionsRepository questionsRepository;
    public final TokenizeDataSet tokenizeDataSet;
    public final JFastTexts jFastTexts;
    public Questions questions;//todo questions 빈 주입 문제(이건 빈 주입을 하면 안되나)

    @Transactional
    public void saveAllQuestions() {
        String path = "C:/Project/komoran2/Test2/src/unlabeled_pizzabot_data.txt";
        ArrayList<String> sentences, tokenizedSentences;
        List<Questions> questionsList = new ArrayList<>();

        sentences = tokenizeDataSet.readTxtFile(path);
        tokenizedSentences = tokenizeDataSet.tokenize(sentences);

        jFastTexts.jfasttextPizza(tokenizedSentences.get(0));

        //데이터 저장
        /*for (String sentence: sentences) {
            questions = Questions.builder()
                                .intent("")
                                .questions(sentence)
                                .build();
            questionsList.add(questions);
        }

        questionsRepository.saveAll(questionsList);
        System.out.println("save finished");*/
    }
}
