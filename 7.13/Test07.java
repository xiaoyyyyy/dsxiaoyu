package com.hp.text;

import java.util.Scanner;

// 作业: 写一个 private 方法, 需要 传一个 string 的 网址参数, 返回 处理后的数据.
// 假定 大数据获取了 很多网址, 我想要 www -----  com 之间的内容
// 有一下  几类网址
// www.oracle.com  ---->  oracle
// www.oracle.com.cn  ---->  oracle
// www.java.oracle.com.cn  ---->  java.oracle
// www.lol.game.qq.com.cn  ---->  lol.game.qq
// www.game.mycom.com.cn  ---->  game.mycom
// www.girl.mycom.com.cn  ---->  girl.mycom
// www.computer.mycom.com.cn  ---->  computer.mycom
public class Test07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入网址：");
        String s = scanner.nextLine();

        //调用处理方法
        Sub(s);
    }
    private static void Sub(String s){
        //找到“www” 所在的位置(下标)
        int a=s.indexOf("www.");

        //再找到“.com”所在的位置
        int b=s.indexOf(".com");

        //从“www”开始截取到“.com”结束  要这之间的内容
        String substring = s.substring(a+4,b);
        System.out.println("返回的内容是：" + substring);
    }
}
