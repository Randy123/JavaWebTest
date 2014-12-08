<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container ">
	<div id="bulletin_list">
<!-- 게시판 리스트 -->
			<div>
				<h3 class="text-info">bulletin</h3>
				<P align=right>
					<font size=2>글 개수 : ${list_ea }</font>
				</P>
			</div>
		<table  class="table table-striped">
			
			<thead>
				<tr align="center" valign="middle" bordercolor="#333333">
					<th style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
						<div align="center">번호</div>
					</th>
					<th style="font-family:Tahoma;font-size:8pt;" width="50%">
						<div align="center">제목</div>
					</th>
					<th style="font-family:Tahoma;font-size:8pt;" width="14%">
						<div align="center">작성자</div>
					</th>
					<th style="font-family:Tahoma;font-size:8pt;" width="17%">
						<div align="center">날짜</div>
					</th>
					<th style="font-family:Tahoma;font-size:8pt;" width="11%">
						<div align="center">조회수</div>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bean" items="${list }">	
					<tr align="center" valign="middle" bordercolor="#333333"
						onmouseover="this.style.backgroundColor='F8F8F8'"
						onmouseout="this.style.backgroundColor=''">
						<td height="23" style="font-family:Tahoma;font-size:10pt;">
							<c:out value="${bean.num }"/>
						</td>
						
						<td style="font-family:Tahoma;font-size:10pt;">
							<div align="left">
							
							<a href="./bulletinDetail.go?b_num=${bean.num }">
								<c:out value="${bean.subject }"/>
							</a>
							</div>
						</td>
						
						<td style="font-family:Tahoma;font-size:10pt;">
							<div align="center">
								<c:out value="${bean.bid }"/>
							</div>
						</td>
						<td style="font-family:Tahoma;font-size:10pt;">
							<div align="center">
								
								<c:out value="${bean.bdate }"/> 
							</div>
						</td>	
						<td style="font-family:Tahoma;font-size:10pt;">
							<div align="center">
								<c:out value="${bean.readcount }"/>
							</div>
						</td>
					</tr>
				</c:forEach>
				<tr align="center">
					<td colspan="5">
						<c:if test="${start_page > 1 }">
							<a href="./bulletinlist.go?page=${start_page-1 }">
								<span class="glyphicon glyphicon-chevron-left"></span>
							</a>
						</c:if>
						<c:forEach  var="page" begin="${start_page}" end="${end_page }" >
							<a href="./bulletinlist.go?page=${page }">[<c:out value="${page}"/>]</a>
						</c:forEach>
						<c:if test="${end_page < max_page }">
							<a href="./bulletinlist.go?page=${end_page+1 }">
								<span class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</c:if>
					</td>
				</tr>
				
				<tr align="right">
					<td colspan="5">
						<c:if test="${not empty login_OK_id }">
				   			<a href="./bulletinWrite.go">[글쓰기]</a>
				   		</c:if>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
