package com.web.bulletin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web.bulletin.model.BulletinBean;
import com.web.bulletin.model.BulletinDAO;
import com.web.common.Action;
import com.web.common.ActionForward;

public class BulletinAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BulletinBean bulletindata = new BulletinBean();
		
		String bulletin_id = request.getParameter("bid");
		String bulletin_subject = request.getParameter("subject");
		String bulletin_contents = request.getParameter("bcontents");
		String bulletin_file = request.getParameter("bfile");
		
		bulletindata.setBid(bulletin_id);
		bulletindata.setSubject(bulletin_subject);
		bulletindata.setBcontents(bulletin_contents);
		bulletindata.setBfile(bulletin_file);
		
		BulletinDAO dao = new BulletinDAO();
		boolean result=dao.bulletinInsert(bulletindata);
		
		if(result==false){
			System.out.println("Failed");
			return null;
		}else{
			System.out.println("Succeed");
		}
		
		String realFolder="";
		String saveFolder="bulletinupload";
		int fileSize= 10*1024*1024;
		realFolder=request.getSession().getServletContext().getRealPath(saveFolder);
		
		try{
			MultipartRequest multi=null;
			multi=new MultipartRequest(
						request,
						realFolder,
						fileSize,
						"utf-8",
						new DefaultFileRenamePolicy());
		}
		catch(Exception e){}
		
		
		ActionForward forward =new ActionForward();
		forward.setRedirect(true);
		forward.setPath("bulletinList.go");
		return forward;
	}
	
	

}
