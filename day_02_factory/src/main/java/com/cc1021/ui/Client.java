package com.cc1021.ui;

import com.cc1021.service.impl.AccountServiceImpl;

/**
 *  模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        AccountServiceImpl as = new AccountServiceImpl();
        as.saveAccount();
    }
}
