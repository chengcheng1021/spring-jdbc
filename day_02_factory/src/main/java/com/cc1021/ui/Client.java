package com.cc1021.ui;

import com.cc1021.factory.BeanFactory;
import com.cc1021.service.IAccountService;
import com.cc1021.service.impl.AccountServiceImpl;

/**
 *  模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}
