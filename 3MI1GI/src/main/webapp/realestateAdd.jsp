<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�Ź� ���</h1>
	
	<form action="ConnectionServlet" method="post">

 		<label for="ID"> �ǹ��̸� : </label>
        <input type="text" id="ID" name="ID" required>

        <label for="PASSWORD">�ǹ����� : </label>
        <input type="password" id="PASSWORD" name="PASSWORD" required><br>

        <label for="PASSWORD_CHECK">������� : </label>
        <input type="password" id="PASSWORD_CHECK" name="PASSWORD_CHECK" required><br>

        <label for="PHONE_NUMBER">���� : </label>
        <input type="text" id="PHONE_NUMBER" name="PHONE_NUMBER" required><br>
        
        <label for="EMAIL">���� : </label>
        <input type="email" id="EMAIL" name="EMAIL" required><br>
        
        <label for="ADDRESS">�氳�� : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">ȭ��� : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">�ŸŰ� : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">���� : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">������ : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">���ְ����� : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
     
        
		<input TYPE="hidden" id="request" name="request" value="request-register">
        <input type="submit" value="����">
    </form>
</body>
</html>