<%-- 
    Document   : index
    Created on : Apr 6, 2018, 7:54:14 PM
    Author     : Parthav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h2>Add/Delete Restaurant</h2>
        <form action="control" method="POST">
        <table>
            <tr>
                <td>RestaurantId(Only to delete):</td>
                <td><input type="text" name="RestID"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name ="RestName"/></td>
            </tr>
            <tr>
                <td>Type:</td>
                <td><input type="text" name ="RestType"/></td>
            </tr>
            <tr>
                <td>URL:</td>
                <td><input type="text" name ="RestUrl"/></td>
            </tr> 
            <tr>
                <td><input type="Submit" name ="button" value ="Add"/></td>
                <td><input type="Submit" name ="button2" value ="Delete"</td>
            </tr>
        </table>
        </form>
            <h2>Add/Delete Rater</h2>
         <form action="ControlTwo" method="POST">
        <table>
            <tr>
                <td>UserId(Only to delete):</td>
                <td><input type="text" name="UserId"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name ="Name"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name ="Email"/></td>
            </tr>
            <tr>
                <td>Type:</td>
                <td><input type="text" name ="Type"/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="text" name ="Date"/></td>
            </tr>
            <tr>
                <td>Reputation(Between 1-5):</td>
                <td><input type="text" name ="Reputation"/></td>
            </tr> 
            <tr>
                <td><input type="Submit" name ="button3" value ="Add"/></td>
                <td><input type="Submit" name ="button4" value ="Delete"</td>
            </tr>
        </table>
            </form>
            <h2>Add/Delete Menu Item</h2>
         <form action="ControlThree" method="POST">
        <table>
            <tr>
                <td>ItemID(Only to delete):</td>
                <td><input type="text" name="RestaurantId"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name ="ItemName"/></td>
            </tr>
            <tr>
                <td>Type(Food or Beverage):</td>
                <td><input type="text" name ="ItemType"/></td>
            </tr>
            <tr>
                <td>Category(Main,Appetizer,Desert):</td>
                <td><input type="text" name ="ItemCategory"/></td>
            </tr> 
            <tr>
                <td>Description:</td>
                <td><input type="text" name ="ItemDescription"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name ="ItemPrice"/></td>
            </tr>
            <tr>
                <td>RestaurantID:</td>
                <td><input type="text" name ="ItemRestaurantId"/></td>
            </tr>
            <tr>
                <td><input type="Submit" name ="button5" value ="Add"/></td>
                <td><input type="Submit" name ="button6" value ="Delete"</td>
            </tr>
        </table>
            </form>
    </body>
</html>
