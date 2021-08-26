package hermes;

import java.sql.ResultSet;

public class Facility {
    
    public static void changePassword(String username, String password){
        
        try{
            Hermes.updateQuery("Update profile set password = '"+password+"' where username = '"+username+"';");
        }
        catch (Exception e){
            System.out.println("Error in Updating Data...");
        }
    }
    
     public static boolean checkNullProfile(){
        
         try{
            ResultSet rs = Hermes.returnQuery("Select * from profile");
            if(rs.next()){
                rs.close();
                return false;
            }
            else{
                rs.close();
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Error in Retrieving Data...");
            return true;
        }
    }
     
     public static int countUsers(){
        
        try{
            ResultSet rs = Hermes.returnQuery("select max(srno) from profile;");
            if(rs.next()){
                int count = rs.getInt(1);
                rs.close();
                return count;
            }
            else{
                rs.close();
                return 0;
            }
        }
        catch (Exception e){
            System.out.println("Error in Retrieving Data...");
            return 0;
        }   
    }
    
    public static void registerUser(String username, String password, int securityCode){
        
        try{
            Hermes.updateQuery("insert into profile values("+(countUsers()+1)+",'"+username+"','"+password+"',"+securityCode+");");
        }
        catch (Exception e){
            System.out.println("Error in Registering Data...");
        }
    }
}
