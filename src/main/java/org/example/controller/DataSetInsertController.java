package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.DataSetInsertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class DataSetInsertController {
    public final DataSetInsertService dataSetInsertService;
    @GetMapping("/jpa/questions")
    public String insertQuestions(){
        dataSetInsertService.saveAllQuestions();
        return "hello this is question";
    }
}
