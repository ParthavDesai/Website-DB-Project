/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbeans;
import connection.DataAccess;
import java.sql.*;
/**
 *
 * @author Parthav
 */
public class RaterModel {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    
    public void insertRater(String name,String date,String email,String type,String tempReputation,DataAccess db){
        connection = db.getConnection();
        int id = 0;
        int reputation = Integer.parseInt(tempReputation);

        try {
            st = connection.createStatement();
            rs  = st.executeQuery("SELECT max(userid) as id FROM public.Rater");
            rs.next();
            System.out.println("hello");
            int max_id = rs.getInt(1);
            id = max_id + 1;
            st.executeUpdate("INSERT INTO public.Rater(UserID,Email,Name,JoinDate,Type,Reputation) VALUES ("+id+",'"+ email +"','"+name+"','"+date+"','"+type+"',"+reputation+")");
            System.out.println("bye");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into restaurant table");
        }
    }
    public void deleteRater(String tempId,DataAccess db){
       
        connection = db.getConnection();
        try{
            st = connection.createStatement();
            int id = Integer.parseInt(tempId);
            st.executeUpdate("DELETE FROM public.Rater WHERE UserID ="+id);
            st.close();
        }catch(Exception e){
            System.out.println("Cant delete from customer table");
        }
    }

    
}
