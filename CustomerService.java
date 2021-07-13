package com.hp.service;

import com.hp.bean.Customer;
import com.hp.bean.CustomerData;
import com.hp.util.TextUtil;

import java.util.List;
import java.util.Scanner;

//此类是完成客户的所有业务（增删改查）
public class CustomerService {
    private List<Customer> customerList;
    private Customer currentCustomer;

    //CustomerData customerData  = CustomerData.getInstance();
    //List<Customer> customerList = customerData.getCustomerList();
    //1.查，登录 判断账号密码是否正确
    public void checkPwd(String cardid, String cardPwd) {
        CustomerData customerData = CustomerData.getInstance();
        //List-<Customer> customerList = customerData.getCustomerList();
        //1.拿到cardid中的账户名和cardPwd对list中的数据做对比
        customerList = customerData.getCustomerList();
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)) {
                currentCustomer = customer;
                System.out.println("欢迎" + customer.getCname() + "顾客登录！请注意旁边安全");
                TextUtil.oneLeveOption(); //界面
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
                //如何保证按了 1 3 5.. 让他再此回到此界面呢？
            }
        }
    }

    private void oneOption(String option) {
        switch (option) {
            case "1":
                //当按下1之后 回退到1及选项
                doSelectMoney();
                goOneHome();
                break;
            case "2":
                goGetMoneyHome();
                goOneHome();
                break;
            case "3":
                doTruanMoney();
                goOneHome();
                break;
            case "4":
                doSaveMoney();
                goOneHome();
                break;
            case "5":
                doQuitCard();
                System.exit(0);
                goOneHome();
                break;
        }
    }

    //退卡
    private void doQuitCard() {
        System.out.println("您是否继续操作yes/no[Y/N]");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("y")) {
            TextUtil.endATM();  //结束
        }
        if (s.equalsIgnoreCase("n")) {

        }
    }

    //存款
    private void doSaveMoney() {
        //1.提示界面
        // System.out.println("请输入您想存入的金额：");
        //2.scanner 接收钱数
//        Scanner scanner = new Scanner(System.in);
//        String moneyIn = scanner.nextLine();
//        Double moneyInInt = Double.valueOf(moneyIn);
//        double newMoney = currentCustomer.getMoney() + moneyInInt; //ctrl+alt+v
//        //3.更新 当前用户的余额
//        currentCustomer.setMoney(newMoney);
//        System.out.println("您的账户余额是： = " + newMoney);
        TextUtil.doSaveMoney();
        //让客户输入
        Scanner scanner = new Scanner(System.in);
        String numIn = scanner.nextLine();
        if (numIn.equals("1")) {
            double money = currentCustomer.getMoney();
            money = money + 100;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("2")) {
            double money = currentCustomer.getMoney();
            money = money + 200;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("3")) {
            double money = currentCustomer.getMoney();
            money = money + 300;
            System.out.println("您的余额是： " + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("4")) {
            double money = currentCustomer.getMoney();
            money = money + 500;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("5")) {
            double money = currentCustomer.getMoney();
            money = money + 800;
            System.out.println("您的余额是： " + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("6")) {
            double money = currentCustomer.getMoney();
            money = money + 1000;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("7")) {
            double money = currentCustomer.getMoney();
            money = money + 2000;
            System.out.println("您的余额是： " + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("8")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的存款金额：");
            int money = sc.nextInt();
            if (money > 0 && money <= currentCustomer.getMoney() + money) ;
            System.out.println("存款成功");
            System.out.println("您的当前余额为：" + currentCustomer.getMoney());
        } else {
            System.out.println("输入错误");
        }
    }

    //转账
    private void doTruanMoney() {
        System.out.println("请输入对方的账户号码：");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入您需要转账的金额：");
        String otherMoney = scanner.nextLine();
        //做计算，自己的钱 - otherMoney ，别人的钱 + otherMoney
        //自己 减钱
        Double otherMoneyInt = Double.parseDouble(otherMoney);
        double currentMoney = currentCustomer.getMoney() - otherMoneyInt;//自己被减去转账后的钱
        //别人 加钱，根据otherAccount 本人的账户查询出 别人的余额，查出别人的余额后，修改别人的余额
        //因为 所有人都在 customerList 都在这个集合中，那么遍历这个集合
        Customer other = null;
        for (Customer customer : customerList) {
            //如果 customer.getAcount 等于 otherAccount，那么这个人就被选出来了
            if (customer.getAccount().equals(otherAccount)) {
                other = customer;
            }
        }

        double otherOneMoney = other.getMoney() + otherMoneyInt; //别人的钱

        //自己和别人 都更新一下 钱数
        currentCustomer.setMoney(currentMoney);
        other.setMoney(otherOneMoney); //注意：有问题？不能够创建对象了

    }


    //查询余额
    private void doSelectMoney() {
        double money = currentCustomer.getMoney();
        System.out.println("余额是" + money);
    }

    //返回一级目录
    private void goOneHome() {
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);//递归算法a

    }

    //取款
    private void goGetMoneyHome() {
        TextUtil.getMoneyUI();
        //1.让客户输入
        Scanner scanner = new Scanner(System.in);
        String numIn = scanner.nextLine();
        if (numIn.equals("1")) {
            //那么取款100 就应该让顾客的钱 -100
            double money = currentCustomer.getMoney();
            money = money - 100;
            System.out.println("您的余额是： " + money);
            //取完款之后，更新原有的存款
            currentCustomer.setMoney(money);
        } else if (numIn.equals("2")) {
            double money = currentCustomer.getMoney();
            money = money - 200;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("3")) {
            double money = currentCustomer.getMoney();
            money = money - 300;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("4")) {
            double money = currentCustomer.getMoney();
            money = money - 500;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("5")) {
            double money = currentCustomer.getMoney();
            money = money - 800;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("6")) {
            double money = currentCustomer.getMoney();
            money = money - 1000;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("7")) {
            double money = currentCustomer.getMoney();
            money = money - 2000;
            System.out.println("您的余额是：" + money);
            currentCustomer.setMoney(money);
        } else if (numIn.equals("8")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的取款金额：");
            int money = sc.nextInt();
            if (money > 0 && money <= currentCustomer.getMoney()) {
                currentCustomer.setMoney(currentCustomer.getMoney() - money);
                System.out.println("取款成功");
                System.out.println("您的当前余额为：" + currentCustomer.getMoney());
            } else {
                System.out.println("输入错误");
            }
        }
    }
}
