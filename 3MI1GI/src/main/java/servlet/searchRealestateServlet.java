package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchRealestateServlet
 */
@WebServlet("/searchRealestateServlet")
public class searchRealestateServlet extends HttpServlet {

	
	String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String jdbcUsername = "sm";
	String jdbcPassword = "sm1234";
//	String jdbcUsername = "SM";
//	String jdbcPassword = "SM1234";
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
	        String[] realestateTypes = request.getParameterValues("realestate_type");
	        String[] buildTypes = request.getParameterValues("build_type");
	        String[] areas = request.getParameterValues("area");
	        String[] totalRooms = request.getParameterValues("total_room");
	        String[] toiletcount = request.getParameterValues("toilet_count");
	        
	        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM REALESTATE_TYPE WHERE 1 = 1");
	        
	        if (realestateTypes != null && realestateTypes.length > 0) {
	            sqlBuilder.append(" AND realestate_type IN (");
	            for (String type : realestateTypes) {
	                sqlBuilder.append("'").append(type).append("',");
	            }
	            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
	            sqlBuilder.append(")");
	        }
	        
	        if (buildTypes != null && buildTypes.length > 0) {
	            sqlBuilder.append(" AND REALESTATE_CONDITION IN (");
	            for (String type : buildTypes) {
	                sqlBuilder.append("'").append(type).append("',");
	            }
	            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
	            sqlBuilder.append(")");
	        }
	        
	        if (areas != null && areas.length > 0) {
	            sqlBuilder.append(" AND REALESTATE_AREA IN (");
	            for (String type : areas) {
	            	sqlBuilder.append("'").append(type).append("',");
	                
	            }
	            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
	            sqlBuilder.append(")");
	        }
	        
	        if (totalRooms != null && totalRooms.length > 0) {
	            sqlBuilder.append(" AND ROOMS_COUNT IN (");
	            for (String type : totalRooms) {
	                sqlBuilder.append("'").append(type).append("',");
	            }
	            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
	            sqlBuilder.append(")");
	        }
	        
	        if (toiletcount != null && toiletcount.length > 0) {
	            sqlBuilder.append(" AND TOILET_COUNT IN (");
	            for (String type : toiletcount) {
	                sqlBuilder.append("'").append(type).append("',");
	            }
	            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
	            sqlBuilder.append(")");
	        }
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
