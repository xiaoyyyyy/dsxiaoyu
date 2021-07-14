package com.hp.test;

import java.util.Scanner;

/**
 * 检查一个字符串是否为回文
 * 回文:正着念与反着念一样，例如:上海自来水来自海上
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个email地址");
        String email = scanner.nextLine();
        if(email.indexOf("@")<1){
            System.out.println("缺少@或没有用户名");
    }else{
            String username = email.substring(0, email.indexOf("@"));
            System.out.println("用户名:"+username);
        }
    }
}
