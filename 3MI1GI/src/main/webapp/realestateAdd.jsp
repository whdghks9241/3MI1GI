<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>매물 등록</h1>
	
	<form action="ConnectionServlet" method="post">

 		<label for="ID"> 건물이름 : </label>
        <input type="text" id="ID" name="ID" required>

        <label for="PASSWORD">건물종류 : </label>
        <input type="password" id="PASSWORD" name="PASSWORD" required><br>

        <label for="PASSWORD_CHECK">계약조건 : </label>
        <input type="password" id="PASSWORD_CHECK" name="PASSWORD_CHECK" required><br>

        <label for="PHONE_NUMBER">면적 : </label>
        <input type="text" id="PHONE_NUMBER" name="PHONE_NUMBER" required><br>
        
        <label for="EMAIL">층수 : </label>
        <input type="email" id="EMAIL" name="EMAIL" required><br>
        
        <label for="ADDRESS">방개수 : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">화장실 : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">매매가 : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">월세 : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">관리비 : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
        
         <label for="ADDRESS">입주가능일 : </label>
        <input type="text" id="ADDRESS" name="ADDRESS" required><br>
     
        
		<input TYPE="hidden" id="request" name="request" value="request-register">
        <input type="submit" value="가입">
    </form>
</body>
</html>