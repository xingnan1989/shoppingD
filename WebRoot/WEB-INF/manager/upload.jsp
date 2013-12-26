 <%@ page language="java" pageEncoding="UTF-8"%>
 <!--<script type="text/javascript">

	var XmlHttpRequest = false;
	function createXMLHttpRequest() {
		if(window.XMLHttpRequest) {
			XmlHttpRequest = new XMLHttpRequest();
		} else {
			if(window.ActiveXObject) {
				try {
					XmlHttpRequest = new ActiveXObject("MSXML2.XMLHTTP");
				} catch(e) {
					try {
						XmlHttpRequest = new ACtiveXObject("Mocrisoft");
					} catch(e) {
					}
				} 
			}
		}
	}
	function copy() {
		var path = document.getElementById("filepic").value;
		alert(path);
		sendRequest("GetPicturePathAjax");
	}
	function sendRequest(url) {
		createXMLHttpRequest();
		XmlHttpRequest.open("post",url,true);
    	XmlHttpRequest.onreadystatechange = handleResponse;
    	alert("傻瓜化");
    	//XmlHttpRequest.setRequestHeader ("content-type","application/x-www-form-urlencoded");
    	XmlHttpRequest.send("");
    	}
   	function handleResponse() {
   		if (XmlHttpRequest.readyState == 4) {
   		alert("傻瓜化");
   			if (XmlHttpRequest.status == 200) {
   			alert("傻瓜化");
   				document.getElementById("filePic").innterHTML = "dfgh";
   			}
   		}
   	}

</script>//-->

<form action="UpLoad" method="post" enctype="multipart/form-data">
 <input type="file" id="filePic" name="filePictrue">
 <input type="" name="sub" value="上传" >
</form>