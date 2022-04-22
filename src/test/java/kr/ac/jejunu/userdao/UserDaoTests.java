package kr.ac.jejunu.userdao;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    private static UserDao userDao;

    @BeforeAll
    public static void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void testGet() throws SQLException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException {
        User user = new User();
        user.setName("hulk");
        user.setPassword("1111");
        userDao.insert(user);
        assertThat(user.getId(), greaterThan(0));
        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void update() throws SQLException {
        String updatedName = "seminify";
        String updatedPassword = "Sm3979[]$";
        User user = new User();
        user.setName("hulk");
        user.setPassword("1111");
        userDao.insert(user);
        user.setName(updatedName);
        user.setPassword(updatedPassword);
        userDao.update(user);
        User updatedUser = userDao.get(user.getId());
        assertThat(updatedUser.getName(), is(user.getName()));
        assertThat(updatedUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void delete() throws SQLException {
        User user = new User();
        user.setName("hulk");
        user.setPassword("1111");
        userDao.insert(user);
        userDao.delete(user.getId());
        User deletedUser = userDao.get(user.getId());
        assertThat(deletedUser, nullValue());
    }
}