package servlet;

public class sql {
    private String sql;
    
    // ȸ������
    public String register() {
    	
        sql = "INSERT INTO USERINFO (ID, PASSWORD, PHONE_NUMBER, EMAIL, ADDRESS) VALUES (?, ?, ?, ?, ?)";
        return sql;
        
    }
    
    // ȸ�����Խ� ����ó��
    // 1. ���̵� �ߺ�üũ
    public String idDuplicateCheck() {
    	
    	sql = "SELECT ID FROM USERINFO WHERE ID = ?"; 
    	return sql;
    	
    }
    
    // �α���
    public String login() {
    	
    	sql = "SELECT * FROM USERINFO WHERE ID =? AND PASSWORD = ?";
    	return sql;
    	
    }
    
    // ������ ���� ���
    public String intermediaryAdd() {
    	
        sql = "INSERT INTO intermediary(BUSINESS_NUMBER, CEO_NAME, COMPANY_NAME, COMPANY_ADDRESS, CONTACT_START_TIME, CONTACT_END_TIME, INTERMEDIARY_USER_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return sql;
        
    }
    
    // ������ ���� ��ȸ
    public String intermediarySearch() {
    	
        sql = "SELECT * FROM intermediary WHERE INTERMEDIARY_USER_ID =?";
        return sql;
        
    }
    
    // ������ ���� ����
    public String intermediaryEdit() {
    	
        sql = "UPDATE intermediary SET CEO_NAME = ?, COMPANY_NAME = ?, COMPANY_ADDRESS = ?, CONTACT_START_TIME = ?, CONTACT_END_TIME = ? WHERE AND INTERMEDIARY_USER_ID = ?";
        return sql;
        
    }
    
    // ������ ���� ����
    // �ε��� �Ź� ���
    // �ε��� �Ź� ����
    // �ε��� �Ź� ����
}
