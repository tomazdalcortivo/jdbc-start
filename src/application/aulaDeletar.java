package application;

import java.sql.Statement;
import db.DbIntegrityException;
import db.Transmission;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class aulaDeletar {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        Transmission trans = new Transmission();

        try {
            conn = trans.Connect();
            conn.setAutoCommit(false);
            
            st = conn.createStatement();
                                                
            int rows1 = st.executeUpdate("update seller set BaseSalary = 2090 where DepartmentId = 1");
            
//            int x = 1;
//            if (x < 2 ) {
//                throw new SQLException("fake error");
//            }
            int rows2 = st.executeUpdate("update seller set BaseSalary = 3090 where DepartmentId = 2");
            
            conn.commit();
            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);
            
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbIntegrityException("Transition rolled back by " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbIntegrityException("Error trying to rollback caused by "+ ex.getMessage());
            }
        } finally {
            Transmission.closeStatemant(st);
            Transmission.closeConnection(conn);
        }
    }
}
