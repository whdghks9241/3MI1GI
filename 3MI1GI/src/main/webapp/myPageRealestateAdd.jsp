<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="servlet.Intermediary"%>
<%@ page import="servlet.DAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/myPage.css">
<link rel="stylesheet" href="css/myPageRealstateAdd.css">
</head>
<body>
	<%

	int	USER_ID = (int) session.getAttribute("USER_ID");
	
	DAO interDAO = new DAO();
	
	Intermediary inter = interDAO.getIntermediaryInfo(USER_ID);
	%>
	<header>
		<!-- 로고 및 상단 버튼 -->
        <img src="IMG/logo.png" class="logo">
        <div class="frame">
            <div class="likelist_frame">
                <img src="IMG/like.png" class="likelist"><br>
                <span>찜</span>
            </div>
            <div class="user_frame">
                <img src="IMG/user.png" class="user"><br>
                <span>MY</span>
            </div>
            <div class="logout_frame">
                <img src="IMG/logout.png" class="logout"><br>
                <span>로그아웃</span>
            </div>
           
        </div>
	</header>
	<section class="aa">
        <nav class="container_left">
            <div>
                <!-- 중간 지점 -->
                <!-- 좌측 메뉴 --> 
          
                <div class="page_frame">
                    <img src="IMG/home.png" class="home">
                    <span>마이페이지</span>
                </div>
                <div class="menu_list">   
                	<%
                		if (inter == null) {
                		%>
	            		    <li>내 정보</li>
		                    <li>찜한 매물</li>
		                    <li>내 문의내역</li>
		                    <li onclick="location.href='myPageIntermediaryAdd.jsp'">중개인 등록</li>
		                    <li>회원탈퇴</li>
            			<%
                		} else {
	               		%>
                		    <li>내 정보</li>
		                    <li>찜한 매물</li>
		                    <li>내 문의내역</li>
		                    <li>회원탈퇴</li>
		                    
		                    <div class="page_frame2">
			                    <img src="IMG/user.png" class="home">
			                    <span>중개인 페이지</span>
			                </div>
	    					<li onclick="location.href='myPageIntermediarySearchAndEdit.jsp'">중개인 정보</li>
	    					<li onclick="location.href='myPageRealestateAdd.jsp'">매물 등록</li>
		                    <li onclick="location.href='myPageIntermediaryAdd.jsp'">등록 매물 조회</li>
		                    <li onclick="location.href='myPageIntermediaryAdd.jsp'">중개인 탈퇴</li>
                		<%
                		}
                	%> 
                	  

                </div>
            </div>
        </nav>
        <nav class="container_right">
         	<h1>매물 등록</h1>
	
			<form class="RealeStateAddContainer" action="ConnectionServlet" method="post" enctype="multipart/form-data">
		
		 		<label for=REALESTATE_NAME> 건물이름 : </label>
		        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" required>
		        
		        <label for=REALESTATE_ADDRESS> 건물주소 : </label>
		        <input type="text" id="REALESTATE_ADDRESS" name="REALESTATE_ADDRESS" required>
		
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
		        <input type="submit" value="매물등록">
		    </form>
        </nav>
    </section>
</body>
</html>