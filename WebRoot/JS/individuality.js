/*****************       Ajax      *****************/
/*****************      个性化 ↓    *****************/
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
function handindividuality(){
	if(xmlhttpreq.readyState == 4){
		if(xmlhttpreq.status == 200){
			var str=xmlhttpreq.responseText;
			alert(str);
		}
	}
}
function individuality(goodsID){
	//alert(goodsID);

	var url="FavoritsInsert?goodsID="+goodsID;
	createXMLHttpRequest();
	xmlhttpreq.open("post",url,true);
	xmlhttpreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlhttpreq.onreadystatechange=handindividuality;
	xmlhttpreq.send(null);

}