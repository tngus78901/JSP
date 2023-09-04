<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리::농작물이야기</title>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
    <div id="container">
        <header>
            <a href="../index.html" class="logo"><img src="../images/logo.png" alt="로고"/></a>
            <p>
                <a href="#">HOME |</a>
                <a href="#">로그인 |</a>
                <a href="#">회원가입 |</a>
                <a href="#">고객센터</a>
            </p>
            <img src="../images/head_txt_img.png" alt="3만원 이상 무료배송"/>
            
            <ul class="gnb">
                <li><a href="#">팜스토리소개</a></li>
                <li><a href="#"><img src="../images/head_menu_badge.png" alt="30%"/>장바구니</a></li>
                <li><a href="#">농작물이야기</a></li>
                <li><a href="#">이벤트</a></li>
                <li><a href="#">커뮤니티</a></li>
            </ul>
        </header>

        <div id="sub">
            <div><img src="../images/sub_top_tit3.png" alt="CROP TALK"></div>
            <section class="croptalk">
                <aside>
                    <img src="../images/sub_aside_cate3_tit.png" alt="농작물이야기"/>

                    <ul class="lnb">
                        <li><a href="./story.html">농작물이야기</a></li>
                        <li class="on"><a href="./grow.html">텃밭가꾸기</a></li>
                        <li><a href="./school.html">귀농학교</a></li>
                    </ul>

                </aside>
                <article>
                    <nav>
                        <img src="../images/sub_nav_tit_cate3_tit2.png" alt="텃밭가꾸기"/>
                        <p>
                            HOME > 농작물이야기 > <em>텃밭가꾸기</em>
                        </p>
                    </nav>

                    <!-- 내용 시작 -->

                    <img src="../images/board_list.png" alt="">
                    <!-- 내용 끝 -->

                </article>
            </section>

        </div>
<%@ include file="../_footer.jsp" %>  