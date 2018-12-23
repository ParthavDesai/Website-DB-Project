/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import java.sql.*;
/**
 *
 * @author Parthav
 */
public class DataAccess {


    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public DataAccess()
    {
    }
    
    public Connection getConnection()
    {
        return connection;
    }    
    

    public void openConnection() {
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/?currentSchema=public",
                                                     "postgres","Parthav");
            System.out.println("Connection Established");
        }catch(Exception e){
            System.out.println("No connection established: "+e.toString());
        }
    }


    

    public boolean siguiente() {
        try {
            return (rs.next());
        } catch(Exception e){
            System.out.println("Error moving to the next one");
            return false;
        }
    }


    public String getField(String name){
        try {
            return (rs.getString(name));
        } catch(Exception e){
            System.out.println("Error getting the field");
            return "";
        }
    }
    

   public void closeConsult(){
        try {
            rs.close();
            st.close();
        } catch(Exception e){}
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e){}
    }
    

   
}
