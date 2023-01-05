package org.example;

import com.github.jfasttext.JFastText;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;

import java.util.ArrayList;

public class Main {
    //public String[] input_arr;
    public static void main(String[] args) {
        ArrayList<String> packet;
        TokenizeDataSet tokenizeDataSet = new TokenizeDataSet();
        JFastTexts jFastTexts = new JFastTexts();

        String path = "C:/Project/komoran2/Test2/src/unlabeled_pizzabot_data.txt";

        tokenizeDataSet.readTxtFile(path);
        tokenizeDataSet.tokenize();

        jFastTexts.jfasttextPizza();
    }
}