package com.cc1021.service.impl;

import com.cc1021.dao.IAccountDao;
import com.cc1021.domain.Account;
import com.cc1021.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 *  账户的业务层实现类
 *
 *  事物控制应该都在业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer accountId) {
        return transactionTemplate.execute(new TransactionCallback<Account>() {
            public Account doInTransaction(TransactionStatus transactionStatus) {
                return accountDao.findAccountById(accountId);
            }
        });
    }

    public void transfer(String sourceName, String targetName, Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {

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
                //int i = 100/0;
                //2.6、更新转入账户
                accountDao.updateAccount(target);

                return null;
            }
        });

    }
}
