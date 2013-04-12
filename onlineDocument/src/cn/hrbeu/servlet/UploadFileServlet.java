package cn.hrbeu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		if(ServletFileUpload.isMultipartContent(req))
		{
			UploadFileForm form=new UploadFileForm();
			form.upload(req);
			req.setAttribute("path", form.getName());
			req.getRequestDispatcher("/paper.jsp").forward(req, resp);
		}
	}
	
}
