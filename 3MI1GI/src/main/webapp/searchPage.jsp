<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/myPage.css">
<link rel="stylesheet" href="css/searchPage.css">
</head>
<body>
	<header>
		<!-- 로고 및 상단 버튼 -->
        <img src="IMG/logo.png" class="logo">
        <div class="frame">
            <div class="likelist_frame">
                <img src="IMG/like.png" class="likelist"><br>
                <span>찜</span>
            </div>
            <div class="user_frame" onclick="location.href='myPage.jsp'">
                <img src="IMG/user.png" class="user"><br>
                <span >MY</span>
            </div>
            <div class="logout_frame">
                <img src="IMG/logout.png" class="logout"><br>
                <span>로그아웃</span>
            </div>
           
        </div>
	</header>
	<section>
	<h1 class="title">매물 조회</h1>
	<form action="CheckSearchServlet" method="post">
        <table>
            <tr>
                <td>건물 타입</td>
                <td><input type="checkbox" name="build_Type" value="아파트"> 아파트</td>
                <td><input type="checkbox" name="build_Type" value="빌라"> 빌라</td>
                <td><input type="checkbox" name="build_Type" value="도시형생활주택"> 도시형생활주택</td>
                <td><input type="checkbox" name="build_Type" value="아파트"> 원룸</td>
                <td><input type="checkbox" name="build_Type" value="빌라"> 투룸</td>
            </tr>
            <tr>
                <td>매물 유형</td>
                <td><input type="checkbox" name="realestate_type" value="월세"> 월세</td>
                <td><input type="checkbox" name="realestate_type" value="전세"> 전세</td>
                <td><input type="checkbox" name="realestate_type" value="매매"> 매매</td>
            </tr>

            <tr>
                <td>면적</td>
                <td><input type="checkbox" name="area" value="10DWON"> 10평 이하</td>
                <td><input type="checkbox" name="area" value="10"> 10평</td>
                <td><input type="checkbox" name="area" value="20"> 20평</td>
                <td><input type="checkbox" name="area" value="30"> 30평</td>
                <td><input type="checkbox" name="area" value="40UP"> 40평 이상</td>
            </tr>
            <tr>
                <td>방 개수</td>
                <td><input type="checkbox" name="total_room" value="1"> 1개</td>
                <td><input type="checkbox" name="total_room" value="2"> 2개</td>
                <td><input type="checkbox" name="total_room" value="3"> 3개</td>
                <td><input type="checkbox" name="total_room" value="4"> 4개</td>
                <td><input type="checkbox" name="total_room" value="5이상"> 5개 이상</td>
            </tr>
            <tr>
                <td>화장실 개수</td>
                <td><input type="checkbox" name="toilet_count" value="1"> 1개</td>
                <td><input type="checkbox" name="toilet_count" value="2"> 2개</td>
                <td><input type="checkbox" name="toilet_count" value="3"> 3개 이상</td>
                </tr>
        </table>
        <input type="submit" class=searchButton  value="검색하기" />
    </form>
	</section>
</body>
</html>
