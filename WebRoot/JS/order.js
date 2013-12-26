
/*****************       Ajax      *****************/
/*****************       购物车      *****************/
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
/*****************       shopupdate       *****************/
function handshopcarUpdate() {
	if (xmlhttpreq.readyState == 4) {
		if (xmlhttpreq.status == 200) {
			var str = xmlhttpreq.responseText;
			//alert(str);
			var strArray = new Array();
			strArray = str.split("|");
			var countgoodsNormalPrice = strArray[0];
			var countgoodsMemberPrice = strArray[1];
			var s = strArray[2];
			document.getElementById("countgoodsNormalPrice").innerHTML = countgoodsNormalPrice;
			document.getElementById("countgoodsMemberPrice").innerHTML = countgoodsMemberPrice;
			alert(s);
			//alert(countgoodsNormalPrice);
			//alert(countgoodsMemberPrice);
		}
	}
}

function shopcarUpdate(goodsID,num,goodnumID) {
		var url = "OrderShopcarUpdate?num=" + num + "&goodsID=" + goodsID;
		//shopcarSubmit(num);
		createXMLHttpRequest();
		xmlhttpreq.open("get", url, true);
		xmlhttpreq.onreadystatechange = handshopcarUpdate;
		xmlhttpreq.send(null);

}
/*****************       shopdelete       *****************/
function deleteshop(goodsID) {
	alert(goodsID);
}
/*****************         购物车 ↑   *****************/
/*****************       订单修改地址信息 ↓   *****************/
function handorderAddressUpdate() {
	if (xmlhttpreq.readyState == 4) {
		if (xmlhttpreq.status == 200) {
			var str = xmlhttpreq.responseText;
			//alert(str);
			var strArray = new Array();
			strArray = str.split(",");
			var inputmemberTrueName = strArray[0];
			//alert(inputmemberTrueName);
			var inputmemberAddress = strArray[1];
			var inputmemberPostcode = strArray[2];
			var inputmemberTelephone = strArray[3];
			document.getElementById("inputmemberTrueName").innerHTML = "<input type='text' value=" + inputmemberTrueName + " id='1' >";
			document.getElementById("inputmemberAddress").innerHTML = "<input type='text' value=" + inputmemberAddress + " id='2' >";
			document.getElementById("inputmemberPostcode").innerHTML = "<input type='text' value=" + inputmemberPostcode + " id='3' >";
			document.getElementById("inputmemberTelephone").innerHTML = "<input type='text' value=" + inputmemberTelephone + " id='4' >";
			document.getElementById("button").innerHTML = "<input type='button' value='保存' onclick='orderAdderssSave()' >";
			document.getElementById("address").innerHTML="";
		}
	}
}
function orderAddressUpdate() {
	var url = "OrderAddressUpdate";
	createXMLHttpRequest();
	xmlhttpreq.open("post", url, true);
	xmlhttpreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttpreq.onreadystatechange = handorderAddressUpdate;
	xmlhttpreq.send(null);
}
/*****************          订单修改地址信息 ↑   *****************/
/*****************          保存订单修改地址信息 ↓   *****************/
function handorderAddressSave() {
	if (xmlhttpreq.readyState == 4) {
		if (xmlhttpreq.status == 200) {
			var str = xmlhttpreq.responseText;
			//alert(str);
			var strArray=new Array();
			strArray=str.split(",");
			var inputmemberTrueName = strArray[0];
			//alert(inputmemberTrueName);
			var inputmemberAddress = strArray[1];
			var inputmemberPostcode = strArray[2];
			var inputmemberTelephone = strArray[3];
			document.getElementById("inputmemberTrueName").innerHTML =inputmemberTrueName;
			document.getElementById("inputmemberAddress").innerHTML =inputmemberAddress;
			document.getElementById("inputmemberPostcode").innerHTML =inputmemberPostcode;
			document.getElementById("inputmemberTelephone").innerHTML =inputmemberTelephone;
			document.getElementById("button").innerHTML = "<input type='button' value='修改' onclick='orderAddressUpdate()'>";
		}
	}
}
function orderAdderssSave() {
	var falg=memberAddress();
	if(falg==true){
		document.getElementById("address").innerHTML="";
		var address = "address=" + document.getElementById("1").value + "," + document.getElementById("2").value + "," + document.getElementById("3").value + "," + document.getElementById("4").value;
		//alert(inputmemberTrueName+" "+inputmemberAddress+" "+inputmemberPostcode+" "+inputmemberTelephone);
		var url = "OrderAddressSave";
		createXMLHttpRequest();
		xmlhttpreq.open("post", url, true);
		xmlhttpreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlhttpreq.onreadystatechange = handorderAddressSave;
		xmlhttpreq.send(address);
	}else{
		document.getElementById("address").innerHTML="&nbsp;<img src='images/false.gif'>&nbsp;您的输入有误"
	}
	
}
/*****************          保存订单修改地址信息 ↑   *****************/

/*****************             修改付款方式 ↓    *****************/
function handorderPayModeUpdate(){
	if(xmlhttpreq.readyState==4){
		if(xmlhttpreq.status==200){
			var str=xmlhttpreq.responseText;
			var strArray=new Array();
			var payID=new Array();
			var payContent=new Array();
			strArray=str.split("|");
			document.getElementById("orderPayMode").innerHTML="<select name='orderPayMode' onblur='payMode_Text()'><option value='0'>'请选择'</option></select>";
			document.getElementById("button2").innerHTML="<input type='button' value='保存' onclick='payMode_Text()'>";
			falg=false;
			var select=document.form_checkout.orderPayMode;
			for(i=0;i<strArray.length-1;i++){
				payID[i]=strArray[i].split(",")[0];
				payContent[i]=strArray[i].split(",")[1];
				select.length=strArray.length-1;
				select.options[i].value=payID[i];
				select.options[i].text=payContent[i];
			}
		}
	}
}
var payid=null;
function orderPayModeUpdate(){
	var url="OrderPayModeUpdate";
	createXMLHttpRequest();
	xmlhttpreq.open("post",url,true);
	xmlhttpreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttpreq.onreadystatechange = handorderPayModeUpdate;
	xmlhttpreq.send(null);
}

/*****************        将修改的付款方式变为文本并更新session中的payContent   *****************/
function handpayMode_Text(){
	if(xmlhttpreq.readyState==4){
		if(xmlhttpreq.status==200){
			var payContent=xmlhttpreq.responseText;
			document.getElementById("orderPayMode").innerHTML=payContent;
			document.getElementById("button2").innerHTML="<input type='button' value='修改' onclick='orderPayModeUpdate()'>";
		}
	}
}
function payMode_Text(){
	var url="OrderPayMode_Text";
	var payID="payID="+document.form_checkout.orderPayMode.selectedIndex;
	if(document.form_checkout.orderPayMode.selectedIndex != 0){
		createXMLHttpRequest();
		xmlhttpreq.open("post",url,true);
		xmlhttpreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlhttpreq.onreadystatechange = handpayMode_Text;
		xmlhttpreq.send(payID);
		falg=true;
	}else{
		falg=false;
	}
	payModevalidate()
}
/*****************         修改付款方式  ↑    *****************/

/*****************         地址级联 ↓   *****************/
/*------------------------------------ 刷新城市 -------------------------------------->*/   	
    	function handCityAjax(){
    		if(xmlhttpreq.readyState==4){
    			if(xmlhttpreq.status==200){
    				var c_str=xmlhttpreq.responseText;
    				//alert(c_str);
    				var city=c_str.split("|");
    				var c_code=new Array();
    				var c_name=new Array();
    				for(i=1;i<city.length;i++){
    					c_code[i]=city[i].split(",")[0];
    					c_name[i]=city[i].split(",")[1];
    				}
    				var p_select=document.form_checkout.province;  
    				var c_select=document.form_checkout.city;  				
    				for(j=0;j<p_select.length;j++){
    					if(document.form_checkout.province.selectedIndex==j){
	    					c_select.selectedIndex=0;
	    					c_select.length=city.length;
	    					c_select.options[0].text="请选择";
	    					c_select.options[0].value="0";
		    				for(i=1;i<c_select.length;i++){
		    					c_select.options[i].text=c_name[i];
		    					c_select.options[i].value=c_code[i];
	    					}
    					}
    				}
    				if(document.form_checkout.city.selectedIndex==0){
    					document.form_checkout.area.length=1;
    					document.form_checkout.area.selectedIndex=0;
    					document.form_checkout.area.options[0].text="请选择";
    					document.form_checkout.area.options[0].value="0";
    				}
    			}
    		}
    	}
    	
    	function sendCityAjax(){
    		var provinceCode=document.form_checkout.province.options[document.form_checkout.province.selectedIndex].value;
    		var url="SelectCityServlet";
    		var provinceCode="provinceCode="+provinceCode;
    		createXMLHttpRequest();
    		xmlhttpreq.open("post",url,true);
    		xmlhttpreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    		xmlhttpreq.onreadystatechange=handCityAjax;
    		xmlhttpreq.send(provinceCode);
    	}
<!------------------------------------ 刷新地区 -------------------------------------->   
		function handAreaAjax(){
			if(xmlhttpreq.readyState==4){
				if(xmlhttpreq.status==200){
					var a_str=xmlhttpreq.responseText;
					//alert(ct_str);
					var area=a_str.split("|");
					var a_code=new Array();
					var a_name=new Array();
					for(i=1;i<area.length;i++){
						a_code[i]=area[i].split(",")[0];
						a_name[i]=area[i].split(",")[1];
					}
					//alert(city.length);
					var a_select=document.form_checkout.area;
					var c_select=document.form_checkout.city;
					for(j=0;j<c_select.length;j++){
						if(document.form_checkout.city.selectedIndex==j){
							a_select.selectedIndex=0;
							a_select.length=area.length;
							a_select.options[0].text="请选择"
							a_select.options[0].value="0";
							for(i=1;i<area.length;i++){
								a_select.options[i].text=a_name[i];
								//alert(ct_name[i]);
								a_select.options[i].value=a_code[i]
							}
						}
					}
					
				}
			}
		} 	   	
    	function sendAreaAjax(){
    		var cityCode=document.form_checkout.city.options[document.form_checkout.city.selectedIndex].value;
    		//alert(provint_id);
    		var url="SelectAreaServlet?cityCode="+cityCode;
    		createXMLHttpRequest();
    		xmlhttpreq.open("post",url,true);
    		xmlhttpreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    		xmlhttpreq.onreadystatechange=handAreaAjax;
    		xmlhttpreq.send(null);
    	}
/*****************        地址级联  ↑    *****************/

/*****************       修改送货方式 ↓    *****************/
function handorderCarryMode(){
	if(xmlhttpreq.readyState==4){
		if(xmlhttpreq.status==200){
			var str=xmlhttpreq.responseText;
			//alert(str);
			var strArray=new Array();
			var carryID=new Array();
			var carryContent=new Array();
			strArray=str.split("|");
			document.getElementById("orderCarryMode").innerHTML="<select name='orderCarryMode' onblur='carryMode_Text()'><option value='0'>'请选择'</option></select>";
			document.getElementById("orderCarryModebutton").innerHTML="<input type='button' value='保存' onclick='carryMode_Text()'>";
			falg2=false;
			var select=document.form_checkout.orderCarryMode;
			for(i=0;i<strArray.length-1;i++){
				carryID[i]=strArray[i].split(",")[0];
				carryContent[i]=strArray[i].split(",")[1];
				select.length=strArray.length-1;
				select.options[i].value=carryID[i];
				select.options[i].text=carryContent[i];
			}
		}
	}
}
var payid=null;
function OrderCarryMode(){
	var url="OrderCarryModeUpdate";
	createXMLHttpRequest();
	xmlhttpreq.open("post",url,true);
	xmlhttpreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttpreq.onreadystatechange = handorderCarryMode;
	xmlhttpreq.send(null);
}

/*****************       将修改的送货方式变为文本并更新session中的payContent   *****************/

function handcarryMode_Text(){
	if(xmlhttpreq.readyState==4){
		if(xmlhttpreq.status==200){
			var payContent=xmlhttpreq.responseText;
			//alert(handcarryMode_Text);
			document.getElementById("orderCarryMode").innerHTML=payContent;
			document.getElementById("orderCarryModebutton").innerHTML="<input type='button' value='修改' onclick='OrderCarryMode()'>";
		}
	}
}
function carryMode_Text(){
	//alert('carryMode_Text');
	var url="OrderCarryMode_Text";
	var carryID="carryID="+document.form_checkout.orderCarryMode.selectedIndex;
	if(document.form_checkout.orderCarryMode.selectedIndex != 0){
		createXMLHttpRequest();
		xmlhttpreq.open("post",url,true);
		xmlhttpreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlhttpreq.onreadystatechange = handcarryMode_Text;
		xmlhttpreq.send(carryID);
		falg2=true;
	}else{
		falg2=false;
	}
	carryModevalidate()
}

/*****************         修改送货方式  ↑    *****************/
/*****************        订单取消时验证  ↓    *****************/
function handordersend(){
	if(xmlhttpreq.readyState == 4){
		if(xmlhttpreq.status==200){
			var str=xmlhttpreq.responseText;	
			alert(str);
		}
	}
}
function ordersend(orderID){
	var url="OrderSendYorN?orderID="+orderID;
	createXMLHttpRequest();
	xmlhttpreq.open("post",url,true);
	xmlhttpreq.setRequestHeader("Content-Type","application/x-www/form-urlencoded");
	xmlhttpreq.onreadystatechange = handordersend;
	xmlhttpreq.send(null);
}
/*****************       订单取消时验证  ↑    *****************/
/*****************         添加商品到购物车  ↓    *****************/
function handgoodssend(){
	if(xmlhttpreq.readyState == 4){
		if(xmlhttpreq.status==200){
			var str=xmlhttpreq.responseText;	
			alert("商品已经添加到购物车，请注意查询");
		}
	}
}
function goods(goodsID){
	var url="OrderShopcar?goodsID="+goodsID;
	createXMLHttpRequest();
	xmlhttpreq.open("post",url,true);
	xmlhttpreq.setRequestHeader("Content-Type","application/x-www/form-urlencoded");
	xmlhttpreq.onreadystatechange = handgoodssend;
	xmlhttpreq.send(null);
}
/*****************         添加商品到购物车  ↑    *****************/


