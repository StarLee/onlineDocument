package cn.hrbeu;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class Transform2Swf implements Runnable
{
	private String filePath;
	private String destinationPath;
	private String tempPath;
	public Transform2Swf(String filePath, String destinationPath)
	{
		this.filePath = filePath;
		this.destinationPath = destinationPath;
	}

	private boolean raw2Pdf()
	{
		File inputFile = new File(filePath);
		this.tempPath=System.getProperty("java.io.tmpdir") + "temp_"+new Date().getTime()
				+ Thread.currentThread().getName() + ".pdf";
		File outputFile = new File(tempPath);
		System.out.println(this.tempPath);
		// connect to an OpenOffice.org instance running on port 8100
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
		try
		{
			connection.connect();
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		// convert
		DocumentConverter converter = new OpenOfficeDocumentConverter(
				connection);
		try
		{
			converter.convert(inputFile, outputFile);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			connection.disconnect();
		}
		return true;
	}

	@Override
	public void run()
	{
		try
		{
			if(!raw2Pdf())
			{
				return ;
			}
			String[] exe = new String[]
			{ "pdf2swf", tempPath,"-s","flashversion=9","-o", destinationPath };
			Process process = Runtime.getRuntime().exec(exe);
			int flag = process.waitFor();
			if (flag == 0)
			{
				System.out.println("exit");
			} else
			{
				byte[] error = new byte[1024];
				InputStream input = process.getErrorStream();
				input.read(error);
				System.out.println(new String(error).trim());
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally{
			File file=new File(tempPath);
			file.delete();
		}
	}

}
