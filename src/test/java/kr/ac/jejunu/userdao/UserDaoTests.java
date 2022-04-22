package kr.ac.jejunu.userdao;


import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("hulk");
        user.setPassword("1111");
        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        userDao.insert(user);
        assertThat(user.getId(), greaterThan(0));
        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
  /*  @Test
    public void HallatestGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = new UserDao(new HallaConnectionMaker());
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void Hallainsert() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("hulk");
        user.setPassword("1111");
        UserDao userDao = new UserDao(new HallaConnectionMaker());
        userDao.insert(user);
        assertThat(user.getId(), greaterThan(0));
        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }*/
}