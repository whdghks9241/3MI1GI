package servlet;

public class sql {
    private String sql;
    
    // 회원가입
    public String register() {
    	
        sql = "INSERT INTO USERINFO (ID, PASSWORD, PHONE_NUMBER, EMAIL, ADDRESS) VALUES (?, ?, ?, ?, ?)";
        return sql;
        
    }
    
    public String idDuplicateCheck() {
    	
    	sql = "SELECT ID FROM USERINFO WHERE ID = ?"; 
    	
    	return sql;
 
    }
    
    // 로그인
    public String login() {
    	
    	sql = "SELECT * FROM USERINFO WHERE ID =? AND PASSWORD = ?";
    	return sql;
    	
    }
    
    // 중개인 등록
    public String intermediaryAdd() {
    	
        sql = "INSERT INTO intermediary(BUSINESS_NUMBER, CEO_NAME, COMPANY_NAME, COMPANY_ADDRESS, CONTACT_START_TIME, CONTACT_END_TIME, "
        		+ "INTERMEDIARY_USER_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return sql;
        
    }
    
    // 중개인 정보 조회
    public String intermediarySearch() {
    	
        sql = "SELECT * FROM intermediary WHERE INTERMEDIARY_USER_ID =?";
        return sql;
        
    }
    
    // 중개인 정보 수정
    public String intermediaryEdit() {
    	
        sql = "UPDATE intermediary SET CEO_NAME = ?, COMPANY_NAME = ?, COMPANY_ADDRESS = ?, CONTACT_START_TIME = ?, "
        		+ "CONTACT_END_TIME = ? WHERE INTERMEDIARY_USER_ID = ? AND BUSINESS_NUMBER = ?";
       
        return sql; 
    }
    
    // 매물등록
    public String realestateAdd() {
    	
    	sql = "INSERT INTO REALESTATEINFO(INTERMEDIARY_ID, REALESTATE_NAME, REALESTATE_ADDRESS, REALESTATE_TYPE, REALESTATE_CONDITION, REALESTATE_AREA, "
    			+ "FLOORS, ROOMS_COUNT, TOILET_COUNT, REALESTATE_SALEPRICE, REALESTATE_MONTHLY, REALESTATE_MAINTENANCE_COST, AVAILABLE_MOVE_IN_DATE, PARKING_COUNT, "
    			+ "REALESTATE_OPTIION, OTHER_COMMENT, REALESTATE_DATE, REALESTATE_PHOTOS, PLAIN_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	
    	return sql;
    	
    }
    // 전체매물 조회
    public String realestateSearch() {
    	
    	sql = "SELECT * FROM REALESTATEINFO WHERE INTERMEDIARY_ID = ?";
    	
    	return sql;
    }
    
    // 매물 유형별 조회
    public String realestateTypeSearch() {
    	
    	sql = "SELECT * FROM REALESTATEINFO WHERE INTERMEDIARY_ID = ? AND REALESTATE_TYPE = ?";
    	
    	return sql;
    }
    
    // 특정 매물 정보 조회
    public String realestateTargetSearch() {
    	
    	sql = "SELECT * FROM REALESTATEINFO WHERE INTERMEDIARY_ID = ? AND REALESTATE_ID = ?";
    	
    	return sql;
    }
    
    // 매물수정
    public String realestateEdit() {
    	
    	sql = "UPDATE REALESTATEINFO SET REALESTATE_NAME = ? , REALESTATE_ADDRESS = ?, REALESTATE_TYPE = ?, REALESTATE_CONDITION = ?, REALESTATE_AREA = ?, FLOORS = ?, "
    			+ "ROOMS_COUNT = ?, TOILET_COUNT = ?, REALESTATE_SALEPRICE = ?, REALESTATE_MONTHLY = ?, REALESTATE_MAINTENANCE_COST = ? , AVAILABLE_MOVE_IN_DATE = ?,"
    			+ " PARKING_COUNT = ?, REALESTATE_OPTIION = ?, OTHER_COMMENT = ?, REALESTATE_PHOTOS = ? WHERE REALESTATE_ID = ? AND INTERMEDIARY_ID = ?";
    	
      	return sql;
    }

    // 중개인 탈퇴
    public String inermediaryDelete() {
    	sql = " DELETE FROM intermediary I WHERE I.INTERMEDIARY_USER_ID = (SELECT USER_ID FROM USERINFO U WHERE U.USER_ID = ?  AND U.ID = ?  AND U.PASSWORD = ?)";
    		
      	return sql;
    }

}
