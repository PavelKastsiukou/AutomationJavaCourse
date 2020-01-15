import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    private static final String EXPECTED_RESULT_LOGIN = "aa";
    private static final String EXPECTED_RESULT_PASSWORD = "bb";
    private static final String queryLogin = "SELECT login FROM user.userdata;";
    private static final String queryPassword = "SELECT password FROM user.userdata;";
    private String loginFromDatabase;
    private String passwordFromDatabase;

    @Test
    public void jdbcTest() {
        String url = "jdbc:mysql://localhost:3306/user?useSSL=false";
        String user = "root";
        String password = "root";


        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(queryLogin)) {
            if (rs.next()) {
                loginFromDatabase = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(queryPassword)) {
            if (rs.next()) {
                passwordFromDatabase = rs.getString(1);
            }
        } catch (SQLException exe) {
            exe.printStackTrace();
        }
        Assert.assertEquals(EXPECTED_RESULT_LOGIN, loginFromDatabase);
        Assert.assertEquals(EXPECTED_RESULT_PASSWORD, passwordFromDatabase);
    }
}
