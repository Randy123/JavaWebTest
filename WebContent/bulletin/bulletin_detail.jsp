<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#send_button").click(function() {
			if ($("#login_OK_id").val() == "") {
				alert("로그인후 이용하세요!");
				return;
			}
			$.ajax({
				type : "POST",
				url : "./bulletinComment.go",
				data : {
					b_num : $("#b_num").val(),
					comment_content : $("#comment_content").val()
				},
				dataType : "json",

				success : function(list) {
					
					var result = "";
					
					$.each(list, function(index, obj) {
						result += "<div class='comm_block'>";
						result += "<div class='comm_info'>";
						result += "<div><b>" + obj.Comment_ID + "</b></div>";
						result += "<div>" + obj.Comment_date + "</div>";
						result += "<div>" + obj.Comment_IP + "</div>";
						result += "</div>";
						result += "<div class='comm_content'>";
						result += "<div>" + obj.Comment_contents + "</div>";
						result += "</div>";
						result += "</div>";
					});
					

					$('#comments').html(result);
					

				}
			});
		});
	});
</script>

<div class="container ">
	<div align="center" id="bulletin_detail">
			<div class="col-sm-12 sub" align="left">
			
				<h4><b>
					<c:out value="${bulletin_detail.subject }" /></b>
				</h4>
			</div>
			<div class="col-sm-12 info" align="right" >
				글쓴이 : 
				<b><c:out value="${bulletin_detail.bid }" /></b>&nbsp;&nbsp;&nbsp;&nbsp;
				등록일 :<fmt:parseDate var="date1" value="${bulletin_detail.bdate }" pattern="yyyy-MM-dd HH:mm"/>
				 <b><fmt:formatDate value="${date1 }" pattern="yyyy.MM.dd HH:mm" /></b>&nbsp;
				
				조회수 : 
				<b><c:out value="${bulletin_detail.readcount }" /></b>
			</div>
			<div class="col-sm-12 content" align="left" >
				
				<c:out value="${bulletin_detail.bcontents }" />
				
			</div>
			<hr>
			<div class="form-group submit">
				<form >
				<textarea  class="comment" id="comment_content" rows="1" placeholder="댓글 등록은 로그인 후 이용 가능합니다."></textarea>
				<input type="hidden" id="b_num" value="${bulletin_detail.num }">
				<input id="send_button" type="button" value="댓글" class="btn btn-primary"/>
				<input id="login_OK_id" type="hidden" value="${login_OK_id }">
				</form>
			</div>
			<hr>
			
			<div id="comments" class="col-sm-12 comments" align="left" >
				<c:forEach var="data1" items="${comment_datalist }">
				<div class="comm_block">
					<div class="comm_info">
						<div><b><c:out value="${data1.comment_ID }" /></b></div>
						<fmt:parseDate var="date" value="${data1.comment_date }" pattern="yyyy-MM-dd HH:mm"/>
						<div><fmt:formatDate value="${date }" pattern="yyyy.MM.dd HH:mm" /></div>
						<div><c:out value="${data1.comment_IP }" /></div>
					</div>
					<div class="comm_content">
						<c:out value="${data1.comment_contents }" />
					</div>
				</div>	
				</c:forEach>
				
			</div>

	</div>
</div>
