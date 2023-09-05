<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<div id="sub">
    <div><img src="../images/sub_top_tit5.png" alt="COMMUNITY"></div>
    <section class="community">
        <aside>
            <img src="../images/sub_aside_cate5_tit.png" alt="커뮤니티"/>

            <ul class="lnb">
                <li class="${cate eq 'notice'?'on':'off'}"><a href="${ctxPath}/board/list.do?group=Community&cate=notice">공지사항</a></li>
                <li class="${cate eq 'menu'?'on':'off'}"><a href="${ctxPath}/board/list.do?group=Community&cate=menu">오늘의식단</a></li>
                <li class="${cate eq 'chef'?'on':'off'}"><a href="${ctxPath}/board/list.do?group=Community&cate=chef">나도요리사</a></li>
                <li class="${cate eq 'qna'?'on':'off'}"><a href="${ctxPath}/board/list.do?group=Community&cate=qna">고객문의</a></li>
                <li class="${cate eq 'faq'?'on':'off'}"><a href="${ctxPath}/board/list.do?group=Community&cate=faq">자주묻는질문</a></li>
            </ul>
        </aside>
        <article>
            <nav>
                <img src="${ctxPath}/images/sub_nav_tit_cate5_${cate}.png" alt="농작물이야기"/>
                <p>
                    HOME > 커뮤니티 > 
                    <c:if test="${cate eq 'notice'}"><em>공지사항</em></c:if>
                    <c:if test="${cate eq 'menu'}"><em>오늘의식단</em></c:if>
                    <c:if test="${cate eq 'chef'}"><em>나도요리사</em></c:if>
                    <c:if test="${cate eq 'qna'}"><em>고객문의</em></c:if>
                    <c:if test="${cate eq 'faq'}"><em>자주묻는질문</em></c:if>
                </p>
            </nav>
            <!-- 내용 시작 -->