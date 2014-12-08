<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container ">
		<div  id="login_form">
			<form action="loginProcess.mo" method="post">
				<ul>
					<li>
						<label for="user_id">ID </label>
						<input name="user_id" id="user_id" type="text" placeholder="Email" required />
					</li>
					<li>
					    <label for="user_pass">Password </label>
						<input name="user_pass" id="user_pass" type="password" placeholder="Password" required />
					</li>
					<li>
						<input class="btn btn-info btn-lg" name="login" type="submit" value="Sign in" />
					</li>
					<li>
					<span class="glyphicon glyphicon-search">
					<a href="forgotpw.mo" >Forgot your password?</a></span>
					<span class="glyphicon glyphicon-user">
					<input type="button" value="Join" onclick="window.location='joinForm.mo';" />
        			</span>
					</li>
				</ul>
				
			</form>
			
			<c:if test="${mc.id_ok == true && empty mc.name}">
				<span id="checkID" class="checktext"><c:out value="Unable to logon: The login password do not match. Please recheck both the email address and password you are using to log in."/></span>
			</c:if>
			<c:if test="${mc.id_ok == false }">
				<span id="checkPW" class="checktext"><c:out value="Unable to logon: The login email do not match. Please recheck both the email address and password you are using to log in."/></span>
			</c:if>
		</div>
	</div>

