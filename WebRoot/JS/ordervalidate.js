/*****************      ���ﳵ   其他功能      *****************/
//支付方式JS验证
var falg=true;
function payModevalidate(){
	if(falg==true){
		document.getElementById("payMode_v").innerHTML="";
		return true;
	}else{
		document.getElementById("payMode_v").innerHTML="&nbsp;<img src='images/false.gif'>&nbsp;请选择支付方式";
		return false;
	}
}
//送货方式JS验证
var falg2=true;
function carryModevalidate(){
	if(falg2==true){
		document.getElementById("carryMode_v").innerHTML="<";
		return true;
	}else{
		document.getElementById("carryMode_v").innerHTML="&nbsp;<img src='images/false.gif'>&nbsp;请选择邮寄方式";
		return false;
	}
}
//送货时间JS验证
function orderCarryTimevalidate(){
	var falg=false;
	var time=document.form_checkout.time1;
	for(var i=0;i<time.length;i++){
		if(time[i].checked){
			falg=true;
			break;
		}
	}
	if(falg==true){
		//alert('true');
		document.getElementById("orderCarryTime_v").innerHTML="";
		return true;
	}else{
		//alert('false');
		document.getElementById("orderCarryTime_v").innerHTML="&nbsp;<img src='images/false.gif'>&nbsp;请选择送货时间";
		return false;
	}
}
//发票
function nd1(){
	document.getElementById("need").innerHTML="<input type='checkbox' name='needinvoice'  class='noborder' checked onclick='nd2()'>";
	document.getElementById("ndtext").innerHTML="抬头：<input name='invoicetitle' id='invoicetitle' type='text' size=16 >";	
	document.getElementById("needselect").innerHTML="内容：<SELECT NAME='invoicecontent' id='invoicecontent'>"+
						      				   "<option value='请选择' selected='selected'>请选择</option>"+
										       "<option value='图书册'>图书</option>"+
				                               "<option value='影视碟'>影视</option>"+
				                               "<option value='游戏碟'>游戏</option>"+
				                               "<option value='软件碟'>软件</option>"+
										       "<option value='资料件'>资料</option>"+
										       "<option value='办公用品个'>办公用品</option>"+
										       "<option value='洗涤用品件'>洗涤用品</option>"+
										       "<option value='化妆品件'>化妆品</option>"+
										       "<option value='体育用品件'>体育用品</option>"+
										       "<option value='劳保用品件'>劳保用品</option>"+
										       "<option value='服装件'>服装</option>"+
				                               "<option value='玩具件'>玩具</option>"+
				                               "<option value='饰品件'>饰品</option>"+
										       "<option value='手机件'>手机</option>"+
										       "<option value='家电件'>家电</option>"+
										       "<option value='配件件'>配件</option>"+
										       "<option value='数码产品件'>数码产品</option>"+
				                            "</select>";
									
}
function nd2(){
	document.getElementById("need").innerHTML="<input type='checkbox' name='needinvoice'  class='noborder' onclick='nd1()'>";
	document.getElementById("ndtext").innerHTML="";
	document.getElementById("needselect").innerHTML="";
}

function shopcarSubmit(goodnum,id){
	var shopcarFormat=/^\d+$/;
	if(!shopcarFormat.test(goodnum)){
		alert('输入非法');
		document.getElementById(id).value="1";
	}
}

//验证姓名
function ordername(){
	var name=document.getElementById("1").value;
	//alert(name);
	var nameFormat=/^[u4EOO-\u9FA5]+$/;
	if(!nameFormat.test(name)){
		document.getElementById("namespan").innerHTML="&nbsp;<img src='images/false.gif'>&nbsp;请输入正确的姓名";
		return false;
	}else{
		document.getElementById("namespan").innerHTML="";
		return true;
	}
}
//验证地址
function orderaddress(){
	var address=document.getElementById("2").value;
	var addressFormat=/^[u4EOO-\u9FA5]+$/;
	if(!addressFormat.test(address)){
		document.getElementById("addressspan").innerHTML="&nbsp;<img src='images/false.gif'>&nbsp;请输入正确的地址";
		return false;
	}else{
		document.getElementById("addressspan").innerHTML="";
		return true;
	}
}
//邮编验证
function orderpostcode(){
	var postcode=document.getElementById("3").value;
	var postcodeFormat=/^\d{6}$/;
	if(!postcodeFormat.test(postcode)){
		document.getElementById("postcodespan").innerHTML="&nbsp;<img src='images/false.gif'>&nbsp;请输入正确的邮编";
		return false;
	}else{
		document.getElementById("postcodespan").innerHTML="";
		return true;
	}
}
//电话验证
function ordertelephone(){
	var telephone=document.getElementById("4").value;
	var telephoneFormat=/^\d{3}-\d{8}|\d{4}-\d{7}$/;
	if(!telephoneFormat.test(telephone)){
		document.getElementById("telephonespan").innerHTML="&nbsp;<img src='images/false.gif'>&nbsp;请输入正确的电话号码";
		return false;
	}else{
		document.getElementById("telephonespan").innerHTML="";
		return true;
	}
}

//地址提交验证
var falgmemberAddress=true;
function memberAddress(){
	if(ordername() && orderaddress() && orderpostcode() && ordertelephone()){
		falgmemberAddress=true;
		return true;
	}else{
		falgmemberAddress=false;
		return false;
	}
}

//验证地址级联
function addressPCA(){
	var pro = document.form_checkout.province.value;
	var city = document.form_checkout.city.value;
	var area = document.form_checkout.area.value;
	var add = document.getElementById("addressPCAspan");
	//alert(pro);
	//alert('?????????????');
	if(pro ==0 || city == 0 || area == 0){
		//alert('请选择正确的地');
		add.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;请选择正确的地址"
		return false;
	}else{
		//alert('YES');
		add.innerHTML = "&nbsp;<img src='images/true.gif'>";
		return true;
	}
}
//订单体提交验证
function submitl(){
	var city=document.form_checkout.city.options[document.form_checkout.city.selectedIndex].text;
	//alert(city);
	if(payModevalidate() && carryModevalidate() && orderCarryTimevalidate() && falgmemberAddress && addressPCA()){
		return true;
	}else{
		return false;
	}
}