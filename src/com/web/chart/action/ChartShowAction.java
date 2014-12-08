package com.web.chart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.common.Action;
import com.web.common.ActionForward;
import com.web.model.ChartBean;
import com.web.model.ChartDAO;

public class ChartShowAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String m_id =(String)session.getAttribute("login_OK_id");
		
		System.out.println("-----------");
		System.out.println(m_id);
		ChartDAO dao=new ChartDAO();
		
		ArrayList<ChartBean> chart_bean = dao.ChartShow(m_id);
							   

		session.setAttribute("contents_page", "./chart/chart_main.jsp");
		session.setAttribute("chart_bean", chart_bean);
							  
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		return forward;
	}

}
