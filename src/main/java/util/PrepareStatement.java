package util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PrepareStatement {

    public static void prepare(PreparedStatement preparedStatement, List<Object> params) throws SQLException {
        int length = params.size();
        for (int i = 0; i < length; i++) {
            preparedStatement.setString(i + 1, String.valueOf(params.get(i)));
        }
    }
}
