package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 *  该类是一个配置类，它的作用和 bean.xml 是一样的
 *  spring 中的新注解
 *
 *  @Configuration
 *      作用：指定当前类是一个配置类
 *  @ComponentScan
 *      作用：用于通过注解指定 spring 在创建容器时需要扫描的包
 *      属性：
 *          value：它和 basePackages 的作用是一样的，都是用于指定创建容器时要扫描的包。
 *                  我们使用此注解就等同于在 xml 中配置了：
 *                  <context:component-scan base-package="com.cc1021"></context:component-scan>
 *  @Bean
 *      作用：用于把当前方法的返回值作为bean对象存入 spring 的 ioc 容器中
 *      属性：
 *          name：用于指定 bean 的 id，当不写时，默认值是当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring 框架会去容器中查找有没有可用的 bean 对象。
 */
@Configuration
@ComponentScan(basePackages = {"com.cc1021"})
public class SpringConfiguration {
    /**
     * 用于创建一个 QueryRunner 对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据库对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/db1");
            ds.setUser("root");
            ds.setPassword("");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
