package com.web.bulletin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.bulletin.model.BulletinBean;
import com.web.bulletin.model.BulletinDAO;
import com.web.common.Action;
import com.web.common.ActionForward;

public class BulletinListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	request.setCharacterEncoding("utf-8");
	
		int limit_page=5;
		int page_range=3;
		int f_page=1;
		
		BulletinDAO dao = new BulletinDAO();
		int list_allea=dao.get_list_all_count();
		int max_page= list_allea/limit_page;
		
		if(list_allea%limit_page >0){
			max_page++;
		}
		
		int page_block_EA= (int)Math.ceil((double)max_page/page_range);
		System.out.println(page_block_EA);
		
		String getPage=request.getParameter("page");
		
		if(getPage != null)		{
			f_page=Integer.parseInt(getPage);
		}

		//current block value
		int current_block=(int)Math.ceil((double)f_page/page_range);
		//current block start value
		int start_page = (current_block-1) *page_range + 1;
		//currnet block end value
		int end_page = current_block * page_range;
		if(end_page > max_page)
		{end_page =max_page;}
		
		ArrayList<BulletinBean> list=dao.getList(f_page, limit_page);
		
		HttpSession session = request.getSession();
		session.setAttribute("contents_page", "./bulletin/bulletin_list.jsp");
		session.setAttribute("list", list);
		session.setAttribute("list_allea", list_allea);
		session.setAttribute("max_page", max_page);
		session.setAttribute("start_page", start_page);
		session.setAttribute("end_page", end_page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		return forward;
	}
	
}
