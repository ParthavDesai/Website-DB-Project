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
import dbbeans.RestaurantModel;
import connection.DataAccess;

/**
 *
 * @author Parthav
 */
public class control extends HttpServlet {
    private DataAccess db;
    public void processAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
            HttpSession s = request.getSession(true);
            String restId = (String)request.getParameter("RestID");
            String restName=(String)request.getParameter("RestName");
            String restType=(String)request.getParameter("RestType");
            String restUrl = (String)request.getParameter("RestUrl");
            String addButton = (String)request.getParameter("button");
            String deleteButton =(String)request.getParameter("button2");
            
            
            RestaurantModel restModel = new RestaurantModel();
            db= new DataAccess();
            System.out.println("here");
            db.openConnection();
            //int id = restModel.existRestaurant(restName, db);
            if(addButton!=null){
                //if(id!=0){
                    restModel.insertRestaurant(restName,restType,restUrl,db);
            // }else{
               //  System.out.println("failed");
                }
                
            
            else if(deleteButton!= null){
             //id = restModel.existRestaurant(restName,db);
             // if(id==-1){
                 restModel.deleteRestaurant(restId,db);
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
