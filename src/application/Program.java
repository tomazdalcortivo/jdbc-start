package application;

import java.sql.*;
import db.Transmission;

public class Program {

    public static void main(String[] args) throws SQLException {
//        Transmission trans = new Transmission();
//        Connection conn = trans.Connect();
        Connection conn = null; 
        Statement st = null;
        
        // create output table  
        ResultSet rs = null;
        Transmission trans = new Transmission();
        
        try{
            conn = trans.Connect();
            st = conn.createStatement();
            
            rs = st.executeQuery("select * from department ");
            
            // work while exists a next 
            while (rs.next()) {                
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch(SQLException e ){
            e.printStackTrace();
        } finally {
            Transmission.closeResultSet(rs);
            Transmission.closeStatemant(st);
            conn.close();
        }
    }
}
