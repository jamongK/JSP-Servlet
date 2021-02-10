<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Jake</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
</head>
<body>
	<div id="container">
		<header>
			<h1>Hello Jake</h1>
			<!-- 로그인메뉴 시작 -->
			<div class="login-container">
				<form id="loginFrm">
					<table>
						<tr>
							<td><input type="text" name="memberId" id="memberId" placeholder="아이디" tabindex="1"></td>
							<td><input type="submit" value="로그인" tabindex="3"></td>
						</tr>
						<tr>
							<td><input type="password" name="password" id="password"
							placeholder="비밀번호" tabindex="2" ></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="checkbox" name="saveId" id="saveId" />
								<label for="saveId" style="color: #ffffff;">아이디저장</label>&nbsp;&nbsp;
								<input type="button" value="회원가입">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<!-- 로그인메뉴 끝-->
			<!-- 메인메뉴 시작 -->
			<nav>
				<ul class="main-nav">
					<li class="home"><a href="#">Home</a></li>
					<li id="notice"><a href="#">공지사항</a></li>
					<li id="board"><a href="#">게시판</a></li>
				</ul>
			</nav>
			<!-- 메인메뉴 끝-->
		</header>
		
		<section id="content">