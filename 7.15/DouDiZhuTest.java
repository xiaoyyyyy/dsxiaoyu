package com.zhy;

import java.util.*;

//斗地主 模拟 洗牌
//牌数 54 张 大王 小王 1-10 J Q K 四个
//1-10
public class DouDiZhuTest {
    public static void main(String[] args) {
        //先造出四个花色
        List<String> colors = new ArrayList<>();
        colors.add("♥");
        colors.add("♠");
        colors.add("♣");
        colors.add("♦");

        //造出10个 2-10
        List<String> numbers = new ArrayList<>();
        for (int i = 2; i <=10 ; i++) {
            numbers.add(i+"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        //上面的colors 和 number 进行一个整合
        //放入一个新的集合中 做到嵌套循环
        //创建新的集合
        //Set<String> piker = new HashSet<>();
        List<String> piker = new ArrayList<>();
        for (String color : colors) {
            for (String number : numbers) {
                piker.add(color+number);

            }
        }
        piker.add("BigKing");
        piker.add("LittleKing");
        System.out.println("piker = " + piker);
        System.out.println("piker = " + piker.size());
        //如果使用set集合也无法分开排序 用 Collections.suffle(piker)
        //只能打乱list 因为set时无序的
        //打乱list排序
        Collections.shuffle(piker);
        System.out.println("piker = " + piker);
        //给player1 player2 player3 发牌
        List<String> player1 = new ArrayList<>();//玩家1
        List<String> player2 = new ArrayList<>();//玩家2
        List<String> player3 = new ArrayList<>();//玩家3
        //底牌
        List<String> diPai = new ArrayList<>();
        for (int i = 0; i <piker.size(); i++) {
            //每张扑克牌
            String pName = piker.get(i);
            if (diPai.contains("♥3") == false) {
            //怎么发牌
            if (i >= 51) {
                //埋后三张底牌
                diPai.add(pName);
            }else{
                //给玩家1 2 3发剩余的51张牌
                if(i%3==0){
                    player1.add(pName);
                }else if(i%3==1){
                    player2.add(pName);
                } else{
                    player3.add(pName);
                }

            }}else {
                System.out.println("底牌不能有♥3，请重新运行");
                break;
            }
        }
        System.out.println("diPai = " + diPai);
        System.out.println("player1 = " + player1);
        System.out.println("player1 = " + player1.size());
        System.out.println("player2 = " + player2);
        System.out.println("player2 = " + player2.size());
        System.out.println("player3 = " + player3);
        System.out.println("player3 = " + player3.size());



        //list 的快速排序（不是人工指定的排序，下节讲人工排序）
        //Collections.sort(piker);
        //规定个地主,  规定 谁摸到红桃3 谁是地主,  注意:  底牌里面不能包含红桃3 .

        if(player1.contains("♥3")==true){
            System.out.println("player1是地主");
            player1.addAll(diPai);
            System.out.println("player1 = " + player1);
        }else if(player2.contains("♥3")==true){
            System.out.println("player2是地主");
            player2.addAll(diPai);
            System.out.println("player2 = " + player2);
        }else if(player3.contains("♥3")==true){
            System.out.println("player3是地主");
            player3.addAll(diPai);
            System.out.println("player3 = " + player3);
        }

    }
}