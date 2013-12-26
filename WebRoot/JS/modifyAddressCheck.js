
function modifyCheck() {

       



	    //验证姓名

	var truenametest = /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0]|[A-Z]|[a-z]){2,20}$/;
	var truenametip = document.getElementById("truenametip");
	if (document.ModifyAddress.memberTrueName.value == "") {
		truenametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u59d3\u540d\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!truenametest.test(document.ModifyAddress.memberTrueName.value)) {
			truenametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u59d3\u540d\u53ea\u80fd\u662f\u4e2d\u6587\u6216\u82f1\u6587!";
			return false;
		} else {
			truenametip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    



	    //验证地址
	var addresstest = /^([\u4E00-\u9Fa5]|[\uFe30-\uFFA0]|[A-Z]|[a-z]|[\d]){3,}$/;
	var addresstip = document.getElementById("addresstip");
	if (document.ModifyAddress.memberAddress.value == "") {
		addresstip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u5730\u5740\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!addresstest.test(document.ModifyAddress.memberAddress.value)) {
			addresstip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u60a8\u7684\u6b63\u786e\u5730\u5740!";
			return false;
		} else {
			addresstip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    

	    //验证邮编
	var postcodetest = /^\d{6}$/;
	var postcodetip = document.getElementById("postcodetip");
	if (document.ModifyAddress.memberPostcode.value == "") {
		postcodetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u90ae\u7f16\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!postcodetest.test(document.ModifyAddress.memberPostcode.value)) {
			postcodetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u90ae\u7f16!";
			return false;
		} else {
			postcodetip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}

	    

	    //验证联系电话
	var telephonetest = /^\d{11}|\d{3,4}-\d{7}$/;
	var telephonetip = document.getElementById("telephonetip");
	if (document.ModifyAddress.memberTelephone.value == "") {
		telephonetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8054\u7cfb\u7535\u8bdd\u4e0d\u80fd\u4e3a\u7a7a!";
		return false;
	} else {
		if (!telephonetest.test(document.ModifyAddress.memberTelephone.value)) {
			telephonetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u8054\u7cfb\u7535\u8bdd\uff0c\u4ee5\u65b9\u4fbf\u4ee5\u540e\u8d2d\u7269!";
			return false;
		} else {
			telephonetip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
	return true;
}

    

    

    //验证姓名
function checktruename() {
	var truenametest = /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0]|[A-Z]|[a-z]){2,20}$/;
	var truenametip = document.getElementById("truenametip");
	if (document.ModifyAddress.memberTrueName.value == "") {
		truenametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u59d3\u540d\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!truenametest.test(document.ModifyAddress.memberTrueName.value)) {
			truenametip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u59d3\u540d\u53ea\u80fd\u662f\u4e2d\u6587\u6216\u82f1\u6587!";
		} else {
			truenametip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
}

		

    //验证地址
function checkaddress() {
	var addresstest = /^([\u4E00-\u9Fa5]|[\uFe30-\uFFA0]|[A-Z]|[a-z]|[\d]){3,}$/;
	var addresstip = document.getElementById("addresstip");
	if (document.ModifyAddress.memberAddress.value == "") {
		addresstip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u5730\u5740\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!addresstest.test(document.ModifyAddress.memberAddress.value)) {
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
	if (document.ModifyAddress.memberPostcode.value == "") {
		postcodetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u90ae\u7f16\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!postcodetest.test(document.ModifyAddress.memberPostcode.value)) {
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
	if (document.ModifyAddress.memberTelephone.value == "") {
		telephonetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8054\u7cfb\u7535\u8bdd\u4e0d\u80fd\u4e3a\u7a7a!";
	} else {
		if (!telephonetest.test(document.ModifyAddress.memberTelephone.value)) {
			telephonetip.innerHTML = "&nbsp;<img src='images/false.gif'>&nbsp;\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u8054\u7cfb\u7535\u8bdd\uff0c\u4ee5\u65b9\u4fbf\u4ee5\u540e\u8d2d\u7269!";
		} else {
			telephonetip.innerHTML = "&nbsp;<img src='images/true.gif'>";
		}
	}
}

