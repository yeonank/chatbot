package org.example;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class TokenizeDataSet {
    public String path;
    public int sentence_num =0;
    ArrayList<String> sentences = new ArrayList<>();
    //public String[] input_arr = new String[packet.size()];
    BufferedReader br = null;
    public void tokenize() {
        int j= 0;
        ArrayList<String>[] tokenizedSentences = new ArrayList[sentences.size()];
        for(int i=0; i<sentences.size(); i++){
            tokenizedSentences[i] = new ArrayList<String>();
        }
        //size확인
        //System.out.println("size: " + sentences.size());
        Komoran komoran = new Komoran(DEFAULT_MODEL.LIGHT);
        KomoranResult analyzeResultList;

        for (String sentences: sentences){
            analyzeResultList = komoran.analyze(sentences);
            System.out.println(j+"번째 문장 plaintext: " + analyzeResultList.getPlainText());
            List<Token> tokenList = analyzeResultList.getTokenList();
            System.out.println("noun" + analyzeResultList.getNouns());
            System.out.println("list" + analyzeResultList.getList());

            for (Token token : tokenList) {
                tokenizedSentences[j].add(token.getMorph());
                System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
            }
            j++;
            System.out.println("===========================");
        }
        System.out.println(tokenizedSentences[0]);
    }

    public String token(String sentence){
        String result = "";
        Komoran komoran = new Komoran(DEFAULT_MODEL.LIGHT);
        KomoranResult analyzeResultList = komoran.analyze(sentence);
        System.out.println("plaintext: " + analyzeResultList.getPlainText());
        System.out.println("chosen texts: "+analyzeResultList.getMorphesByTags("NNG", "NNP", "NNB", "VV"));

        List<String> tokenList = analyzeResultList.getMorphesByTags("NNG", "NNP", "NNB", "VV");
        for (String token: tokenList){
            result = result + token + " ";
        }

        System.out.println("result: "+ result);
        return result;
    }

    public ArrayList<String> readTxtFile(String path) {
        try {
            br = new BufferedReader(new FileReader(new File(path)));
            String s;

            while (( s = br.readLine()) != null) {
                sentences.add(s);
                //sentence_num++;
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
