<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>마이페이지 메인화면</title>
        <meta charset="UTF-8">
        <style>
            *{box-sizing: border-box;}

            header {
            padding: 80px;
            background: linear-gradient(to right, #6190E8, #A7BFE8);       
            }

            .logo {
                width: 150px;
                height: auto; 
                margin-top: -68px;
                margin-left: -59px;
            }
            .logout{
                width: 50px;
                height: auto;
                position: relative;
                top: -96px;
                left: 1567px;
            }
            .user{
                width: 50px;
                height: auto;
                position: relative;
                top: -153px;
                left: 1633px;
            }
            .like{
                width: 50px;
                height: auto;
                position: relative;
                top: -203px;
                left: 1700px;
            }
            .mypage {
                position: relative;
                left: -100px;
                font-size: 40px;
                width: 100%;
                
            }

            .mypage img {
                position: relative;
                left: 10px;
                width: 60px;
                height: auto;
                
                

            }
            .main {
                background-color: antiquewhite;
                float: left;
                padding: 200px;
                width: 85%;
                height: 900px;
            }

            nav ul {
                list-style-type: none;
                text-align: right;
                position: relative;
                bottom: -100px;
                display: flex;
                flex-direction: column;
                gap: 35px;
            }
            
            nav {
                background-color: aqua;
                float: left;
                padding: 30px;
                width: 15%;
                height: 900px;
            }
        

        </style>
    </head>
    <body>
        <header>
                <article><img src="./img/드루와방_로고3.png" class="logo"></article>
                <article><img src="./img/로그아웃.png" class="logout"></article>
                <article><img src="./img/유저.png" class="user"></article>
                <article><img src="./img/찜.png" class="like"></article> 
        </header>
        <section>
            <nav>
                <ul >
                    <li class="mypage" ><img src="./img/home2.png" alt="마이페이지 아이콘">
                        마이페이지</li>
                    <li>내정보</li>
                    <li>찜한 매물</li>
                    <li>내 문의내역</li>
                    <li>중개인 등록</li>
                    <li>회원탈퇴</li>
                    <hr style="height: 80%;">
                </ul>
            </nav>
            <article class="main">
                <h1>최근 본 매물</h1><br>
                <hr style="width: 85%;">

            </article>

        
                
            </section>

    </body>
</html>