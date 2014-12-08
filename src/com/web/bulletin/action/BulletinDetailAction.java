package com.web.bulletin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.bulletin.model.BulletinBean;
import com.web.bulletin.model.BulletinDAO;
import com.web.bulletin.model.CommentBean;
import com.web.common.Action;
import com.web.common.ActionForward;

public class BulletinDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String b_num = request.getParameter("b_num");
		
		
		BulletinDAO dao=new BulletinDAO();
		BulletinBean bean = dao.bulletinDetail(Integer.parseInt(b_num));
		ArrayList<CommentBean> comment_detalist = dao.comment_list(b_num);
							   
		HttpSession session = request.getSession();
		session.setAttribute("contents_page", "./bulletin/bulletin_detail.jsp");
		session.setAttribute("bulletin_detail", bean);
		session.setAttribute("comment_datalist", comment_detalist);
							  
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		return forward;
	}
	
}
