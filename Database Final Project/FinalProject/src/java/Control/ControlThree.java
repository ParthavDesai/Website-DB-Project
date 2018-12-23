/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbbeans.MenuModel;
import connection.DataAccess;

/**
 *
 * @author Parthav
 */
public class ControlThree extends HttpServlet {
    private DataAccess db;
    public void processAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
            HttpSession s = request.getSession(true);
            String itemId = (String)request.getParameter("ItemId");
            String itemName=(String)request.getParameter("ItemName");
            String itemType=(String)request.getParameter("ItemType");
            String itemCategory = (String)request.getParameter("ItemCategory");
            String description = (String)request.getParameter("ItemDescription");
            String price = (String)request.getParameter("ItemPrice");
            String itemRestaurant = (String)request.getParameter("ItemRestaurantId");
            String addButton = (String)request.getParameter("button5");
            String deleteButton =(String)request.getParameter("button6");
            
            
            MenuModel menuModel = new MenuModel();
            db= new DataAccess();
            System.out.println("here");
            db.openConnection();
            //int id = restModel.existRestaurant(restName, db);
            if(addButton!=null){
                //if(id!=0){
                    menuModel.insertMenu(itemName,itemType,itemCategory,description,price,itemRestaurant,db);
            // }else{
               //  System.out.println("failed");
                }
                
            
            else if(deleteButton!= null){
             //id = restModel.existRestaurant(restName,db);
             // if(id==-1){
                 menuModel.deleteMenu(itemId,db);
             }
           // }
            db.closeConsult();
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        processAction(request,response);
    }
    public void destroy()
    {       
        super.destroy();
    }
}
