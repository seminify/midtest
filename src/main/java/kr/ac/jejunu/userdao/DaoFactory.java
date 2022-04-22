package kr.ac.jejunu.userdao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DaoFactory {
    @Value("${db.classname}")
    private String classname;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public UserDao userDao() throws ClassNotFoundException {
        return new UserDao(dataSource());
    }

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setDriverClass((Class<? extends Driver>) Class.forName(classname));
        simpleDriverDataSource.setUrl(url);
        simpleDriverDataSource.setUsername(username);
        simpleDriverDataSource.setPassword(password);
        return simpleDriverDataSource;
    }
}
