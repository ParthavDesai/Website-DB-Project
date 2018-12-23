/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbeans;

import connection.DataAccess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Parthav
 */
public class MenuModel {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    
    public void insertMenu(String name,String type,String category,String description,String tempPrice,String tempRestID,DataAccess db){
        connection = db.getConnection();
        int id = 0;
        try {
            st = connection.createStatement();
            rs  = st.executeQuery("SELECT max(itemid) as id FROM public.MenuItem");
            rs.next();
            int max_id = rs.getInt(1);
            id = max_id + 1;
            double price = Double.parseDouble(tempPrice);
            int restID = Integer.parseInt(tempRestID);
            st.executeUpdate("INSERT INTO public.MenuItem(ItemID,Name,Type,Category,Description,Price,RestaurantID) VALUES ("+id+",'"+ name +"','"+type+"','"+category+"','"+description+"',"+price+","+restID+")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into MenuItem table");
        }
    }
    public void deleteMenu(String tempId,DataAccess db){
       
        connection = db.getConnection();
        try{
            st = connection.createStatement();
            int id = Integer.parseInt(tempId);
            st.executeUpdate("DELETE FROM public.MenuItem WHERE ItemID ="+id);
            st.close();
        }catch(Exception e){
            System.out.println("Cant delete from Menuitem table");
        }
    }

    
}