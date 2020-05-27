package test;

import com.cc1021.domain.Account;
import com.cc1021.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *  使用Junit单元测试，测试我们的配置
 *  Spring 整合 junit 的配置
 *      1、导入 Spring 整合 junit 的 jar（坐标）
 *      2、使用 Junit 提供的一个注解把原有的 main 方法替换了，替换成 spring 提供的
 *          @RunWith
 *      3、告知 spring 的运行器，spring 和 ioc 创建是基于 xml 还是注解的，并且说明位置
 *          @ContextConfiguration
 *              locations：指定 xml 文件的位置，加上 classpath 关键字，表示在类路径下
 *              classes：指定注解类所在的位置
 *      备注：当我们使用 spring 5.x版本的时候，要求 junit 的 jar 必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as = null;

    @Test
    public void testFindAll() {
        //3、执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //3、执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);

        //3、执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        //3、执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3、执行方法
        as.deleteAccount(4);
    }
}
