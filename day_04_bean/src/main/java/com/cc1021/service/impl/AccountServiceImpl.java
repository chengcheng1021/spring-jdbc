package com.cc1021.service.impl;

import com.cc1021.service.IAccountService;

/**
 *  账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("service 中的 saveAccount 执行了");
    }
}
