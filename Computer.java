package com.hp.zz;
//像这样只有私有的属性和get,set方法的就叫做实体类
//一般一个实体类对应一个数据库表
public class Computer {
    private double price;
    private  String color;
    private  String typeName;

    /*private Computer(){
        构造方法是可以私有化的
    }*/

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

   /* @Override
    public String toString() {
        return "Computer{" +
                "price=" + price +
                ", color='" + color + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }*/

}
