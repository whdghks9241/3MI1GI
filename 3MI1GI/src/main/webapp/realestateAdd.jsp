<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
	<h1>�Ź� ���</h1>
	
	<form action="ConnectionServlet" method="post" enctype="multipart/form-data">

 		<label for=REALESTATE_NAME> �ǹ��̸� : </label>
        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" required>
        
        <label for=REALESTATE_ADDRESS> �ǹ��ּ� : </label>
        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" required>

        <label for="REALESTATE_TYPE">�ǹ����� : </label>
        <input type="text" id="REALESTATE_TYPE" name="REALESTATE_TYPE" required><br>

        <label for="REALESTATE_CONDITION">������� : </label>
        <input type="text" id="REALESTATE_CONDITION" name="REALESTATE_CONDITION" required><br>

        <label for="REALESTATE_AREA">���� : </label>
        <input type="text" id="REALESTATE_AREA" name="REALESTATE_AREA" required><br>
        
        <label for="FLOORS">���� : </label>
        <input type="text" id="FLOORS" name="FLOORS" required><br>
        
        <label for="ROOMS_COUNT">�氳�� : </label>
        <input type="text" id="ROOMS_COUNT" name="ROOMS_COUNT" required><br>
        
        <label for="TOILET_COUNT">ȭ��ǰ��� : </label>
        <input type="text" id="TOILET_COUNT" name="TOILET_COUNT" required><br>
        
        <label for="REALESTATE_SALEPRICE">�ŸŰ� : </label>
        <input type="text" id="REALESTATE_SALEPRICE" name="REALESTATE_SALEPRICE" required><br>
        
        <label for="REALESTATE_MONTHLY">���� : </label>
        <input type="text" id="REALESTATE_MONTHLY" name="REALESTATE_MONTHLY" required><br>
        
        <label for="REALESTATE_MAINTENANCE_COST">������ : </label>
        <input type="text" id="REALESTATE_MAINTENANCE_COST" name="REALESTATE_MAINTENANCE_COST" required><br>
        
        <label for="AVAILABLE_MOVE_IN_DATE">���ְ����� : </label>
        <input type="date" id="AVAILABLE_MOVE_IN_DATE" name="AVAILABLE_MOVE_IN_DATE" required><br>
      
      	<label for="PARKING_COUNT">�������ɼ� : </label>
        <input type="text" id="PARKING_COUNT" name="PARKING_COUNT" required><br>
     
       	<label for="REALESTATE_OPTIION">�ɼ� : </label>
        <input type="text" id="REALESTATE_OPTIION" name="REALESTATE_OPTIION" required><br>
        
        <label for="image">���� : </label>
        <input type="file" id="image" name="image" required><br>
        
		<input TYPE="hidden" id="request" name="request" value="request-realestate_add">
        <input type="submit" value="����">
    </form>
</body>
</html>