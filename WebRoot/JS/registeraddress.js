/*****************      ���ﳵ   地址级联 ↓   *****************/
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
/*------------------------------------ 刷新城市 -------------------------------------->*/   	
    	function handCityAjax2(){
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
    				var p_select=document.reg.province;  
    				
    				var c_select=document.reg.city;  				
    				for(j=0;j<p_select.length;j++){
    					if(document.reg.province.selectedIndex==j){
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
    				if(document.reg.city.selectedIndex==0){
    					document.reg.area.length=1;
    					document.reg.area.selectedIndex=0;
    					document.reg.area.options[0].text="请选择";
    					document.reg.area.options[0].value="0";
    				}
    			}
    		}
    	}
    	
    	function sendCityAjax2(){
    		var provinceCode=document.reg.province.options[document.reg.province.selectedIndex].value;
    		var url="SelectCityServlet";
    		var provinceCode="provinceCode="+provinceCode;
    		createXMLHttpRequest();
    		//alert('1');
    		xmlhttpreq.open("post",url,true);
    		//alert('2');
    		xmlhttpreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    		//alert('3');
    		xmlhttpreq.onreadystatechange=handCityAjax2;
    		xmlhttpreq.send(provinceCode);
    	}
<!------------------------------------ 刷新地区 -------------------------------------->   
		function handAreaAjax2(){
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
					var a_select=document.reg.area;
					var c_select=document.reg.city;
					for(j=0;j<c_select.length;j++){
						if(document.reg.city.selectedIndex==j){
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
    	function sendAreaAjax2(){
    		var cityCode=document.reg.city.options[document.reg.city.selectedIndex].value;
    		//alert(provint_id);
    		var url="SelectAreaServlet?cityCode="+cityCode;
    		createXMLHttpRequest();
    		xmlhttpreq.open("post",url,true);
    		xmlhttpreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    		xmlhttpreq.onreadystatechange=handAreaAjax2;
    		xmlhttpreq.send(null);
    	}
/*****************      ���ﳵ   地址级联  ↑    *****************/