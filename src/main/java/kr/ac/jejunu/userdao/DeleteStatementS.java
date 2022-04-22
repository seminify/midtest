package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementS implements StatementS {
    private Integer id;

    public DeleteStatementS(Integer id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from userinfo where id=?"
        );
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
