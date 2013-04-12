package cn.hrbeu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class Test
{
	public static void main(String[] args) throws FileNotFoundException
	{
		new Thread(new Transform2Swf("E:\\Àî³ÐÅô£ºÁåîõÏÂµÄ¹·.docx", "E:\\sss.swf")).start();
	}
}
