/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPack;

/**
 *
 * @author Shiva
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnectivity {
     Connection con;
    Statement stmt;
    ResultSet rs;
    public MyConnectivity()
            {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/mher","root","");
            stmt=con.createStatement();
             
            
        }
        catch(Exception e)
        {
            
            
        }
    }
    public String Manipulation(String qry)
    {
        try
        {
        stmt.executeUpdate(qry);
        try {
                FileWriter fw= new FileWriter(new File("E://error.txt"));
                fw.write("inserted");
                fw.flush();
            } catch (IOException ex) {
                Logger.getLogger(MyConnectivity.class.getName()).log(Level.SEVERE, null, ex);
            }
        return "success";
        }
        catch(Exception e)
        {
            try {
                FileWriter fw= new FileWriter(new File("E://error.txt"));
                fw.write("Erorrrrrrrrrrrrrrrrrr"+e.getMessage());
                fw.flush();
            } catch (IOException ex) {
                Logger.getLogger(MyConnectivity.class.getName()).log(Level.SEVERE, null, ex);
            }
           return e.getMessage();
        }
    }
    public String getSingleData(String qry2 )//get single  rows and column
    {
        try
        {
            rs=stmt.executeQuery(qry2);
            if(rs.next())
          {
            return rs.getString(1);
          }
      }
       catch(Exception e)
        {
            return e.getMessage()+"error";
        }
        return "";
    }
   
    public ResultSet getTable(String qry2)   //multipls tables 
    {
        try
        {
            rs=stmt.executeQuery(qry2);
            return rs;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    public String  alert(String msg,String location)
    {
        
        //System.out.println("<script>alert('"+message+"');location.href='"+path+";'</script>");
        return("<script type='text/javascript'>alert('"+msg+"');location.href='"+location+"'; </script>");
   
    }
    
}





