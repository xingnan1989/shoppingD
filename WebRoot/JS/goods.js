/*****************       Ajax      *****************/
var xmlhttpreq = false;
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) {
		xmlhttpreq = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			try {
				xmlhttpreq = new ActiveXObject("Msm12.XMLHttp");
			}
			catch (e) {
				try {
					xmlhttpreq = new ActiveXObject("Microsoft.XMLHttp");
				}
				catch (e) {
				}
			}
		}
	}
}
/*****************       用户评论      *****************/

function handcomment(){
	if(xmlhttpreq.readyState==4){
		if(xmlhttpreq.status==200){
			var str=xmlhttpreq.responseText;
			//alert("ajax:"+str);
		}
	}
}
function comment(goodsID){
	alert(goodsID);
	var comment="commentContent="+document.getElementById("commentContent").value+"&goodsID="+goodsID;
	var url="CommentSubmit";
	//alert(comment);
	//alert(goodsID);
	createXMLHttpRequest();
	xmlhttpreq.open("post",url,true);
	xmlhttpreq.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttpreq.onreadystatechange=handcomment;
	xmlhttpreq.send(comment);
}