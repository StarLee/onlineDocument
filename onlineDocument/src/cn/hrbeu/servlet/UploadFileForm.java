package cn.hrbeu.servlet;

import java.io.File;
import java.lang.Thread.State;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.hrbeu.Transform2Swf;

public class UploadFileForm
{
	private String name = "logo.swf";

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void upload(HttpServletRequest req)
	{
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try
		{
			List<FileItem> items = upload.parseRequest(req);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext())
			{
				FileItem item = (FileItem) iter.next();

				if (item.isFormField())
				{
					System.out.println(item.getFieldName());
				} else
				{
					File file = new File(req.getServletContext().getRealPath(
							"/")
							+ item.getName());
					item.write(file);
					System.out.println(file.getAbsolutePath());
					String name = new Date().getTime() + "_" + file.getName()
							+ ".swf";
					String pathDes = req.getServletContext().getRealPath("/")
							+ name;
					Thread thread = new Thread(new Transform2Swf(
							file.getAbsolutePath(), pathDes));
					thread.start();
					//System.out.println(thread.getState());
					while (true)
					{
						if (thread.getState().compareTo(State.TERMINATED) != 0)
						{
							//System.out.println("over");
							this.name = name;
							break;
						}
					}
				}
			}
		} catch (FileUploadException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
