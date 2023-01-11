package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.answers.Answers;
import org.example.domain.answers.AnswersRepository;
import org.example.domain.menu.Menu;
import org.example.domain.menu.MenuRepository;
import org.example.domain.orders.Orders;
import org.example.domain.orders.OrdersRepository;
import org.example.tokenization.JFastTexts;
import org.example.tokenization.TokenizeDataSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//주문하겠습니다 용 controller를 생성해야한다.
@RequiredArgsConstructor
@Service
public class ChatbotApiService {
    public final AnswersRepository answersRepository;
    public final OrdersRepository ordersRepository;
    public final MenuRepository menuRepository;
    public final TokenizeDataSet tokenizeDataSet;
    public final JFastTexts jFastTexts;
    public Orders orders;
    public Menu menu;
    public Map<String, Object> datas;
    public String answer;
    Long newId;
    public Map<String, Object> getIntent(String question){//
        //토큰화->의도분석
        System.out.println("typed: " + question);
        //질문 분석
        String tokenizedQuestion = tokenizeDataSet.tokenizeQuestion(question);
        String questionIntent = jFastTexts.getIntent(tokenizedQuestion);

        //intent가 주문/배달/가격
        if (questionIntent == null){
            datas = new HashMap<>();
            datas.put("answer", "응답 결과가 없습니다. 다시 입력해주세요.");
            //datas.put("id", id);
            return datas;
        }else{
            answer = answersRepository.findByIntent(questionIntent).getAnswer();
            datas = new HashMap<>();
            datas.put("answer", answer);
            return datas;
        }
    }

    public Map<String, Object> getYesNo(int answer){
        if (answer == 1){
            List<Menu> menuList = menuRepository.findAll();
            datas = new HashMap<>();
            datas.put("answer", "어떤 메뉴를 주문하시겠습니까?");
            datas.put("menuList", menuList);
            datas.put("id", newId);
            return datas;
        }else if(answer == 0){
            datas = new HashMap<>();
            datas.put("answer", "필요하실 때 다시 불러주세요.");
            return datas;
        }else{
            datas = new HashMap<>();
            datas.put("answer", "예는 1 아니오는 0으로 입력해주세요");
            return datas;
        }
    }

    public Map<String, Object> getMenu(int answer){//1~10
        List<Menu> menuList = menuRepository.findAll();
        //String menu_name = menuList.get(answer).getMenu_name();
        orders = Orders.builder()
                .menu(menuList.get(answer-1))
                .build();
        newId = ordersRepository.save(orders).getId();

        datas = new HashMap<>();
        datas.put("id", newId);
        datas.put("answer", "주문하실 수량을 입력해주세요.");
        return datas;
    }
}
