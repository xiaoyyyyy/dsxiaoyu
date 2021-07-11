package com.hp.zz;

//标准的单例模式
//Spring 框架 默认是单例模式！！
public class Phone {
    //2.在对象本身new自已，而且是一个static修饰的
    private static Phone ourInstance = new Phone();

    //3.写出返回自身对象的方法的返回值
    public static Phone getInstance() {

        return ourInstance;
    }

    //1.无参构造方法私有化
    private Phone() {
    }
}
