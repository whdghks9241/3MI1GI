<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="servlet.Intermediary"%>
<%@ page import="servlet.DAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/myPage.css">
<link rel="stylesheet" href="css/myPageRealestateAdd.css">
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
         	<h1 class="titleText" >매물 등록</h1>
         	<form class="RealeStateAddContainer" action="ConnectionServlet" method="post" enctype="multipart/form-data">	
         		<div class="contents_left">
         		
					<div class="InterAdItem">
						<label for=REALESTATE_NAME> 건물이름 </label>
				        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" placeholder="이리와방빌라" required><br>
					</div>
					<div class="InterAdItem"> 
				        <label for=REALESTATE_ADDRESS> 건물주소</label>
				        <input type="text" id="REALESTATE_ADDRESS" name="REALESTATE_ADDRESS"  placeholder="서울특별시 강남구 반포동 00-00 이리왕빌라 201호" required><br>
			    	</div> 
					<div class="InterAdItem">
						<label for=REALESTATE_NAME> 건물종류 </label>
				        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" placeholder="아파트 / 빌라 / 도시생활주택 / 다가구주택 / 원룸 / 투룸" required><br>
					</div>
					<div class="InterAdItem">
						<label for=REALESTATE_NAME> 계약조건 </label>
				        <input type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" placeholder="매매 / 전세 / 월세" required><br>
					</div>
					<div class="InterAdItem">
						<label for=REALESTATE_NAME> 면적 </label>
				        <input style="width:265px" type="text" id="REALESTATE_NAME" name="REALESTATE_NAME" placeholder="84.24㎡ (소수점 2째 자리 까지 입력해주세)" required><a style="font-size:30px; padding-left:10px">㎡</a>
					</div>
					<div class="InterAdItem"> 
				        <label for="FLOORS">층수 </label>
				        <input type="text" id="FLOORS" name="FLOORS" placeholder="10층" required><br>
		        	</div> 
		        	
		        	<div class="InterAdItem"> 
				        <label for="ROOMS_COUNT">방개수 </label>
				        <input type="text" id="ROOMS_COUNT" name="ROOMS_COUNT" placeholder="3" required><br>
			        </div> 
			    	<div class="InterAdItem"> 
				        <label for="TOILET_COUNT">화장실개수 </label>
				        <input type="text" id="TOILET_COUNT" name="TOILET_COUNT" placeholder="2" required><br>
			        </div> 

			
         		</div>
				<div class="contents_right">
					<div class="InterAdItem2"> 
				        <img src="IMG/user.png" style="width:190px; height:190px" ><br>
				        <label style="text-align:center" for="image">대표사진</label><br>
				        <input type="file" id="image" name="image" required><br>
			        </div> 
					
					<div class="InterAdItem2"> 
				        <label for="REALESTATE_SALEPRICE">매매가 / 전세가 / 보증금</label>
				        <input type="text" id="REALESTATE_SALEPRICE" name="REALESTATE_SALEPRICE"  placeholder="매매-매매가 / 전세-전세가 / 월세-보증금" required><br>
		       		</div> 
		       		<div class="InterAdItem2"> 
				        <label for="REALESTATE_MONTHLY">월세</label>
				        <input type="text" id="REALESTATE_MONTHLY" name="REALESTATE_MONTHLY" placeholder="월세가 존재할 경우 작성" required><br>
		        	</div> 
		        	<div class="InterAdItem2"> 
				        <label for="REALESTATE_MAINTENANCE_COST">관리비</label>
				        <input type="text" id="REALESTATE_MAINTENANCE_COST" name="REALESTATE_MAINTENANCE_COST" placeholder="관리비가 존재할 경우 작성" required><br>
		        	</div> 
		        	<div class="InterAdItem2"> 
				        <label for="AVAILABLE_MOVE_IN_DATE">입주가능일 : </label>
				        <input type="date" id="AVAILABLE_MOVE_IN_DATE" name="AVAILABLE_MOVE_IN_DATE" required><br>
		      		</div> 

				</div>
				
				<div style="background-color:#eeeeee; width:1100px; height:220px;margin:30px; margin-left:200px; text-align: center;" >
		      			<h1 style="padding:20px; font-size:25px; font-weight: bold;">옵션</h1>
		      			<table>
							<tr>
								<td>에베베베</td>
								<td>에베베베</td>
								<td>에베베베</td>
								<td>에베베베</td>
								<td>에베베베</td>
								<td>에베베베</td>
								<td>에베베베</td>
							</tr>
		      			</table>
		      	</div> 
				
				
				
			</form>
			<button class="addButton">asdf</button>
        </nav>
        
    </section>
</body>
</html>