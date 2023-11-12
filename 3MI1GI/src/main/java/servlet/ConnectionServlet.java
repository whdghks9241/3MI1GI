package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "sm";
		String jdbcPassword = "sm1234";
		String sqlQuery = null;
		
		sql sql = new sql();
		PreparedStatement ps;
		HttpSession session = request.getSession();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
	
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		
			String request_result = request.getParameter("request");
			
			// ȸ������ �� ���
			if (request_result.equals("request-register")) {
				// ������� ID(ȸ�����Խ� �ۼ���ID)
				String ID = request.getParameter("ID");
				// ������� ��й�ȣ
				String PASSWORD = request.getParameter("PASSWORD");
				// ������� ��ȭ��ȣ
				String PHONE_NUMBER = request.getParameter("PHONE_NUMBER");
				// ������� �̸���
				String EMAIL = request.getParameter("EMAIL");
				// ������� �ּ�
				String ADDRESS = request.getParameter("ADDRESS");
				
				// sql �ڹ����Ͽ��� ȸ�����Կ� �ش��ϴ� �������� �ҷ��´�
				sqlQuery = sql.register();
	            ps = connection.prepareStatement(sqlQuery);

	            ps.setString(1, ID);
	            ps.setString(2, PASSWORD);
	            ps.setString(3, PHONE_NUMBER);
	            ps.setString(4, EMAIL);
	            ps.setString(5, ADDRESS);

	            ps.executeUpdate();
	            
				response.sendRedirect("login.jsp");
	       
			} else if (request_result.equals("request-login")) {
				
				// �α��ν� ���Ǵ� ID
				String ID = request.getParameter("ID");
				// �α��ν� ���Ǵ� PASSWORD
				String PASSWORD = request.getParameter("PASSWORD");
				
				// �α��ο� �ش��ϴ� ������ �ҷ�����
				
				sqlQuery = sql.login();
				ps = connection.prepareStatement(sqlQuery);
				ps.setString(1, ID);
				ps.setString(2, PASSWORD);
				
				ResultSet result = ps.executeQuery();
				
				// �α��ν� 1���� ��ȸ �ϱ⶧���� if�� ���
				if (result.next()) {
					
					session.setAttribute("USER_ID", result.getInt("USER_ID"));
					session.setAttribute("ID", result.getString("ID"));
					session.setAttribute("PASSWORD", result.getString("PASSWORD"));
					session.setAttribute("PHONE_NUMBER", result.getString("PHONE_NUMBER"));
					session.setAttribute("EMAIL", result.getString("EMAIL"));
					session.setAttribute("ADDRESS", result.getString("ADDRESS"));
					
					response.sendRedirect("Main.jsp");
					
				} else {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			} else if (request_result.equals("request-inermediary_add")) {
				
				String BUSINESS_NUMBER = request.getParameter("BUSINESS_NUMBER");
				String CEO_NAME = request.getParameter("CEO_NAME");
				String COMPANY_NAME = request.getParameter("COMPANY_NAME");
				String COMPANY_ADDRESS = request.getParameter("COMPANY_ADDRESS");
				String CONTACT_START_TIME = request.getParameter("CONTACT_START_TIME");
				String CONTACT_END_TIME = request.getParameter("CONTACT_END_TIME");
				int INTERMEDIARY_USER_ID = (int) session.getAttribute("USER_ID");

				sqlQuery = sql.intermediaryAdd();
	            ps = connection.prepareStatement(sqlQuery);

	            ps.setString(1, BUSINESS_NUMBER);
	            ps.setString(2, CEO_NAME);
	            ps.setString(3, COMPANY_NAME);
	            ps.setString(4, COMPANY_ADDRESS);
	            ps.setString(5, CONTACT_START_TIME);
	            ps.setString(6, CONTACT_END_TIME);
	            ps.setInt(7, INTERMEDIARY_USER_ID);
	            
	            ps.executeUpdate();
	            
	            request.setAttribute("USER_ID", INTERMEDIARY_USER_ID);

	            ServletContext context = this.getServletContext();
	            RequestDispatcher dispatcher = context.getRequestDispatcher("/intermediarySearchAndEdit.jsp"); //�ѱ� ������ �ּ�
	            dispatcher.forward(request, response);
	   
			} else if (request_result.equals("request-inermediary_edit")) {
				
				String BUSINESS_NUMBER = request.getParameter("BUSINESS_NUMBER");
				String CEO_NAME = request.getParameter("CEO_NAME");
				String COMPANY_NAME = request.getParameter("COMPANY_NAME");
				String COMPANY_ADDRESS = request.getParameter("COMPANY_ADDRESS");
				String CONTACT_START_TIME = request.getParameter("CONTACT_START_TIME");
				String CONTACT_END_TIME = request.getParameter("CONTACT_END_TIME");
				int INTERMEDIARY_USER_ID = (int) session.getAttribute("USER_ID");

				sqlQuery = sql.intermediaryEdit();
				
				ps = connection.prepareStatement(sqlQuery);

				ps.setString(1, CEO_NAME);
				ps.setString(2, COMPANY_NAME);
				ps.setString(3, COMPANY_ADDRESS);
				ps.setString(4, CONTACT_START_TIME);
				ps.setString(5, CONTACT_END_TIME);
				ps.setInt(6, INTERMEDIARY_USER_ID);
				ps.setString(7, BUSINESS_NUMBER);
				
				ps.executeUpdate();
				
				response.sendRedirect("realestateAdd.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
