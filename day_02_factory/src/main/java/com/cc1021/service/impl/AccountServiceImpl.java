package com.cc1021.service.impl;

import com.cc1021.factory.BeanFactory;
import com.cc1021.service.IAccountService;
import com.cc1021.dao.IAccountDao;
import com.cc1021.dao.impl.AccountDaoImpl;

/**
 *  账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

    private int i = 1;

    public void saveAccount() {
        accountDao.saveAccount();
        //System.out.println(i);
        i++;
    }
}
