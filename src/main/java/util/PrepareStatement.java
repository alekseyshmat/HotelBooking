package util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PrepareStatement {

    public static void prepare(PreparedStatement preparedStatement, String... params) throws SQLException {


        int length = params.length;
        for (int i = 0; i < length; i++) {
            preparedStatement.setString(i + 1, params[i]);
        }

    }
}
