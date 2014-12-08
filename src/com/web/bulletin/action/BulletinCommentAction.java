package com.web.bulletin.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.web.bulletin.model.BulletinDAO;
import com.web.bulletin.model.CommentBean;
import com.web.common.Action;
import com.web.common.ActionForward;

public class BulletinCommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String Comment_ID=(String)session.getAttribute("login_OK_id");
		String Comment_IP=request.getRemoteAddr();
		
		int b_num =Integer.parseInt(request.getParameter("b_num"));;

		String Comment_contents=request.getParameter("comment_content");
		
		CommentBean bean=new CommentBean();
		bean.setcomment_ID(Comment_ID); 
		bean.setcomment_contents(Comment_contents); 
		bean.setb_num(b_num); 
		bean.setcomment_IP(Comment_IP);
		BulletinDAO dao=new BulletinDAO();
		ArrayList<CommentBean> data=dao.comment_process(bean);
		JSONArray list=new JSONArray();
		
		for(int i=0; i<data.size(); i++){
			
			JSONObject obj=new JSONObject();
			obj.put("Comment_num", data.get(i).getcomment_num());
			obj.put("Comment_ID", data.get(i).getcomment_ID());
			obj.put("Comment_contents", data.get(i).getcomment_contents());
			obj.put("Comment_date", data.get(i).getcomment_date());
			obj.put("Comment_IP", data.get(i).getcomment_IP());
			obj.put("B_num", data.get(i).getb_num());
			list.add(obj);
		}
		
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw=response.getWriter();
		pw.println(list);
		pw.flush();
		pw.close();
		
		ActionForward action = new ActionForward();
		action.setRedirect(false);
		
		return action;
	}
}
