package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntermediaryDAO {
	
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "SM";
	private static final String jdbcPassword = "SM1234";
	
	PreparedStatement ps;
	ResultSet resultSet;
	Intermediary intermediary = null;
	String sql;
	
	public IntermediaryDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Intermediary getIntermediaryInfo(int USER_ID) {
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			sql = "SELECT * FROM intermediary WHERE INTERMEDIARY_USER_ID = ?";
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, USER_ID);
			
			resultSet = ps.executeQuery();
			
			if (resultSet.next()) {
				int INTERMEDIARY_ID = resultSet.getInt("INTERMEDIARY_ID");
				String BUSINESS_NUMBER = resultSet.getString("BUSINESS_NUMBER");
				String CEO_NAME = resultSet.getString("CEO_NAME");
				String COMPANY_NAME = resultSet.getString("COMPANY_NAME");
				String COMPANY_ADDRESS = resultSet.getString("COMPANY_ADDRESS");
				String CONTACT_START_TIME = resultSet.getString("CONTACT_START_TIME");
				String CONTACT_END_TIME = resultSet.getString("CONTACT_END_TIME");
				int INTERMEDIARY_USER_ID = resultSet.getInt("INTERMEDIARY_USER_ID");
			
				intermediary = new Intermediary(INTERMEDIARY_ID, BUSINESS_NUMBER, CEO_NAME, COMPANY_NAME, COMPANY_ADDRESS, CONTACT_START_TIME, CONTACT_END_TIME, INTERMEDIARY_USER_ID);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// select 해서 1만 볼수 있는 쿼리 작성하고
		// new product 이용해서 값 가져오기;
		
		return intermediary;
	
	}

}
