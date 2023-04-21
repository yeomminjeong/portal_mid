package kr.ac.jejunu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;


@Configuration
public class DaoFactory {
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.classname}")
    private String className;
    @Value("${db.url}")
    private String url;

    @Bean
    public UserDao userDao() throws ClassNotFoundException {
        UserDao userDao = new UserDao(jdbcContext());
        return userDao;
    }

    @Bean
    public JdbcContext jdbcContext() throws ClassNotFoundException {
        JdbcContext jdbcContext = new JdbcContext(dataSource());
        return jdbcContext;
    }

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(className));
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
