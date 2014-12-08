package com.web.member;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.model.MemberCheck;
import com.web.model.MemberDAO;
import com.web.model.MemberDTO;

public class MemberController extends HttpServlet {

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String Req_uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = Req_uri.substring(contextPath.length()+1);
		HttpSession session = req.getSession();
		System.out.println(command);
		if(command.equals("loginProcess.mo")){
			String id=req.getParameter("user_id");
			String pw=req.getParameter("user_pass");
			
			MemberDAO dao = new MemberDAO();
			MemberCheck result_mc=dao.CheckDuplicationOfMember(id, pw);
			
			session.setAttribute("mc", result_mc);
			if(result_mc.getName()==null){
				session.setAttribute("contents_page","./member/loginForm.jsp");
			}else{
				session.setAttribute("login_OK_id",id);
				session.removeAttribute("contents_page");
			}
			resp.sendRedirect("index.jsp");
		}else if(command.equals("logout.mo")){
			session.removeAttribute("mc");
			session.removeAttribute("login_OK_id");
			session.removeAttribute("contents_page");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("joinForm.mo")){
			session.setAttribute("contents_page", "./member/joinForm.jsp");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("loginJoinAction.mo")){
			String id=req.getParameter("userid");
			String pass=req.getParameter("userpass");
			String name=req.getParameter("username");
			String email=req.getParameter("useremail");
			
			MemberDTO to = new MemberDTO();
			to.setId(id);
			to.setPass(pass);
			to.setName(name);
			to.setEmail(email);
			
			MemberDAO dao=new MemberDAO();
			dao.insertMember(to);
			
			session.removeAttribute("contents_page");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("memberView.mo")){
			MemberDAO dao = new MemberDAO();
			Vector<MemberDTO> result_memberAll=dao.selectAllMember();
			
			session.setAttribute("result_memberAll", result_memberAll);
			session.setAttribute("contents_page", "./member/memberView.jsp");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("deleteMember.mo")){
			String del_id=req.getParameter("del_id");
			MemberDAO dao= new MemberDAO();
			dao.deleteMember(del_id);
			
			session.setAttribute("contents_page", "./member/memberView.jsp");
			resp.sendRedirect("./memberView.do");
		}else if(command.equals("getModifyMember.mo")){
			String modify_id=req.getParameter("modify_id");
			
			MemberDAO dao= new MemberDAO();
			MemberDTO to=dao.getModifyMember(modify_id);
			session.setAttribute("to", to);
			session.setAttribute("contents_page", "./member/modifyMember.jsp");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("modifyProcess.mo")){
			String id=req.getParameter("userid");
			String pass=req.getParameter("userpass");
			String name=req.getParameter("username");
			String email=req.getParameter("useremail");
			
			MemberDTO to=new MemberDTO();
			to.setEmail(email);
			to.setId(id);
			to.setName(name);
			to.setPass(pass);
			
			MemberDAO dao = new MemberDAO();
			dao.modifyProcess(to);
			session.setAttribute("contents_page", "./member/memberView.jsp");
			resp.sendRedirect("./memberView.do");

		}else if(command.equals("login.mo")){
			session.setAttribute("contents_page", "./member/loginForm.jsp");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("index.mo")){
			session.removeAttribute("contents_page");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("sendemail.mo")){
			session.setAttribute("contents_page", "./member/sentemail.jsp");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("forgotpw.mo")){
			session.setAttribute("contents_page", "./member/forgotpw.jsp");
			resp.sendRedirect("index.jsp");
		}else if(command.equals("joinForm.mo")){
			session.setAttribute("contents_page", "./member/joinForm.jsp");
			resp.sendRedirect("index.jsp");
		}
        
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}

		
}
