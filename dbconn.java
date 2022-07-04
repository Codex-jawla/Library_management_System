package project;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbconn {
     static Connection c;
     static Statement s;
    public dbconn(){
        String JdbcURL = "jdbc:mysql://localhost:3306/library?" + "autoReconnect=true&useSSL=false";
        String Username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             c= DriverManager.getConnection(JdbcURL,Username,password);
             s=c.createStatement();

        }catch ( Exception e){
            JOptionPane.showMessageDialog(null,e);
            }}

    public static void main(String[] args) {
        new dbconn();
        System.out.println("Database Connected");
    }
}
