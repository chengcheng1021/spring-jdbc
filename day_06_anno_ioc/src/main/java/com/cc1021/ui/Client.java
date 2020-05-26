package com.cc1021.ui;

import com.cc1021.dao.IAccountDao;
import com.cc1021.service.IAccountService;
import com.cc1021.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *  模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取 spring 的 Ioc 核心容器，并根据 id 获取对象
     *
     * ApplicationContext 的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了 (更常用)
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，明天内容。
     *
     * 核心容器的两个接口引发出的问题：
     *  ApplicationContext：     单例对象使用      采用此接口
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
     *  BeanFactory：        多例对象使用
     *      它在构建核心容器时，创建对象采取的策略是延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     *
     * @param args
     */
    public static void main(String[] args) {
        //1、获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");

        System.out.println(as);
//        as.saveAccount();
    }
}
