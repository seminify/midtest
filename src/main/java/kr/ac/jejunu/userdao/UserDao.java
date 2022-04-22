package kr.ac.jejunu.userdao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws SQLException {
        StatementS statementS = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from userinfo where id = ?"
            );
            preparedStatement.setInt(1, id);
            return preparedStatement;
        };
        return jdbcContext.JdbcConTextForGet(statementS);
    }

    public void insert(User user) throws SQLException {
        StatementS statementS = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into userinfo (name, password) values (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement;
        };
        jdbcContext.JdbcContextInsert(user, statementS);
    }

    public void update(User user) throws SQLException {
        StatementS statementS = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update userinfo set name=?, password=? where id=?"
            );
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
            return preparedStatement;
        };
        jdbcContext.JdbcContextForUpdate(statementS);
    }

    public void delete(Integer id) throws SQLException {
        StatementS statementS = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from userinfo where id=?"
            );
            preparedStatement.setInt(1, id);
            return preparedStatement;
        };
        jdbcContext.JdbcContextForUpdate(statementS);
    }
}