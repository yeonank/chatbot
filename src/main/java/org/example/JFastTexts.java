package org.example;

import com.github.jfasttext.JFastText;

public class JFastTexts {
    JFastTexts(){}

    public void jfasttexEx(){
        JFastText jft = new JFastText();
        ///////////////////Word embedding learning
        jft.runCmd(new String[] {
                "skipgram",
                "-input", "C:/Project/komoran2/Test2/src/test/resources/data/unlabled_data.txt",
                "-output", "C:/Project/komoran2/Test2/src/test/resources/models/skipgram.model",
                "-bucket", "100",
                "-minCount", "1"
        });
        //////////////////////Text classification
        System.out.println("text classification");
        jft.runCmd(new String[] {
                "supervised",
                "-input", "src/test/resources/data/labeled_data.txt",
                "-output", "src/test/resources/models/supervised.model"
        });

// Load model from file
        jft.loadModel("src/test/resources/models/supervised.model.bin");

// Do label prediction
        String text = "What is the most popular sport in the US ?";
        JFastText.ProbLabel probLabel = jft.predictProba(text);
        System.out.printf("\nThe label of '%s' is '%s' with probability %f\n",
                text, probLabel.label, Math.exp(probLabel.logProb));
    }

    public void jfasttextPizza(){
        JFastText jft = new JFastText();
        ///////////////////Word embedding learning
        jft.runCmd(new String[] {
                "skipgram",
                "-input", "C:/Project/komoran2/Test2/src/unlabeled_pizzabot_data.txt",
                "-output", "C:/Project/komoran2/Test2/src/test/resources/models/skipgramP.model",
                "-bucket", "100",
                "-minCount", "1"
        });
        //////////////////////Text classification
        System.out.println("text classification");
        jft.runCmd(new String[] {
                "supervised",
                "-input", "C:/Project/komoran2/Test2/src/labeled_pizzabot_data.txt",
                "-output", "src/test/resources/models/supervisedP.model"
        });

// Load model from file
        jft.loadModel("src/test/resources/models/supervisedP.model.bin");

// Do label prediction
        String text = "피자 주문해줘!";
        TokenizeDataSet tokenizeDataSet = new TokenizeDataSet();
        String tokenized = tokenizeDataSet.token(text);
        JFastText.ProbLabel probLabel = jft.predictProba("피자 주문해줘!");
        System.out.printf("\nThe label of '%s' is '%s' with probability %f\n",
                text, probLabel.label, Math.exp(probLabel.logProb));

        //상위 n개의 확률 가져오기(마이너스에 결과라도 확률이 나오면 반환해줌!
        System.out.println("predictProba: " + jft.predictProba(text, 5));
    }

    //사용자 사전 만들기
}
