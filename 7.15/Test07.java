package com.zhy;

import java.util.ArrayList;
import java.util.Arrays;

/*创建一个List集合，并存放10个随机数，然后排序该集合
        * 后输出*/
public class Test07 {
    public static void main(String[] args) {
        ArrayList<Integer> list   = new ArrayList<Integer>();
        int radom=0;
        for (int i = 0; i < 5; i++) {
            radom = (int)(1+Math.random()*(10-1+1));
            list.add(i,radom);
        }
        ListSort(list);
    }
    public static void ListSort(ArrayList<Integer> list) {//ListSort排序方法
        int [] a = new int[list.size()];
        //将list 中的数据复制一份给当前数组
        for (int i = 0; i < a.length; i++) {
            a[i]= list.get(i);
        }
        //对数组进行排序：
        Arrays.sort(a);
        //将排好顺序的数组a中的数据复制一份给list
        for (int j = 0; j < a.length; j++) {
            list.add(j,a[j]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(list.get(i));
        }
    }

}


