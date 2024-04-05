package application;

import db.DbIntegrityException;
import db.Transmission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class aulaDeletar {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        Transmission trans = new Transmission();

        try {
            conn = trans.Connect();

            st = conn.prepareStatement(
                    "delete from department "
                    + "where Id = ?");

            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! rows affected " + rowsAffected);
        } catch (SQLException e) {
            throw  new DbIntegrityException(e.getMessage());
        } finally {
            Transmission.closePreparedStatement(st);
            Transmission.closeConnection(conn);
        }
    }
}
