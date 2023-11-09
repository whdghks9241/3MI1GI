<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<h1>회원가입</h1>
	<form action="ConnectionServlet" method="post">

 		<label for="ID"> 아이디 : </label>
        <input type="text" id="ID" name="ID" required>

        <label for="PASSWORD">비밀번호 : </label>
        <input type="password" id="PASSWORD" name="PASSWORD" required><br>

        <label for="PASSWORD_CHECK">비밀번호 확인 : </label>
        <input type="password" id="PASSWORD_CHECK" name="PASSWORD_CHECK" required><br>

        <label for="PHONE_NUMBER">휴대폰 번호 : </label>
        <input type="text" id="PHONE_NUMBER" name="PHONE_NUMBER" required><br>
        
        <label for="EMAIL">이메일 : </label>
        <input type="email" id="EMAIL" name="EMAIL" required><br>
        
        <label for="ADDRESS">주소 : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
		<input TYPE="hidden" id="request" name="request" value="request-register">
        <input type="submit" value="가입">
    </form>
</body>
</html>