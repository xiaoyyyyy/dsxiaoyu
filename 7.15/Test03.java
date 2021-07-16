package com.zhy;

import java.util.ArrayList;
import java.util.List;
//        获取集合第二个元素并输出。
//        * 将集合第三个元素设置为"3"
//        * 在集合第二个位置上插入元素"2"
//        * 删除集合第三个元素。
public class Test03 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println("第二个元素"+list.get(1));
        System.out.println("list = " + list);
        System.out.println("第三个元素"+list.set(2,3));
        System.out.println("list = " + list);
        list.add(1,"2");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);


    }
}
