//校验邮箱格式
function email(str){
	 var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	 if(reg.test(str)){
		 return true;
	 }else{
		 return false;
	 }
}

//身份证号码
function idno(idno){
	if(!idno || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(idno)){
	   return false;
	}
}

