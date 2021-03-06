package com.cc1021.service.impl;

import com.cc1021.dao.IAccountDao;
import com.cc1021.domain.Account;
import com.cc1021.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  账户的业务层实现类
 *
 *  事物控制应该都在业务层
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    //需要的是读写型事务配置
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer......");
        //2.1、根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2、根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3、转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4、转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5、更新转出账户
        accountDao.updateAccount(source);
        int i = 100/0;
        //2.6、更新转入账户
        accountDao.updateAccount(target);
    }
}
