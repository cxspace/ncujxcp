function trim(str){
	var re=/(^\s*)|(\s*$)/g
	str=str.replace(re,"");
	return str;
	}
function check_form(obj)
{
if(trim(obj.stringa.value).length<1)	
	{	
	alert('用户名不能为空！');
	obj.stringa.focus();
	return false;	
	}
if(trim(obj.stringn.value).length<1)	
	{	
	alert('密码不能为空！');
	obj.stringn.focus();
	return false;	
	}
if(trim(obj.code.value).length<2)	
	{	
	alert('验证码不能为空！');
	obj.code.focus();
	return false;	
	}
var stringa=obj.stringa.value;
var firstbit_stringa=stringa.substring(0,1);
if(firstbit_stringa=='a'){
	obj.editor_longb.value="-2";
	obj.where2go.value="/admin/facade.jsp";
}else if(firstbit_stringa=='t' || firstbit_stringa=='T'){
	obj.editor_longb.value="58";
	obj.where2go.value="/tcep/stute/index.html";
}else if(!isNaN(firstbit_stringa)){
	obj.editor_longb.value="52";
	obj.where2go.value="/tcep/stute/index.html";
}
obj.submit();
}