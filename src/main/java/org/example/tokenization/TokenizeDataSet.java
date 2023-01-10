package org.example.tokenization;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TokenizeDataSet {
    public ArrayList<String> tokenize(ArrayList<String> sentences) {
        ArrayList<String> tokenizedSentences = new ArrayList<>();
        String result = "";

        Komoran komoran = new Komoran(DEFAULT_MODEL.LIGHT);
        komoran.setUserDic("user_data/dic.user");
        KomoranResult analyzeResultList;

        for (String sentence: sentences){
            analyzeResultList = komoran.analyze(sentence);
            //System.out.println(j+"번째 문장 plaintext: " + analyzeResultList.getPlainText());
            List<String> tokenList = analyzeResultList.getMorphesByTags("NNG", "NNP", "NNB", "VV");
            for (String token: tokenList){
                result = result + token + " ";
            }
            tokenizedSentences.add(result);
            result = "";
            System.out.println("NNG NNP NNB VV: " + tokenList);
            System.out.println("===========================");
        }

        return tokenizedSentences;
    }

    public String tokenizeQuestion(String question){
        String result = "";
        Komoran komoran = new Komoran(DEFAULT_MODEL.LIGHT);
        komoran.setUserDic("user_data/dic.user");
        KomoranResult analyzeResultList = komoran.analyze(question);
        System.out.println("plaintext: " + analyzeResultList.getPlainText());
        List<String> tokenList = analyzeResultList.getMorphesByTags("NNG", "NNP", "NNB", "VV");
        for (String token: tokenList){
            result = result + token + " ";
        }
        System.out.println("NNG NNP NNB VV: " + tokenList);
        return result;
    }

    public ArrayList<String> readTxtFile(String path) {
        ArrayList<String> sentences = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(path)));
            String s;

            while (( s = br.readLine()) != null) {
                sentences.add(s);
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("input arr: " +sentences);
        return sentences;
    }
}
