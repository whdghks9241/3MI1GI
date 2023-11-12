package servlet;

public class sql {
    private String sql;
    
    // 회원가입
    public String register() {
    	
        sql = "INSERT INTO USERINFO (ID, PASSWORD, PHONE_NUMBER, EMAIL, ADDRESS) VALUES (?, ?, ?, ?, ?)";
        return sql;
        
    }
    
    // 로그인시 예외처리
    // 1. id 중복체크
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
    	
        sql = "INSERT INTO intermediary(BUSINESS_NUMBER, CEO_NAME, COMPANY_NAME, COMPANY_ADDRESS, CONTACT_START_TIME, CONTACT_END_TIME, INTERMEDIARY_USER_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return sql;
        
    }
    
    // 중개인 정보 조회
    public String intermediarySearch() {
    	
        sql = "SELECT * FROM intermediary WHERE INTERMEDIARY_USER_ID =?";
        return sql;
        
    }
    
    // 중개인 정보 수정
    public String intermediaryEdit() {
    	
        sql = "UPDATE intermediary SET CEO_NAME = ?, COMPANY_NAME = ?, COMPANY_ADDRESS = ?, CONTACT_START_TIME = ?, CONTACT_END_TIME = ? WHERE INTERMEDIARY_USER_ID = ? AND BUSINESS_NUMBER = ?";
       
        return sql; 
    }
    
    // 매물 등록
    public String realestateAdd() {
    	
    	sql = "INSERT INTO REALESTATEINFO(REALESTATE_ID, INTERMEDIARY_ID, REALESTATE_NAME, REALESTATE_ADDRESS, REALESTATE_TYPE, REALESTATE_CONDITION, REALESTATE_AREA, FLOORS, ROOMS_COUNT, TOILET_COUNT, REALESTATE_SALEPRICE, "
    			+ "REALESTATE_MONTHLY, REALESTATE_MAINTENANCE_COST, AVAILABLE_MOVE_IN_DATE, PARKING_COUNT, REALESTATE_OPTIION, OTHER_COMMENT, REALESTATE_DATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	
    	return sql;
    	
    }
    // 매물 조회
    public String realestateSearch() {
    	
    	sql = "SELECT * FROM REALESTATEINFO WHERE REALESTATE_ID = ? ANDINTERMEDIARY_ID = ?";
    	
    	return sql;
    }
    // �ε��� �Ź� ����
    // �ε��� �Ź� ����
}
