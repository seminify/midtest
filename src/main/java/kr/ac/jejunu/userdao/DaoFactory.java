package kr.ac.jejunu.userdao;

public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(connectionMaker());
    }

    private ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}
