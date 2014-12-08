<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<script type="text/javascript" >

$(document).ready(function() {
		/* 아이디 유효성검사 */
		var re_id = /^[a-z]+[a-z0-9]{5,12}$/g;
		/* 비빌번호 유효성검사 */
		var re_psw = /^[a-z0-9]{5,16}$/; 
		/* 메일 유효성검사 */
		var re_mail = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;
		/* 숫자 입력갯수 유효성 검사  */
		var re_phone1=/^[0-9]{3}/;
		var re_phone2=/^[0-9]{4}/;
		var re_year=/^[0-9]{4}/;
		var re_day=/^[0-9]{2}/;
		$("#userid").blur(function(){
		if(re_id.test($("#userid").val())){
			alert("사용가능");
		}else{
			alert("영문자숫자 5이상 16이하");
		}
		});
	});
		
</script>

<div class="container">
	<div id="join_form" >
		<form action="loginJoinAction.mo" method="post">
			<ul>
				<li>
					<h2><b>회원가입 페이지</b></h2>
				</li>
				<li>
					<label for="userid">아이디</label>
					<input name="userid" id="userid" type="text" placeholder="ID" required/>
				</li>
				<li>
					<label for="userpass">비밀번호</label>
					<input name="userpass" id="userpass" type="password" placeholder="PASSWORD" required/>
				</li>
				<li>
					<label for="username">이름</label>
					<input name="username" id="username" type="text" placeholder="NAME" required/>
				</li>
				<li>
					<label for="useremail">이메일</label>
					<input name="useremail" id="useremail" type="text" placeholder="E-MAIL" required/>
				</li>
				<li>
				로그인을 클릭함으로써 <a href="#">사용 약관</a> 및 <a href="#">개인정보 보호정책</a>에 동의합니다.
				</li>
				<li>
					<input class="btn btn-info btn-lg" type="submit" value="가입하기">
					<input class="btn btn-info btn-lg" type="reset" value="다시작성">
				</li>
				
			</ul>
		</form>
	</div>
</div>
