package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.questions.Questions;
import org.example.domain.questions.QuestionsRepository;
import org.example.service.JpaTestService;
import org.example.tokenization.JFastTexts;
import org.example.tokenization.TokenizeDataSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class JpaTestController {
    public final JpaTestService jpaTestService;
    @GetMapping("/jpa/questions")
    public String insertQuestions(){
        jpaTestService.saveAllQuestions();
        return " ";
    }


}
