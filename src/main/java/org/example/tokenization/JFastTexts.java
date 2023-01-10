package org.example.tokenization;

import com.github.jfasttext.JFastText;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component//빈을 주입할 거면 빈을 등록 해야한다..?
@RequiredArgsConstructor
public class JFastTexts {
    public final TokenizeDataSet tokenizeDataSet;

    public void supervised(){
        System.out.println("text classification");
        //////////////////////Text classification
        JFastText jft = new JFastText();
        jft.runCmd(new String[] {
                "supervised",
                "-input", "C:/Project/komoran2/Test2/src/test/resources/data/labeled_pizzabot_data.txt",
                "-output", "src/test/resources/models/supervisedP.model"
        });

        ///////////////////Word embedding learning
       /* jft.runCmd(new String[] {//항상 텍스트 형태로 줘야만 하나?
                "skipgram",
                "-input", "C:/Project/komoran2/Test2/src/unlabeled_pizzabot_data.txt",
                "-output", "C:/Project/komoran2/Test2/src/test/resources/models/skipgramP.model",
                "-bucket", "100",
                "-minCount", "1"
        });*/
    }

    public void jfasttextPizza(String question){
        JFastText jft = new JFastText();
// Load model from file
        jft.loadModel("src/test/resources/models/supervisedP.model.bin");

// Do label prediction
        JFastText.ProbLabel probLabel = jft.predictProba(question);
        System.out.printf("\nThe label of '%s' is '%s' with probability %f\n",
                question, probLabel.label, Math.exp(probLabel.logProb));

        //상위 n개의 확률 가져오기(마이너스에 결과라도 확률이 나오면 반환해줌!
        System.out.println("predictProba: " + jft.predictProba(question, 5));
    }

    public String getIntent(String question){
        JFastText jft = new JFastText();
        jft.loadModel("src/test/resources/models/supervisedP.model.bin");

        // Do label prediction
        JFastText.ProbLabel probLabel = jft.predictProba(question);
        try{
            System.out.printf("\nThe label of '%s' is '%s' with probability %f\n"
                , question, probLabel.label, Math.exp(probLabel.logProb));
        }catch(NullPointerException e){
            return null;
        }
        //상위 n개의 확률 가져오기(마이너스에 결과라도 확률이 나오면 반환해줌!
        System.out.println("predictProba: " + jft.predictProba(question, 5));
        return probLabel.label;
    }
}
