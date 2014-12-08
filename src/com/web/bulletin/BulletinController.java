package com.web.bulletin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.bulletin.action.BulletinAddAction;
import com.web.bulletin.action.BulletinCommentAction;
import com.web.bulletin.action.BulletinDetailAction;
import com.web.bulletin.action.BulletinListAction;
import com.web.common.Action;
import com.web.common.ActionForward;

public class BulletinController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String Req_uri=req.getRequestURI();
		String[] path=Req_uri.split("/");
		String command=path[path.length-1];
		
		ActionForward forward =null;
		Action action1 = null;
		HttpSession session = req.getSession();
		if(command.equals("bulletinAddAction.go")){
			action1 = new BulletinAddAction();
			try {
				forward = action1.execute(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("bulletinWrite.go")){
			session.setAttribute("contents_page", "./bulletin/bulletin_write.jsp");
			forward = new ActionForward();
			forward.setRedirect(true);
		}else if(command.equals("bulletinList.go")){
			action1 =new BulletinListAction();
			
			try {
				forward=action1.execute(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("bulletinDetail.go")){
			
			action1 =new BulletinDetailAction();
			
			try {
				forward=action1.execute(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("bulletinComment.go")){
			action1 =new BulletinCommentAction();
			try {
				forward=action1.execute(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(forward != null){
			if(forward.isRedirect()){
				resp.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
}
