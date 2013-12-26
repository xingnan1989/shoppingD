var memberfalg=false
function regcheck() {
	
       

        //用户名长度3-16个字符,由字母、数字、下划线组成
	var nametest = /^\w{3,16}$/;
	var nametip = document.getElementById("nametip");
	if (document.reg.memberName.value == "") {
		nametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u7528\u6237\u540d\u4e0d\u80fd\u4e3a\u7a7a\uff01";
		return false;
	} else {
		if (!nametest.test(document.reg.memberName.value)) {
			nametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u7528\u6237\u540d\u5e94\u75313-16\u4e2a\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff01";
			return false;
		} else {
			if(memberfalg == false){
				nametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;该用户名已经存在！"
			}else{
				nametip.innerHTML = "&nbsp;<img src='images/true.gif'>";
			}
			
		}
	}
   

	    //密码长度为6-16个字符
	var pwdtip = document.getElementById("pwdtip");
	if (document.reg.memberPassword.value == "") {
		pwdtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (document.reg.memberPassword.value.length < 6 || document.reg.memberPassword.value.length > 16) {
			pwdtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u5bc6\u7801\u957f\u5ea6\u5e94\u4e3a6-16\u4e2a\u5b57\u7b26";
			return false;
		} else {
			pwdtip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    

	    //验证确认密码
	var cfpwdtip = document.getElementById("cfpwdtip");
	if (document.reg.memberPassword2.value != document.reg.memberPassword2.value) {
		cfpwdtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u4e24\u6b21\u5bc6\u7801\u4e0d\u4e00\u81f4!";
		return false;
	} else {
		cfpwdtip.innerHTML = "&nbsp;<img src='images/true.gif'>";
	}

	    

	    //验证邮箱
	var emailtest = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	var emailtip = document.getElementById("emailtip");
	if (document.reg.memberEmail.value == "") {
		emailtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u90ae\u7bb1\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!emailtest.test(document.reg.memberEmail.value)) {
			emailtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u90ae\u7bb1\u683c\u5f0f\u4e0d\u6b63\u786e!";
			return false;
		} else {
			emailtip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    

	    //验证姓名
	var truenametest = /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0]|[A-Z]|[a-z]){2,20}$/;
	var truenametip = document.getElementById("truenametip");
	if (document.reg.memberTrueName.value == "") {
		truenametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u59d3\u540d\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!truenametest.test(document.reg.memberTrueName.value)) {
			truenametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u59d3\u540d\u53ea\u80fd\u662f\u4e2d\u6587\u6216\u82f1\u6587!";
			return false;
		} else {
			truenametip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    

	    //验证地区
	var pro = document.reg.province.selectedIndex;
	var city = document.reg.city.selectedIndex;
	var area = document.reg.area.selectedIndex;
	var add = document.getElementById("add");
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

	    //验证地址
	var addresstest = /^([\u4E00-\u9Fa5]|[\uFe30-\uFFA0]|[A-Z]|[a-z]|[\d]){3,}$/;
	var addresstip = document.getElementById("addresstip");
	if (document.reg.memberAddress.value == "") {
		addresstip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u5730\u5740\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!addresstest.test(document.reg.memberAddress.value)) {
			addresstip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u60a8\u7684\u6b63\u786e\u5730\u5740!";
			return false;
		} else {
			addresstip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    

	    //验证邮编
	var postcodetest = /^\d{6}$/;
	var postcodetip = document.getElementById("postcodetip");
	if (document.reg.memberPostcode.value == "") {
		postcodetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u90ae\u7f16\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!postcodetest.test(document.reg.memberPostcode.value)) {
			postcodetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u90ae\u7f16!";
			return false;
		} else {
			postcodetip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    

	    //验证联系电话
	var telephonetest = /^\d{11}|\d{3,4}-\d{7}$/;
	var telephonetip = document.getElementById("telephonetip");
	if (document.reg.memberTelephone.value == "") {
		telephonetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8054\u7cfb\u7535\u8bdd\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!telephonetest.test(document.reg.memberTelephone.value)) {
			telephonetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u8054\u7cfb\u7535\u8bdd\uff0c\u4ee5\u65b9\u4fbf\u4ee5\u540e\u8d2d\u7269!";
			return false;
		} else {
			telephonetip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    

	    //验证验证码
	var randtip = document.getElementById("randtip");
	if (document.reg.validateCode.value == "") {
		randtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u9a8c\u8bc1\u7801\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	}
	return true;
}

    

    //密码长度为6-16个字符
function checkpwd() {
	var pwdtip = document.getElementById("pwdtip");
	var cfpwdtip = document.getElementById("cfpwdtip");
	if (document.reg.memberPassword.value == "") {
		pwdtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (document.reg.memberPassword.value.length < 6 || document.reg.memberPassword.value.length > 16) {
			pwdtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u5bc6\u7801\u957f\u5ea6\u5e94\u4e3a6-16\u4e2a\u5b57\u7b26!";
		} else {
			pwdtip.innerHTML = "";
		}
	}
}
function checkcfpwd() {
	if (document.reg.memberPassword2.value == "" && document.reg.memberPassword2.value == "") {
		cfpwdtip.innerHTML = "";
	} else {
		if (document.reg.memberPassword.value != document.reg.memberPassword2.value) {
			cfpwdtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u4e24\u6b21\u5bc6\u7801\u4e0d\u4e00\u81f4!";
		} else {
			cfpwdtip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
}

    

    //验证邮箱
function checkemail() {
	var emailtest = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	var emailtip = document.getElementById("emailtip");
	if (document.reg.memberEmail.value == "") {
		emailtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u90ae\u7bb1\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!emailtest.test(document.reg.memberEmail.value)) {
			emailtip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u90ae\u7bb1\u683c\u5f0f\u4e0d\u6b63\u786e!";
		} else {
			emailtip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
}

    

    //验证姓名
function checktruename() {
	var truenametest = /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0]|[A-Z]|[a-z]){2,20}$/;
	var truenametip = document.getElementById("truenametip");
	if (document.reg.memberTrueName.value == "") {
		truenametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u59d3\u540d\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!truenametest.test(document.reg.memberTrueName.value)) {
			truenametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u59d3\u540d\u53ea\u80fd\u662f\u4e2d\u6587\u6216\u82f1\u6587!";
		} else {
			truenametip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
}

    

     //验证地区
function checkprovince() {
	var pro = document.reg.provinceCode;
	var protip = document.getElementById("protip");
	for (var m = 0; m < pro.options.length; m++) {
		if (pro.options[m].selected == true) {
			if (pro.options[m].value == "0") {
				protip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u586b\u5199\u60a8\u6240\u5728\u7684\u5730\u533a!";
			} else {
				protip.innerHTML = "&nbsp;<img src='images/true.gif'>";
			}
		}
	}
}

		

    //验证地址
function checkaddress() {
	var addresstest = /^([\u4E00-\u9Fa5]|[\uFe30-\uFFA0]|[A-Z]|[a-z]|[\d]){3,}$/;
	var addresstip = document.getElementById("addresstip");
	if (document.reg.memberAddress.value == "") {
		addresstip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u5730\u5740\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!addresstest.test(document.reg.memberAddress.value)) {
			addresstip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u60a8\u7684\u6b63\u786e\u5730\u5740!";
		} else {
			addresstip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
}

    

    //验证邮编
function checkpostcode() {
	var postcodetest = /^\d{6}$/;
	var postcodetip = document.getElementById("postcodetip");
	if (document.reg.memberPostcode.value == "") {
		postcodetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u90ae\u7f16\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!postcodetest.test(document.reg.memberPostcode.value)) {
			postcodetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u90ae\u7f16!";
		} else {
			postcodetip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
}

	

	//验证联系电话
function checktelephone() {
	var telephonetest = /^\d{11}|\d{3,4}-\d{7}$/;
	var telephonetip = document.getElementById("telephonetip");
	if (document.reg.memberTelephone.value == "") {
		telephonetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8054\u7cfb\u7535\u8bdd\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!telephonetest.test(document.reg.memberTelephone.value)) {
			telephonetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u8054\u7cfb\u7535\u8bdd\uff0c\u4ee5\u65b9\u4fbf\u4ee5\u540e\u8d2d\u7269!";
		} else {
			telephonetip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
}

	
	
	

	//刷新验证码
function reload() {
	document.getElementById("valid").src = document.getElementById("valid").src + "?nocache=" + new Date().getTime();
}

    

    //验证用户名是否可以使用
var xmlHttpreq=false;
function createxmlHttpRequest() {
	if (window.XMLHttpRequest) {
		xmlHttpreq = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			try {
				xmlHttpreq = new ActiveXObject("Msm12.XMLHttp");
			}
			catch (e) {
				try {
					xmlHttpreq = new ActiveXObject("Microsoft.XMLHttp");
				}
				catch (e) {
				}
			}
		}
	}
}


//处理服务器响应结果
function handleResponse() {

	//判断对象状态
	if (xmlHttpreq.readyState == 4) {

	    //信息已经返回成功，开始处理信息
		if (xmlHttpreq.status==200) {
			var res = xmlHttpreq.responseText;
			var nametip = document.getElementById("nametip");
			if(res == 'Y'){
				memberfalg=true;
				nametip.innerHTML = "&nbsp;<img src='images/true.gif'>";
			}else{
				nametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;该用户名已经存在！";
			}
			
		}
	}
}

//发送客户端的请求
function sendRequest(url) {
	createxmlHttpRequest();
	xmlHttpreq.open("post",url,true);
	//指定响应函数
	xmlHttpreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttpreq.onreadystatechange = handleResponse;

	//　设置请求头
	

	//发送请求
	xmlHttpreq.send(null);
}
function validusername(memberName) {
	var nametest = /^\w{3,16}$/;
	var nametip = document.getElementById("nametip");
	if (document.reg.memberName.value == "") {
		nametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u7528\u6237\u540d\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!nametest.test(document.reg.memberName.value)) {
			nametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u7528\u6237\u540d\u5e94\u75313-16\u4e2a\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210!";
		} else {
			sendRequest("ValidUsername?memberName="+memberName);
		}
	}
}

