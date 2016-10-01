import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 


public class RequestSample1 extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{
      id1 = request.getParameter("id1");
      id2 = request.getParameter("id2");
  }
}

public class ConnectionClass {
     int result;

     int id1, id2;

     char letter;

    static final String URL = "jdbc:mysql://localhost/database1";
    static final String USERNAME = "root";
    static final String PASSWORD = "0";
 
    public static void main(String[] args) {
          try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
                Statement statement = connection.createStatement();
                ) {
       
            String sql = "SELECT letter from database1";

            id1 = RequestSample1.id1;
            id2 = RequestSample1.id2;

            if(id1 == null){
                if(id2 == null){
                    System.out.println("NG302");
                }else if( id2 < 1 || id2 > 1000000){
                    Sytem.out.println("NG303");
                }else{
                    sql += " where id2 = " + id2;
                    //rs = mysqli_query(con,msg);
                    result = statement.executeUpdate(sql);
                    
                    while(result.next()){
                        letter = result.getString("letter");
                    }
                    System.out.println("OK id2 " + id2 + " "+ letter);
                }
            }else if(id2 != null){            
                System.out.println("NG301");        
            }else if(id1 < 1 || id1 > 1000000){         
                System.out.println("NG303");
            }else{   
                sql += " where id1 = " + id1;
                result = statement.executeUpdate(sql);
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

