package hermes;

import java.sql.*;

public class Hermes {
    
    public static ResultSet returnQuery(String Query){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hermes","root","1609");
            Statement stmt = con.createStatement();
            return stmt.executeQuery(Query);
        }
        catch(Exception e){
            System.out.println("Error in Connectivity...");
            return null;
        }
    }
    
    public static void updateQuery(String Query){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hermes","root","1609");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(Query);
        }
        catch(Exception e){
            System.out.println("Error in Connectivity...");
        }
    }

    public static void main(String[] args) {
        
        if(Facility.checkNullProfile()){
            new SignUp().setVisible(true);
        }
        else{
            new LogIn().setVisible(true);
        }
    }
}
