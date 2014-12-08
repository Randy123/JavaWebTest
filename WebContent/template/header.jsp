 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" id="logo_top">
	<a href="main.do" class="pull-left" >
	 <img src="./images/logo.gif"  class="img-responsive" width="100" align="middle"/>
	</a>
	 
	<span class="pull-right">
			<c:if test="${not empty login_OK_id }">
			<br>
				<b><c:out value="${mc.name }"/></b> 님 ! &nbsp;
				<a class="btn btn-xs btn-primary" href="logout.mo" >
				로그아웃&nbsp;
				<span class="glyphicon glyphicon-share"></span>
				</a>
			
				<c:if test="${login_OK_id eq 'admin@admin.com' }">
					<a href="memberView.mo">[ 회원 정보 보기 ]</a>
				</c:if>
			</c:if>
	</span>
</div>


<div class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
		<a href="#" class="navbar-brand" >CHOI's Web Page</a>
			<button class="navbar-toggle " data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse in">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="main.do">Home</a></li>
				<li><a href="bulletinList.go">Bulletin Board</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Useful sites<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.youtube.com/" target="_blank">Youtube</a></li>
						<li><a href="http://www.baykoreans.net" target="_blank">Baykoreans</a></li>
						<li><a href="http://tvpot.daum.net/mypot/Top.do?ownerid=8i-nrrEAG7A0" target="_blank">Daum TV-pot</a></li>
					</ul> 
				</li>
				<li><a href="chart.ct">Chart</a></li>
				<li><a href="chat.cr">Chat Room</a></li>
				<li>
				<c:if test="${empty login_OK_id }">
					<a href="login.mo"><span class="glyphicon glyphicon-log-in"></span> Login</a>
				</c:if>
				</li>
			</ul>
		</div>
	</div>
</div>



