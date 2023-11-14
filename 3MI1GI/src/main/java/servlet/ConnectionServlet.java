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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/ConnectionServlet")
@MultipartConfig
/*
//파일을 올리기 전에 파일 값을 설정하는 공간
@MultipartConfig (
			// 파일 데이터를 디스크에 기록을 시작하기 전에 메모리에 보유되는 최대크기(1MB);
			fileSizeThreshold = 1024 * 1024,
			// 업로드할 파일의 최대크기(5MB)
			maxFileSize = 1024 * 1024 * 5,
			// 요청 데이터의 최대 크기
			maxRequestSize = 1024 * 1024 * 10,
			// 파일이 디스크에 저장될 임시 디렉터리
			location="/tmp"
		)
*/
public class ConnectionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "sm";
		String jdbcPassword = "sm1234";
//		String jdbcUsername = "SM";
//		String jdbcPassword = "SM1234";
		
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
			
			
			// 회원가입
			if (request_result.equals("request-register")) {
				// 占쏙옙占쏙옙占쏙옙占� ID(회占쏙옙占쏙옙占쌉쏙옙 占쌜쇽옙占쏙옙ID)
				String ID = request.getParameter("ID");
				// 占쏙옙占쏙옙占쏙옙占� 占쏙옙橘占싫�
				String PASSWORD = request.getParameter("PASSWORD");
				// 占쏙옙占쏙옙占쏙옙占� 占쏙옙화占쏙옙호
				String PHONE_NUMBER = request.getParameter("PHONE_NUMBER");
				// 占쏙옙占쏙옙占쏙옙占� 占싱몌옙占쏙옙
				String EMAIL = request.getParameter("EMAIL");
				// 占쏙옙占쏙옙占쏙옙占� 占쌍쇽옙
				String ADDRESS = request.getParameter("ADDRESS");
				
				// sql 占쌘뱄옙占쏙옙占싹울옙占쏙옙 회占쏙옙占쏙옙占쌉울옙 占쌔댐옙占싹댐옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌀뤄옙占승댐옙
				sqlQuery = sql.register();
	            ps = connection.prepareStatement(sqlQuery);

	            ps.setString(1, ID);
	            ps.setString(2, PASSWORD);
	            ps.setString(3, PHONE_NUMBER);
	            ps.setString(4, EMAIL);
	            ps.setString(5, ADDRESS);

	            ps.executeUpdate();
	            
				response.sendRedirect("login.jsp");
	       
			// 로그인
			} else if (request_result.equals("request-login")) {
				
				// 占싸깍옙占싸쏙옙 占쏙옙占실댐옙 ID
				String ID = request.getParameter("ID");
				// 占싸깍옙占싸쏙옙 占쏙옙占실댐옙 PASSWORD
				String PASSWORD = request.getParameter("PASSWORD");
				
				sqlQuery = sql.login();
				ps = connection.prepareStatement(sqlQuery);
				ps.setString(1, ID);
				ps.setString(2, PASSWORD);
				
				result = ps.executeQuery();
				
				// 占싸깍옙占싸쏙옙 1占쏙옙占쏙옙 占쏙옙회 占싹기때占쏙옙占쏙옙 if占쏙옙 占쏙옙占�
				if (result.next()) {
					session.setAttribute("USER_ID", result.getInt("USER_ID"));
					session.setAttribute("ID", result.getString("ID"));
					session.setAttribute("PASSWORD", result.getString("PASSWORD"));
					session.setAttribute("PHONE_NUMBER", result.getString("PHONE_NUMBER"));
					session.setAttribute("EMAIL", result.getString("EMAIL"));
					session.setAttribute("ADDRESS", result.getString("ADDRESS"));
					
					response.sendRedirect("myPage.jsp");
					
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
	            
	            // 以묎컻�씤 �벑濡앹씠 �셿猷뚮릺硫� �빐�떦 �쑀���쓽 以묎컻�씤踰덊샇瑜� �꽭�뀡�뿉 ���옣�븳�떎.
	            sqlQuery = sql.intermediarySearch();
				ps = connection.prepareStatement(sqlQuery);
				
				ps.setInt(1, INTERMEDIARY_USER_ID);
				
				result = ps.executeQuery();
				if (result.next()) {
					int INTERMEDIARY_ID = result.getInt("INTERMEDIARY_ID");
					session.setAttribute("INTERMEDIARY_ID", INTERMEDIARY_ID);
				}
				
	            request.setAttribute("USER_ID", INTERMEDIARY_USER_ID);
	            ServletContext context = this.getServletContext();
	            RequestDispatcher dispatcher = context.getRequestDispatcher("/intermediarySearchAndEdit.jsp"); //占싼깍옙 占쏙옙占쏙옙占쏙옙 占쌍쇽옙
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
				
			// 매물 등록
			} else if (request_result.equals("request-realestate_add")) {
				// 嫄대Ъ�씠由�
				String REALESTATE_NAME = request.getParameter("REALESTATE_NAME");
				// 嫄대Ъ二쇱냼
				String REALESTATE_ADDRESS = request.getParameter("REALESTATE_ADDRESS");
				/// 嫄대Ъ 醫낅쪟
				String REALESTATE_TYPE = request.getParameter("REALESTATE_TYPE");
				// 怨꾩빟議곌굔
				String REALESTATE_CONDITION = request.getParameter("REALESTATE_CONDITION");
				// 硫댁쟻
				double REALESTATE_AREA = Integer.parseInt(request.getParameter("REALESTATE_AREA"));
				// 痢듭닔
				int FLOORS = Integer.parseInt(request.getParameter("FLOORS"));
				// 諛⑷컻�닔
				int ROOMS_COUNT = Integer.parseInt(request.getParameter("ROOMS_COUNT"));
				// �솕�옣�떎 媛쒖닔
				int TOILET_COUNT = Integer.parseInt(request.getParameter("TOILET_COUNT"));
				// 留ㅻℓ媛�
				int REALESTATE_SALEPRICE = Integer.parseInt(request.getParameter("REALESTATE_SALEPRICE"));
				// �썡�꽭
				int REALESTATE_MONTHLY = Integer.parseInt(request.getParameter("REALESTATE_MONTHLY"));	
				// 愿�由щ퉬
				int REALESTATE_MAINTENANCE_COST = Integer.parseInt(request.getParameter("REALESTATE_MAINTENANCE_COST"));
				// �엯二쇨��뒫�씪
				Date AVAILABLE_MOVE_IN_DATE = Date.valueOf(request.getParameter("AVAILABLE_MOVE_IN_DATE"));
				// 二쇱감媛��뒫�닔
				int PARKING_COUNT = Integer.parseInt(request.getParameter("PARKING_COUNT"));
				// �샃�뀡
				String REALESTATE_OPTIION = request.getParameter("REALESTATE_OPTIION");
				// 湲고��궡�슜
				String OTHER_COMMENT = request.getParameter("OTHER_COMMENT");
				
				LocalDate localDate = LocalDate.now();
				// �벑濡앸궇吏�
				Date REALESTATE_DATE = Date.valueOf(localDate);
				// 이미지
				Part imagePart = request.getPart("image");
			
				// 以묎컻�씤 踰덊샇
				int	INTERMEDIARY_ID = (int) session.getAttribute("INTERMEDIARY_ID");
				
				sqlQuery = sql.realestateAdd();
				
				ps = connection.prepareStatement(sqlQuery);
				
				ps.setInt(1, INTERMEDIARY_ID);
				ps.setString(2, REALESTATE_NAME);
				ps.setString(3, REALESTATE_ADDRESS);
				ps.setString(4, REALESTATE_TYPE);
				ps.setString(5, REALESTATE_CONDITION);
				ps.setDouble(6, REALESTATE_AREA);
				ps.setInt(7, FLOORS);
				ps.setInt(8, ROOMS_COUNT);
				ps.setInt(9, TOILET_COUNT);
				ps.setInt(10, REALESTATE_SALEPRICE);
				ps.setInt(11, REALESTATE_MONTHLY);
				ps.setInt(12, REALESTATE_MAINTENANCE_COST);
				ps.setDate(13, AVAILABLE_MOVE_IN_DATE);
				ps.setInt(14, PARKING_COUNT);
				ps.setString(15, REALESTATE_OPTIION);
				ps.setString(16, OTHER_COMMENT);
				ps.setDate(17, REALESTATE_DATE);
				ps.setBinaryStream(18, imagePart.getInputStream(), (int) imagePart.getSize());
				
				ps.executeUpdate();

	            request.setAttribute("INTERMEDIARY_ID", INTERMEDIARY_ID);
	            
	            ServletContext context = this.getServletContext();
	            RequestDispatcher dispatcher = context.getRequestDispatcher("/realestateSearchAndEdit.jsp"); //占싼깍옙 占쏙옙占쏙옙占쏙옙 占쌍쇽옙
	            dispatcher.forward(request, response);
	          
	        // 매물 정보 수정
			} else if (request_result.equals("request-realestate_edit")) {
				// 嫄대Ъ�씠由�
				String REALESTATE_NAME = request.getParameter("REALESTATE_NAME");
				// 嫄대Ъ二쇱냼
				String REALESTATE_ADDRESS = request.getParameter("REALESTATE_ADDRESS");
				/// 嫄대Ъ 醫낅쪟
				String REALESTATE_TYPE = request.getParameter("REALESTATE_TYPE");
				// 怨꾩빟議곌굔
				String REALESTATE_CONDITION = request.getParameter("REALESTATE_CONDITION");
				// 硫댁쟻
				double REALESTATE_AREA = Integer.parseInt(request.getParameter("REALESTATE_AREA"));
				// 痢듭닔
				int FLOORS = Integer.parseInt(request.getParameter("FLOORS"));
				// 諛⑷컻�닔
				int ROOMS_COUNT = Integer.parseInt(request.getParameter("ROOMS_COUNT"));
				// �솕�옣�떎 媛쒖닔
				int TOILET_COUNT = Integer.parseInt(request.getParameter("TOILET_COUNT"));
				// 留ㅻℓ媛�
				int REALESTATE_SALEPRICE = Integer.parseInt(request.getParameter("REALESTATE_SALEPRICE"));
				// �썡�꽭
				int REALESTATE_MONTHLY = Integer.parseInt(request.getParameter("REALESTATE_MONTHLY"));	
				// 愿�由щ퉬
				int REALESTATE_MAINTENANCE_COST = Integer.parseInt(request.getParameter("REALESTATE_MAINTENANCE_COST"));
				// �엯二쇨��뒫�씪
				Date AVAILABLE_MOVE_IN_DATE = Date.valueOf(request.getParameter("AVAILABLE_MOVE_IN_DATE"));
				// 二쇱감媛��뒫�닔
				int PARKING_COUNT = Integer.parseInt(request.getParameter("PARKING_COUNT"));
				// �샃�뀡
				String REALESTATE_OPTIION = request.getParameter("REALESTATE_OPTIION");
				// 湲고��궡�슜
				String OTHER_COMMENT = request.getParameter("OTHER_COMMENT");
				
				// 以묎컻�씤 踰덊샇
				int	INTERMEDIARY_ID = (int) session.getAttribute("INTERMEDIARY_ID");
				
				sqlQuery = sql.realestateEdit();
				
				ps = connection.prepareStatement(sqlQuery);
				
				ps.setString(1, REALESTATE_NAME);
				ps.setString(2, REALESTATE_ADDRESS);
				ps.setString(3, REALESTATE_TYPE);
				ps.setString(4, REALESTATE_CONDITION);
				ps.setDouble(5, REALESTATE_AREA);
				ps.setInt(6, FLOORS);
				ps.setInt(7, ROOMS_COUNT);
				ps.setInt(8, TOILET_COUNT);
				ps.setInt(9, REALESTATE_SALEPRICE);
				ps.setInt(10, REALESTATE_MONTHLY);
				ps.setInt(11, REALESTATE_MAINTENANCE_COST);
				ps.setDate(12, AVAILABLE_MOVE_IN_DATE);
				ps.setInt(13, PARKING_COUNT);
				ps.setString(14, REALESTATE_OPTIION);
				ps.setString(15, OTHER_COMMENT);
				ps.setInt(16, 1);
				ps.setInt(17, INTERMEDIARY_ID);
				
				ps.executeUpdate();
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
