<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="servlet.Intermediary"%>
<%@ page import="servlet.DAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/myPage.css">
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
		                    <li onclick="location.href='RealestateAllSearch.jsp'">등록 매물 조회</li>
		                    <li onclick="location.href='myPageIntermediaryAdd.jsp'">중개인 탈퇴</li>
                		<%
                		}
                	%>
                	  

                </div>
            </div>
        </nav>
    </section>
</body>
</html>