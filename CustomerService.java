package com.hp.service;

import com.xiexin.bean.Customer;
import com.xiexin.bean.CustomerData;
import com.xiexin.util.TextUitl;

import java.util.List;
import java.util.Scanner;

// 此类是  完成 客户的 所有业务 (增删改查)
public class CustomerService {
  private List<Customer> customerList;
  private Customer currentCustomer;
    // 1. 查询 登录 判断账号密码是否正确
        public void  checkPwd(String cardid, String  cardPwd){
             CustomerData customerData = CustomerData.getInstance();
            customerList  = customerData.getCustomerList();
                // 1. 拿到 carid中的账户名和cardPwd对list中的数据做对比
            System.out.println("cardid = " + cardid);
            System.out.println("cardPwd = " + cardPwd);

            for (Customer customer : customerList) {
                    if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                        // 拿出来这个人
                        currentCustomer=  customer;
                        // 账户正确
                        System.out.println("欢迎"+customer.getCname()+"顾客登录!请注意您的安全"   );
                        TextUitl.oneLeveOption();  // 界面
                        Scanner scanner = new Scanner(System.in);
                        String option = scanner.nextLine();
                        oneOption(option);
                        // 如何 保证 按了 1 3 5... 让他再此回到 此界面呢 ?
                    }
            }
        }

    private void oneOption(String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                // 查询余额外
                doSelectMoney();
                    // 当按下1之后,回退到1及选项
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                goOneHome();
                break;
        }
    }
    // 查询余额
    private void doSelectMoney() {
        double money = currentCustomer.getMoney();
        System.out.println(" 余额是 " +money);
    }

    private  void goOneHome( ){
        TextUitl.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);  // 递归算法
    }


}
