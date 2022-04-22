package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementS implements StatementS {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        Integer id=(Integer)object;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(
                "delete from userinfo where id=?"
        );
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
