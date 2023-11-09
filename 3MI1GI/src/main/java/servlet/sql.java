package servlet;

public class sql {
    private String sql;
    
    // 회원가입
    public String register() {
    	
        sql = "INSERT INTO USERINFO (ID, PASSWORD, PHONE_NUMBER, EMAIL, ADDRESS) VALUES (?, ?, ?, ?, ?)";
        return sql;
        
    }
    
    // 회원가입시 예외처리
    // 1. 아이디 중복체크
    public String idDuplicateCheck() {
    	
    	sql = "SELECT ID FROM USERINFO WHERE ID = ?"; 
    	return sql;
    	
    }
    
    // 로그인
    public String login() {
    	
    	sql = "SELECT * FROM USERINFO WHERE ID =? AND PASSWORD = ?";
    	return sql;
    	
    }
    
    // 전문가 정보 등록
    public String intermediaryAdd() {
    	
        sql = "INSERT INTO intermediary(BUSINESS_NUMBER, CEO_NAME, COMPANY_NAME, COMPANY_ADDRESS, CONTACT_START_TIME, CONTACT_END_TIME, INTERMEDIARY_USER_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return sql;
        
    }
    
    // 전문가 정보 조회
    public String intermediarySearch() {
    	
        sql = "SELECT * FROM intermediary WHERE INTERMEDIARY_USER_ID =?";
        return sql;
        
    }
    
    // 전문가 정보 수정
    public String intermediaryEdit() {
    	
        sql = "UPDATE intermediary SET CEO_NAME = ?, COMPANY_NAME = ?, COMPANY_ADDRESS = ?, CONTACT_START_TIME = ?, CONTACT_END_TIME = ? WHERE AND INTERMEDIARY_USER_ID = ?";
        return sql;
        
    }
    
    // 전문가 정보 삭제
    // 부동산 매물 등록
    // 부동산 매물 수정
    // 부동산 매물 삭제
}
