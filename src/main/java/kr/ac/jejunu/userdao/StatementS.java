package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementS {
    PreparedStatement makeStatement(Connection connection) throws SQLException;
}
