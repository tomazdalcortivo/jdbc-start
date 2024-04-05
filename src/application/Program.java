package application;

import java.sql.*;
import db.Transmission;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        Transmission trans = new Transmission();
        
        

        try {
            conn = trans.Connect();
            /*
            st = conn.prepareStatement(
                    "INSERT INTO seller"
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES"
                    + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Carl Black");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 5000.0);
            st.setInt(5, 4);
            */
            
            st = conn.prepareStatement(
                    "insert into department (Name) values ('D1'), ('D2') ",
                    Statement.RETURN_GENERATED_KEYS);
            
            int rowsAffected = st.executeUpdate();
            
            if (rowsAffected > 0 ) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {                    
                    int id = rs.getInt(1);
                    System.out.println("Done Id="+ id);
                }
            }else{
                System.out.println("No rown affected");
            }
//            to delete 
            st.executeUpdate("delete from department");
            
        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (ParseException ex) {
//            ex.printStackTrace();
        } finally {
            Transmission.closeStatemant(st);
            conn.close();
        }
    }
}
