package com.cc1021.service.impl;

import com.cc1021.service.IAccountService;
import com.cc1021.dao.IAccountDao;
import com.cc1021.dao.impl.AccountDaoImpl;
import org.springframework.stereotype.Component;

/**
 *  账户的业务层实现类
 *
 *  曾经的xml的配置：
 *      <bean id="accountService" class="com.cc1021.service.impl.AccountServiceImpl"
 *      scope="" init-method="" destory-method="">
 *          <property name="" value="" | ref=""></property>
 *      </bean>
 *
 *  用于创建对象的
 *      他们的作用和在xml配置文件中编写一个<bean></bean>标签实现的功能是一样的
 *      @Component
 *          作用：用于把当前类对象存入Spring容器中
 *          属性：
 *              value：用于指定bean的id。当不写时，它的默认值时当前类名，且首字母改小写。
 *      @Controller：一般用在表现层
 *      @Service：一般用在业务层
 *      @Respository：一般用在持久层
 *      以上三个注解他们的作用和属性与Component是一摸一样的。
 *      他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *
 *
 *  用于注入数据的
 *      他们的作用和在xml配置文件中编写一个<bean>标签中写一个<property></property>实现的功能是一样的
 *  用于改变作用范围的
 *      他们的作用和在xml配置文件中编写一个<bean>标签中写一个<scope></scope>作用是一样的
 *  和生命周期相关
 *      他们的作用和在xml配置文件中编写一个<bean>标签中写一个<init-method>和<destory-method>作用是一样的
 */
@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
