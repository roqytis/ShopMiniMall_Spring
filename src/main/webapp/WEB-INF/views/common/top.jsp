<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <!-- top부분 -->
    <c:if test="${empty login }">
    <a href="">로그인</a> &nbsp;
    <a href="">장바구니</a>&nbsp;
    <a href="">회원가입</a>&nbsp;
     </c:if>
    <c:if test="${!empty login }">
    안녕하세요? ${login.username }님!<br>
    <a href="">로그아웃</a>&nbsp;
    <a href="">mypage</a>&nbsp;
    <a href="">장바구니</a>&nbsp;
     </c:if>
