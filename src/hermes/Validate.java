package hermes;

import java.sql.ResultSet;

public class Validate {
    
    public static boolean matchPassword(String username, String password){
        
        try{
            ResultSet rs = Hermes.returnQuery("Select password from profile where username = '"+username+"';");
            if(rs.next() && password.equals(rs.getString(1))){
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
            return false;
        }
    }
    
    public static boolean matchSecurityCode(String username, int securityCode){
        
        try{
            ResultSet rs = Hermes.returnQuery("Select securitycode from profile where username = '"+username+"';");
            if(rs.next() && securityCode==rs.getInt(1)){
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
            return false;
        }
    }
}
