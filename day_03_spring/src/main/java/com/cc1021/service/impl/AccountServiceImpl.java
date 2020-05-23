package com.cc1021.service.impl;

import com.cc1021.service.IAccountService;
import com.cc1021.dao.IAccountDao;
import com.cc1021.dao.impl.AccountDaoImpl;

/**
 *  账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
