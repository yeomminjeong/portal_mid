package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User findById(Long id) throws ClassNotFoundException, SQLException {
        String sql = "select id, name, password from user where id = ?";
        Object[] params = new Object[]{id};
        return jdbcContext.find(sql, params);
    }



    public void insert(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into user (name,password) values (?,?)";
        Object[] params = {user.getName(), user.getPassword()};
        jdbcContext.insert(user, sql, params);
    }

    public void update(User user) throws SQLException {
        String sql = "update user set name = ?, password = ? where id = ?";
        Object[] params = {user.getName(), user.getPassword(), user.getId()};
        jdbcContext.update(sql, params);

    }

    public void delete(Long id) throws SQLException {
        String sql = "delete from user where id = ?";
        Object[] params = {id};
        jdbcContext.update(sql,params);
    }
}