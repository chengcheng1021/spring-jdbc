package com.cc1021.jdbctemplate;

import com.cc1021.dao.IAccountDao;
import com.cc1021.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  JdbcTemplate 的 CRUD 操作
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取对象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        account.setMoney(10000f);
        accountDao.updateAccount(account);
    }
}