package kr.ac.jejunu;

public class DaoFactory {
    public UserDao getUserDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    private ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}
