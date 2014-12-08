<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container ">
	<div align="center" id="bulletin_add">
		<form action="bulletinAddAction.go" method="post" class="form-horizontal">
		
			<input type="hidden" name="bid" value="${login_OK_id }">
			<div class="form-group">
				<label class="col-sm-2 control-label">Author</label>
				<div class="col-sm-10">
					<c:out value="${login_OK_id }" />
				</div>
			</div>
			<div class="form-group">
				<label for="subject" class="col-sm-2 control-label">Subject</label>
				<div class="col-sm-10">
					<input type="text" name="subject" class="form-control"
						id="subject">
				</div>
			</div>
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">Content</label>
				<textarea class="form-control" name="bcontents" rows="15"
					id="content"></textarea>
			</div>
			<div class="form-group">

				<label class="col-sm-2 control-label">Add_File</label> 
				<input	name="bfile" type="file">

			</div>
			<br>
			<div class="form-group submit">
				<input type="submit" value="Submit" class="btn btn-primary"/> 
				<input type="reset" value="Reset" class="btn btn-primary"/>
			</div>

		</form>
	</div>
</div>

