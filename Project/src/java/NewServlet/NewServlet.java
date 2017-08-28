/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewServlet;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class NewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          Connection conn=null;
          Statement st=null;
          PrintWriter out=resp.getWriter();
          String action = req.getParameter("signup");

          try {
                if("Signup".equals(action)){
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
                
                //Grabbing Data
                String a=req.getParameter("fname");
                String b=req.getParameter("lname");
                String c=req.getParameter("mno");
                String d=req.getParameter("uname");
                String e=req.getParameter("pass");
                String sql="insert into profile values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
                
                //Inserting Record
                st =conn.createStatement();
                st.executeUpdate(sql);
                //out.println("<h1> You are signed up successfully!!! </h1>");
                RequestDispatcher rd=req.getRequestDispatcher("/login.html");
               
                rd.include(req, resp);
                }
             /*String action2=req.getParameter("login");
             if("Login".equals(action2)){   
             try{ //Displaying record  
             ResultSet rs = st.executeQuery("select * from profile;");
             System.out.println("Value in rs  "+rs+"   :  "+rs.next());
            while(rs.next())
            {
               // System.out.println("I am in while loop");
            String fname=rs.getString(1);
            String lname = rs.getString(2);
            String mno=rs.getString(3);
            String uname=rs.getString(4);
            System.out.print(""+fname+"  "+lname+" "+mno+" "+uname+" ");
            }          
            
            */
            } 
          
            catch (ClassNotFoundException ex) { 
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    


    }
    }
 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    


