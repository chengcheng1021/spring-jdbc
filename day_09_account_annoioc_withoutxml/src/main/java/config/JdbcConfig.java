package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 *  和 spring 连接数据库相关的配置类
 */
@Configuration
public class JdbcConfig {
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
