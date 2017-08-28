/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Utkarsh
 */
public class eadmin extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    @SuppressWarnings("empty-statement")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn=null;
        Statement st=null;
        String action=req.getParameter("submit");
        if(action.equals("Submit")){
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
                String name=null;
                String gen=null;
                int age;
                String dateob=null;
                
                    name=req.getParameter("name");
                    gen=req.getParameter("gen");
                    age=Integer.parseInt("age");
                    dateob=req.getParameter("dob");
                String sql="insert into eadmin(name,gender,age,dob) values('"+name+"','"+gen+"','"+age+"','"+dateob+"');";
                try {
                    PreparedStatement pst = conn.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery();
                
        }   catch (SQLException ex) {
                Logger.getLogger(eadmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(NumberFormatException ex){
                
            }
               
            }            
        
    }
}

