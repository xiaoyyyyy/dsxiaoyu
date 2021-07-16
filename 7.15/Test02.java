package com.zhy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*          创建一个集合，存放元素"1","$","2","$","3","$","4"
        *   使用迭代器遍历集合，并在过程中删除所有的"$"，
        *   最后再将删除元素后的集合使用新循环遍历，并输出每一个元素。
        * @author Xiloer*/
public class Test02 {
    public static void main(String[] args) {
        ArrayList<String> coll = new ArrayList<>();
        coll.add("1");
        coll.add("$");
        coll.add("2");
        coll.add("$");
        coll.add("3");
        coll.add("$");
        coll.add("4");
        System.out.println("coll = " + coll);

       Iterator<String> c=coll.iterator();
       while (c.hasNext()){
           if("$".equals(c.next())){
               c.remove();
           }

       }
        System.out.println("coll = " + coll);
    }

}
