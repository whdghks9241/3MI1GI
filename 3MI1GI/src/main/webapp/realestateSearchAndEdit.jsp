<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="servlet.DAO"%>
    <%@ page import="servlet.Realestate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>매물 수정</h1>
	
	<%
	// 중개인의 정보를 들고온후 데이터를 집어 넣는다
	int INTERMEDIARY_ID = (int)request.getAttribute("INTERMEDIARY_ID");
    System.out.println("INTERMEDIARY_ID : " + INTERMEDIARY_ID);

	DAO RealeDAO = new DAO();
	Realestate Reale = RealeDAO.getRealestaInfo(INTERMEDIARY_ID);

	%>
	
	<form action="ConnectionServlet" method="post">

 		<label for=REALESTATE_NAME> 건물이름 : </label>
        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" value="<%= Reale.getREALESTATE_NAME() %>" required>
        
        <label for=REALESTATE_ADDRESS> 건물주소 : </label>
        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" value="<%= Reale.getREALESTATE_ADDRESS() %>" required>

        <label for="REALESTATE_TYPE">건물종류 : </label>
        <input type="text" id="REALESTATE_TYPE" name="REALESTATE_TYPE" value="<%= Reale.getREALESTATE_TYPE() %>" required><br>

        <label for="REALESTATE_CONDITION">계약조건 : </label>
        <input type="text" id="REALESTATE_CONDITION" name="REALESTATE_CONDITION" value="<%= Reale.getREALESTATE_CONDITION() %>" required><br>

        <label for="REALESTATE_AREA">면적 : </label>
        <input type="text" id="REALESTATE_AREA" name="REALESTATE_AREA" value="<%= Reale.getREALESTATE_AREA() %>" required><br>
        
        <label for="FLOORS">층수 : </label>
        <input type="text" id="FLOORS" name="FLOORS" value="<%= Reale.getFLOORS() %>" required><br>
        
        <label for="ROOMS_COUNT">방개수 : </label>
        <input type="text" id="ROOMS_COUNT" name="ROOMS_COUNT" value="<%= Reale.getROOMS_COUNT() %>" required><br>
        
        <label for="TOILET_COUNT">화장실개수 : </label>
        <input type="text" id="TOILET_COUNT" name="TOILET_COUNT" value="<%= Reale.getTOILET_COUNT() %>" required><br>
        
        <label for="REALESTATE_SALEPRICE">매매가 : </label>
        <input type="text" id="REALESTATE_SALEPRICE" name="REALESTATE_SALEPRICE" value="<%= Reale.getREALESTATE_SALEPRICE() %>" required><br>
        
        <label for="REALESTATE_MONTHLY">월세 : </label>
        <input type="text" id="REALESTATE_MONTHLY" name="REALESTATE_MONTHLY" value="<%= Reale.getREALESTATE_MONTHLY() %>" required><br>
        
        <label for="REALESTATE_MAINTENANCE_COST">관리비 : </label>
        <input type="text" id="REALESTATE_MAINTENANCE_COST" name="REALESTATE_MAINTENANCE_COST" value="<%= Reale.getREALESTATE_MAINTENANCE_COST() %>" required><br>
        
        <label for="AVAILABLE_MOVE_IN_DATE">입주가능일 : </label>
        <input type="date" id="AVAILABLE_MOVE_IN_DATE" name="AVAILABLE_MOVE_IN_DATE" value="<%= Reale.getAVAILABLE_MOVE_IN_DATE() %>" required><br>
      
      	<label for="PARKING_COUNT">주차가능수 : </label>
        <input type="text" id="PARKING_COUNT" name="PARKING_COUNT" value="<%= Reale.getPARKING_COUNT() %>" required><br>
     
       	<label for="REALESTATE_OPTIION">옵션 : </label>
        <input type="text" id="REALESTATE_OPTIION" name="REALESTATE_OPTIION" value="<%= Reale.getREALESTATE_OPTIION() %>" required><br>
        
		<input TYPE="hidden" id="request" name="request" value="request-realestate_edit">
        <input type="submit" value="가입">
    </form>
</body>
</html>