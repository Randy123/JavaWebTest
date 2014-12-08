package com.web.chat;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.common.Action;
import com.web.common.ActionForward;

public class ChatController extends HttpServlet{

	
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
		//Action action1 = null;
		HttpSession session = req.getSession();
		
		
		if(command.equals("chat.cr")){
			session.setAttribute("contents_page", "./chat/chat_main.jsp");
			forward = new ActionForward();
			forward.setRedirect(true);
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
