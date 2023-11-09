<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>중개인등록</h1>
<form action="ConnectionServlet" method="post">
 		<label for="BUSINESS_NUMBER">사업자번호</label>
        <input type="text" id="BUSINESS_NUMBER" name="BUSINESS_NUMBER" required><br>

        <label for="CEO_NAME">대표이름</label>
        <input type="text" id="CEO_NAME" name="CEO_NAME" required><br>

        <label for="COMPANY_NAME">부동산이름</label>
        <input type="email" id="COMPANY_NAME" name="COMPANY_NAME" required><br>

        <label for="CONTACT_START_TIME">문의시작시간</label>
        <input type="date" id="CONTACT_START_TIME" name="CONTACT_START_TIME" required><br>
        
        <label for="CONTACT_END_TIME">문의종료시간</label>
        <input type="date" id="CONTACT_END_TIME" name="CONTACT_END_TIME" required><br>
        
		<input TYPE="hidden" id="request" name="request" value="request-inermediary_add">
        <input type="submit" value="가입">
    </form>
</body>
</html>