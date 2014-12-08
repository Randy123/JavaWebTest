package com.web.chart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.chart.action.ChartShowAction;
import com.web.common.Action;
import com.web.common.ActionForward;

public class ChartController extends HttpServlet{

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String Req_uri=req.getRequestURI();
		String[] path=Req_uri.split("/");
		String command=path[path.length-1];
		
		ActionForward forward =null;
		Action action1 = null;
		
		if(command.equals("chart.ct")){
			action1 =new ChartShowAction();
			
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
