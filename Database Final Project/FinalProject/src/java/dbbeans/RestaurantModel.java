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
public class RestaurantModel {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private String name;
    private String url;
    private String type;
    private int restaurantID;
    
    public RestaurantModel(){
    }
    public void setRestaurantID(int value){
        this.restaurantID=value;
    }
    public void setName(String value){
        this.name=value;
    }
    public void setType(String value){
        this.type = value;
    }
    public void setUrl(String value){
        this.url = value;
    }
    public int getRestaurantID(){
        return this.restaurantID;
    }
    public String getUrl(){
        return this.url;
    }
    public String getType(){
        return this.type;
    }
    public String getName(){
        return this.name;
    }
    public int existRestaurant(String name, DataAccess db){
        int id=-1;
        String temp;
        connection = db.getConnection();
        try{
            st = connection.createStatement();
            rs  = st.executeQuery("SELECT * FROM public.restaurant");
            System.out.println("qwer");
            while (rs.next())
            {
                temp = rs.getString("name");
                temp = temp.trim();
                if (temp.compareTo(name.trim())==0)
                    id = rs.getInt("RestaurantID");
            }
            rs.close();
            st.close();
            }catch(Exception e){
                System.out.println("Cant read from restaurant table");
            }
        return id;
    }
    public void insertRestaurant(String name,String type,String url,DataAccess db){
        connection = db.getConnection();
        int id = 0;        

        try {
            st = connection.createStatement();
            rs  = st.executeQuery("SELECT max(restaurantid) as id FROM public.restaurant");
            rs.next();

            int max_id = rs.getInt(1);
            id = max_id + 1;
            st.executeUpdate("INSERT INTO public.restaurant(RestaurantID,Name,Type,Url) VALUES ("+id+",'"+ name +"','"+type+"','"+url+"')");

            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into restaurant table");
        }
    }
    public void deleteRestaurant(String tempId,DataAccess db){
       
        connection = db.getConnection();
        try{
            st = connection.createStatement();
            System.out.println("ok");
            int id = Integer.parseInt(tempId);
            System.out.println(""+id);
            System.out.println("ok");
            st.executeUpdate("DELETE FROM public.restaurant WHERE RestaurantID ="+id);
            System.out.println("fuck");
            st.close();
        }catch(Exception e){
            System.out.println("Cant delete from customer table");
        }
    }
    
}
