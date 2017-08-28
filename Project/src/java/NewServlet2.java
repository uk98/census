/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Utkarsh
 */
public class NewServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action2=req.getParameter("login");
            Connection conn=null;
            Statement st=null;
            String a=req.getParameter("uname");
            String b=req.getParameter("pass");
            PrintWriter out=resp.getWriter();
             if("Login".equals(action2)){   
             try{ //Displaying record  
                String driverName = "oracle.jdbc.driver.OracleDriver";
                Class.forName(driverName);
                String serverName="LAPTOP-RQ918CCJ";
                String serverPort ="1521";
                String sid="XE";
                String url="jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
                String username = "system";//User created through SQL Command Line
                String password = "system";//password of this user
                conn = DriverManager.getConnection(url,username,password);
                System.err.println("Succesfully connected to database :::  "+conn);
             
                st =conn.createStatement();
                String uname1=null;             
                do
                    {                        
                       uname1=req.getParameter("uname");
                    }while ( uname1.length()==0) ;
                String sql="select * from admin where uname ='"+uname1+"'";
                 switch (uname1) {
                     case "eadmin":
                         {
                             RequestDispatcher rd=req.getRequestDispatcher("/eadmin.html");
                             rd.include(req, resp);
                             break;
                         }
                     case "wadmin":
                         {
                             RequestDispatcher rd=req.getRequestDispatcher("/wadmin.html");
                             rd.include(req, resp);
                             break;
                         }
                     default:
                     { 
                       out.print("<h1>Please Login again.Wrong username or password.Login.</h1>");
                       RequestDispatcher rd=req.getRequestDispatcher("/login.html");
                       rd.include(req, resp);
                       break;
                     }
                 }
    }       catch (SQLException ex) {
                Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewServlet2.class.getName()).log(Level.SEVERE, null, ex);
                }
             catch(NullPointerException ex){
                 
             }

    
    
    }

    

}
}
