package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class Transmission {

    public Connection Connect() throws SQLException {
        
        try {
            //1º Carga do driver
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            //2º Parâmetros de conexão

            //endereço do servidor
            //porta do servidor
            String url = "jdbc:mysql://localhost:3306/coursejbdc?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8";
            //usuário
            String usuario = "root";
            //senha - mesmo que seja ""
            String senha = "mysql"; //no lab mysql
           
            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Não encontrei o Driver");
            System.exit(0);
        } catch (SQLException ex) {
            System.out.println("Não conectou com o banco de dados. Verifique os parâmetros de conexão.");
            System.out.println(ex);
            throw ex;
    }
        return null;
}
    
    public static void closeStatemant(Statement st){
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Transmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closePreparedStatement(PreparedStatement ps){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public  static void closeConnection(Connection conn){
        if (conn != null) {
            try {
            conn.close();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Transmission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
}
