package com.hp.zz;

import java.util.ArrayList;

/*
*   输出hello
* */
public class MyJava {
    //main的快捷键  psvm
    public static void main(String[] args) {
        //输出的快捷键  sout
        System.out.println("输出的快捷键是sout");
        String name="xiaobai";
        //soutv 可以显示出变量
        System.out.println("name = " + name);
        //输出方法的名称
        System.out.println("MyJava.main");
        //soutp 输出方法的参数
        System.out.println("args = [" + args + "]");
        
        int age=17;
        //如果小于18 就显示未成年
        if (age <18) {  //if的快捷键是ifn    这个小黄框是永远为真 写死了
            System.out.println("本人未成年");
        }
                //万能快捷键  Alt+enter
        ArrayList<String> strings = new ArrayList<>();
        strings.add("唐山藏");    //Ctrl+D 是快速复制一行
        strings.add("唐山藏");    //多行编辑 用 Alt+鼠标
        strings.add("唐山藏");
        strings.add("唐山藏");  //Ctrl+Y  是快速删除一行
        //Ctrl+Z  是一步撤销  Ctrl+shift+Z 是多步撤销
        
        //遍历循环的快捷键  iter
        for (String string : strings) {
            System.out.println("string = " + string);
        }

        //创建电脑对象
        Computer com=new Computer();  //能这样new 说明它的构造方法是公开的
            com.setPrice(555.8);
            com.setColor("粉色");
            com.setTypeName("小新时代");
        System.out.println("com = " + com);
        //把实体类的tostring方法隐掉 com = com.hp.zz.Computer@74a14482 内存

        //内存地址是否一样，是判断对象是否相等的依据
        Computer com2=new Computer();
        com.setPrice(555.8);
        com.setColor("粉色");
        com.setTypeName("小新时代");
        System.out.println("com2 = " + com2);

        //判断com1和com2是否相等
        System.out.println(com == com2); //false

        //以上就是原型模式 每次new都会创建一个新的对象
        //想让对象每次new唯一 就用单例模式

        //测试单例模式
       // Phone p1=new Phone;  //因为无参构造私有化了。。。
       Phone  p1=Phone.getInstance();
       Phone  p2=Phone.getInstance();
        System.out.println(p1 == p2);  //true

        //单例模式：懒汉 和 饿汉的区别？？？

    }
}
