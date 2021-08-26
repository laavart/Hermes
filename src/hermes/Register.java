package hermes;

import java.sql.ResultSet;

public class Register {
    
    public static boolean checkUsename(String username){
        
        try{
            ResultSet rs = Hermes.returnQuery("Select * from profile where username = '"+username+"';");
            if(rs.next()){
                rs.close();
                return true;
            }
            else{
                rs.close();
                return false;
            }
        }
        catch (Exception e){
            System.out.println("Error in Retrieving Data...");
            return true;
        }
    }
    
    public static boolean checkPassword(String password){
        
        try{
            ResultSet rs = Hermes.returnQuery("Select * from profile where password = '"+password+"';");
            if(rs.next()){
                rs.close();
                return true;
            }
            else{
                rs.close();
                return false;
            }
        }
        catch (Exception e){
            System.out.println("Error in Retrieving Data...");
            return true;
        }
    }
    
    public static boolean checkSecurityCode(int securityCode){
        
        try{
            ResultSet rs = Hermes.returnQuery("Select securitycode from profile where securitycode = "+securityCode+";");
            if(rs.next()){
                rs.close();
                return true;
            }
            else{
                rs.close();
                return false;
            }
        }
        catch (Exception e){
            System.out.println("Error in Retrieving Data...");
            return true;
        }
    }
}