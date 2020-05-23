package com.cc1021.ui;

import com.cc1021.dao.IAccountDao;
import com.cc1021.service.IAccountService;
import com.cc1021.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取 spring 的 Ioc 核心容器，并根据 id 获取对象
     * @param args
     */
    public static void main(String[] args) {
        //1、获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
        as.saveAccount();
    }
}
