<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
	<h1>매물 등록</h1>
	
	<form action="ConnectionServlet" method="post" enctype="multipart/form-data">

 		<label for=REALESTATE_NAME> 건물이름 : </label>
        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" required>
        
        <label for=REALESTATE_ADDRESS> 건물주소 : </label>
        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" required>

        <label for="REALESTATE_TYPE">건물종류 : </label>
        <input type="text" id="REALESTATE_TYPE" name="REALESTATE_TYPE" required><br>

        <label for="REALESTATE_CONDITION">계약조건 : </label>
        <input type="text" id="REALESTATE_CONDITION" name="REALESTATE_CONDITION" required><br>

        <label for="REALESTATE_AREA">면적 : </label>
        <input type="text" id="REALESTATE_AREA" name="REALESTATE_AREA" required><br>
        
        <label for="FLOORS">층수 : </label>
        <input type="text" id="FLOORS" name="FLOORS" required><br>
        
        <label for="ROOMS_COUNT">방개수 : </label>
        <input type="text" id="ROOMS_COUNT" name="ROOMS_COUNT" required><br>
        
        <label for="TOILET_COUNT">화장실개수 : </label>
        <input type="text" id="TOILET_COUNT" name="TOILET_COUNT" required><br>
        
        <label for="REALESTATE_SALEPRICE">매매가 : </label>
        <input type="text" id="REALESTATE_SALEPRICE" name="REALESTATE_SALEPRICE" required><br>
        
        <label for="REALESTATE_MONTHLY">월세 : </label>
        <input type="text" id="REALESTATE_MONTHLY" name="REALESTATE_MONTHLY" required><br>
        
        <label for="REALESTATE_MAINTENANCE_COST">관리비 : </label>
        <input type="text" id="REALESTATE_MAINTENANCE_COST" name="REALESTATE_MAINTENANCE_COST" required><br>
        
        <label for="AVAILABLE_MOVE_IN_DATE">입주가능일 : </label>
        <input type="date" id="AVAILABLE_MOVE_IN_DATE" name="AVAILABLE_MOVE_IN_DATE" required><br>
      
      	<label for="PARKING_COUNT">주차가능수 : </label>
        <input type="text" id="PARKING_COUNT" name="PARKING_COUNT" required><br>
     
       	<label for="REALESTATE_OPTIION">옵션 : </label>
        <input type="text" id="REALESTATE_OPTIION" name="REALESTATE_OPTIION" required><br>
        
        <label for="image">사진 : </label>
        <input type="file" id="image" name="image" required><br>
        
		<input TYPE="hidden" id="request" name="request" value="request-realestate_add">
        <input type="submit" value="가입">
    </form>
</body>
</html>