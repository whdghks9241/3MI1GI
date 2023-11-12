package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

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

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "sm";
		String jdbcPassword = "sm1234";
		String sqlQuery = null;
		
		ResultSet result;
		
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
				
				result = ps.executeQuery();
				
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
				
			// 중개인 등록
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
	            
	            // 중개인 등록이 완료되면 해당 유저의 중개인번호를 세션에 저장한다.
	            sqlQuery = sql.intermediarySearch();
				ps = connection.prepareStatement(sqlQuery);
				
				ps.setInt(1, INTERMEDIARY_USER_ID);
				
				result = ps.executeQuery();
				if (result.next()) {
					int INTERMEDIARY_ID = result.getInt("INTERMEDIARY_ID");
					session.setAttribute("INTERMEDIARY_ID", INTERMEDIARY_ID);
				}
				
	            request.setAttribute("USER_ID", INTERMEDIARY_USER_ID);
	            System.out.println("INTERMEDIARY_USER_ID : " + INTERMEDIARY_USER_ID);
	            ServletContext context = this.getServletContext();
	            RequestDispatcher dispatcher = context.getRequestDispatcher("/intermediarySearchAndEdit.jsp"); //�ѱ� ������ �ּ�
	            dispatcher.forward(request, response);
	   
	        // 중개인 정보 수정
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
				
			// 매물등록
			} else if (request_result.equals("request-realestate_add")) {
				// 건물이름
				String REALESTATE_NAME = request.getParameter("REALESTATE_NAME");
				// 건물주소
				String REALESTATE_ADDRESS = request.getParameter("REALESTATE_ADDRESS");
				/// 건물 종류
				String REALESTATE_TYPE = request.getParameter("REALESTATE_TYPE");
				// 계약조건
				String REALESTATE_CONDITION = request.getParameter("REALESTATE_CONDITION");
				// 면적
				double REALESTATE_AREA = Integer.parseInt(request.getParameter("REALESTATE_AREA"));
				// 층수
				int FLOORS = Integer.parseInt(request.getParameter("FLOORS"));
				// 방개수
				int ROOMS_COUNT = Integer.parseInt(request.getParameter("ROOMS_COUNT"));
				// 화장실 개수
				int TOILET_COUNT = Integer.parseInt(request.getParameter("TOILET_COUNT"));
				// 매매가
				int REALESTATE_SALEPRICE = Integer.parseInt(request.getParameter("REALESTATE_SALEPRICE"));
				// 월세
				int REALESTATE_MONTHLY = Integer.parseInt(request.getParameter("REALESTATE_MONTHLY"));	
				// 관리비
				int REALESTATE_MAINTENANCE_COST = Integer.parseInt(request.getParameter("REALESTATE_MAINTENANCE_COST"));
				// 입주가능일
				Date AVAILABLE_MOVE_IN_DATE = Date.valueOf(request.getParameter("AVAILABLE_MOVE_IN_DATE"));
				// 주차가능수
				int PARKING_COUNT = Integer.parseInt(request.getParameter("PARKING_COUNT"));
				// 옵션
				String REALESTATE_OPTIION = request.getParameter("REALESTATE_OPTIION");
				// 기타내용
				String OTHER_COMMENT = request.getParameter("OTHER_COMMENT");
				
				LocalDate localDate = LocalDate.now();
				// 등록날짜
				Date REALESTATE_DATE = Date.valueOf(localDate);
			
				// 사용자 번호
				int REALESTATE_ID = (int) session.getAttribute("USER_ID");
				// 중개인 번호
				int	INTERMEDIARY_ID = (int) session.getAttribute("INTERMEDIARY_ID");
				
				sqlQuery = sql.realestateAdd();
				
				ps = connection.prepareStatement(sqlQuery);
				
				ps.setInt(1, REALESTATE_ID);
				ps.setInt(2, INTERMEDIARY_ID);
				ps.setString(3, REALESTATE_NAME);
				ps.setString(4, REALESTATE_ADDRESS);
				ps.setString(5, REALESTATE_TYPE);
				ps.setString(6, REALESTATE_CONDITION);
				ps.setDouble(7, REALESTATE_AREA);
				ps.setInt(8, FLOORS);
				ps.setInt(9, ROOMS_COUNT);
				ps.setInt(10, TOILET_COUNT);
				ps.setInt(11, REALESTATE_SALEPRICE);
				ps.setInt(12, REALESTATE_MONTHLY);
				ps.setInt(13, REALESTATE_MAINTENANCE_COST);
				ps.setDate(14, AVAILABLE_MOVE_IN_DATE);
				ps.setInt(15, PARKING_COUNT);
				ps.setString(16, REALESTATE_OPTIION);
				ps.setString(17, OTHER_COMMENT);
				ps.setDate(18, REALESTATE_DATE);
				
				ps.executeUpdate();

	            request.setAttribute("REALESTATE_ID", REALESTATE_ID);
	            request.setAttribute("INTERMEDIARY_ID", INTERMEDIARY_ID);

	            ServletContext context = this.getServletContext();
	            RequestDispatcher dispatcher = context.getRequestDispatcher("/intermediarySearchAndEdit.jsp"); //�ѱ� ������ �ּ�
	            dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
