package kr.ac.jejunu.userdao;

import java.sql.SQLException;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws SQLException {
        StatementS statementS = new GetStatementS(id);
        return jdbcContext.JdbcConTextForGet(statementS);
    }

    public void insert(User user) throws SQLException {
        StatementS statementS = new InsertStatementS(user);
        jdbcContext.JdbcContextInsert(user, statementS);
    }

    public void update(User user) throws SQLException {
        StatementS statementS = new UpdateStatementS(user);
        jdbcContext.JdbcContextForUpdate(statementS);
    }

    public void delete(Integer id) throws SQLException {
        StatementS statementS = new DeleteStatementS(id);
        jdbcContext.JdbcContextForUpdate(statementS);
    }
}