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
import dbbeans.RaterModel;
import connection.DataAccess;

/**
 *
 * @author Parthav
 */
public class ControlTwo extends HttpServlet {
    private DataAccess db;
    public void processAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
            HttpSession s = request.getSession(true);
            String userId = (String)request.getParameter("UserId");
            String userName=(String)request.getParameter("Name");
            String email=(String)request.getParameter("Email");
            String userType = (String)request.getParameter("Type");
            String date = (String)request.getParameter("Date");
            String reputation = (String)request.getParameter("Reputation");
            String addButton = (String)request.getParameter("button3");
            String deleteButton =(String)request.getParameter("button4");
            
            
            RaterModel rateModel = new RaterModel();
            db= new DataAccess();
            System.out.println("here");
            db.openConnection();
            //int id = restModel.existRestaurant(restName, db);
            if(addButton!=null){
                //if(id!=0){
                    rateModel.insertRater(userName,date,email,userType,reputation,db);
            // }else{
               //  System.out.println("failed");
                }
                
            
            else if(deleteButton!= null){
             //id = restModel.existRestaurant(restName,db);
             // if(id==-1){
                 rateModel.deleteRater(userId,db);
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
