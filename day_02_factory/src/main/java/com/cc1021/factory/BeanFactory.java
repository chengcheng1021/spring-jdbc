package com.cc1021.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *  一个创建bean对象的工厂
 *
 *  Bean：在计算机英语中，有可重用组件的含义
 *  JavaBean：用java语言编写的可重用组件
 *          javaBean > 实体类
 *
 *      他就是创建我们的 service 和 dao 对象的
 *
 *      第一个：需要一个配置文件来配置我们的service和dao
 *              配置的内容：唯一标识 = 全限定类名 （key = value）
 *      第二个：通过读取配置文件中配置的内容，反射创建对象
 *
 *      配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    //定义一个 properties 对象
    private static Properties pros;

    //使用静态代码块为 properties 对象赋值
    static {
        try {
            //实例化对象
            pros = new Properties();
            //获取 properties 文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pros.load(in);
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化 properties 失败！");
        }
    }

    /**
     * 根据Bean的名称获取 Bean 对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = pros.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
