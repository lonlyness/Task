import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class RequestClass extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{
 
	  int id1 = request.getParameter(id1);
      int id2 = request.getParameter(id2);
      
      char letter;
      
      final String URL = "jdbc:mysql://localhost/database1";
      final String USERNAME = "root";
      final String PASSWORD = "0";
      
      
           try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
                Statement statement = connection.createStatement();
                ) {
       
            String sql = "SELECT letter from database1";
           

            if(id1 == 0){
                if(id2 == 0){
                    System.out.println("NG302");
                }else if( id2 < 1 || id2 > 1000000){
                    System.out.println("NG303");
                }else{
                    sql += " where id2 = " + id2;
                    //rs = mysqli_query(con,msg);
                    Resultset result = statement.executeUpdate(sql);
                    
                    while(result.next()){
                        letter = result.getString("letter");
                    }
                    System.out.println("OK id2 " + id2 + " "+ letter);
                }
            }else if(id2 != 0){            
                System.out.println("NG301");        
            }else if(id1 < 1 || id1 > 1000000){         
                System.out.println("NG303");
            }else{   
                sql += " where id1 = " + id1;
                Resultset result = statement.executeUpdate(sql);
                while(result.next()){
                        letter = result.getString("letter");
                }
                System.out.println("OK id1 " + id1 + " "+ letter);
            }
        } catch (SQLException e) {  
            e.printStackTrace();   
        }
    } 
      
  }
