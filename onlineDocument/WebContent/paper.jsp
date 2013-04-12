<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>browser</title>
<script type="text/javascript">
function loadSwf()
{
	var fl=document.getElementById("flexPaperTest");  
	if(navigator.appName.indexOf("Microsoft") != -1) 
	{  
		;
	}  
	else
	{  
		fl = document.getElementById("flexPaperEmbedTest");  
	}
	var flag=fl.setJFile("${path}");
}

</script>
</head>
<body onload="loadSwf()">
	<div>
		<input type="button" value="upload" onclick="loadSwf()">
	</div>
	<div style="height: 100%; width: 900px; margin: auto;">
		<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
			width="900px" height="100%" id="flexPaperTest">
			<param name="movie" value="flexPaper/flexPaperTest.swf" />
			<param name="quality" value="high" />
			<param name="bgcolor" value="#ffffff" />
			<param name="allowScriptAccess" value="sameDomain" />
			<param name="allowFullScreen" value="true" />
			<embed src="flexPaper/flexPaperTest.swf" 
				width="900px" height="100%"
				align="middle" 
				loop="false" 
				type="application/x-shockwave-flash"
				id="flexPaperEmbedTest">
			</embed>
		</object>
	</div>
</body>
</html>