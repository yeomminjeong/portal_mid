package kr.ac.jejunu;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {

    @Test
    public void get() throws SQLException, ClassNotFoundException {

        Long id = 1l;
        String name = "zeta";
        String password = "1234";

        ConnectionMaker connectionMaker = new JejuConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);

        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        String name = "minjeong";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        ConnectionMaker connectionMaker = new JejuConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);

        userDao.insert(user);
        User insertedUser = userDao.findById(user.getId());
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(),is(password));
    }

    @Test
    public void getHalla() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        String name = "zeta";
        String password = "1234";
        ConnectionMaker connectionMaker = new HallaConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void insertHalla() throws SQLException, ClassNotFoundException {
        String name = "minjeong";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        ConnectionMaker connectionMaker = new HallaConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        userDao.insert(user);

        User insertedUser = userDao.findById(user.getId());
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(),is(password));
    }

}