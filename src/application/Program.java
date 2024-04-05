package application;

import db.Transmission;
import java.sql.*;

public class Program {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        Transmission trans = new Transmission();

        try {
            conn = trans.Connect();

            st = conn.prepareStatement(
                    "update seller "
                    + "set BaseSalary = BaseSalary + ? "
                    + "where DepartmentId = ?");

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! rows affected " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
                    
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
