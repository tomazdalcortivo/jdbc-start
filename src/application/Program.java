package application;

import db.DB;
import java.sql.*;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}
