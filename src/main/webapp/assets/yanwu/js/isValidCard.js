/**************
*
* Credit card checkbit verification
* returns : true or false
* author : Ken
* date : 03/03/03 10:43AM
*
**************/
function isValidCard(number)
{
	//TODO 
	return true;
	//TODO 
	/*total = 0;
	cardno = cno.substring(0,15);

	for(i=0;i<16;i++)
	{
		temp = cardno.substring(i,i+1) * 1;
		a = i % 2;
		if(a == "0")
		{
			b = temp * 2;
			if(b>9)
				b = b - 9;
			total = total + b;
		}else{
			total = total + temp;
		}
	}

	cnoCheckBit = 10 - (total % 10);
	if(cno.substring(15,16) == cnoCheckBit){
	    return true;
	}else{
	    return false;
	}*/
	var total = 0;
	var flag  = 0;
	var checkDigit=0;
	var originalNumber = number;
	var result = 0;
	if(number.length <13 || number.length > 19){
		return false;	
	}
	for (var i=(number.length - 1);i>=0; i--) {
		if (flag == 1) {
			var digits = number.charAt(i) * 2;
			if (digits > 9) digits -= 9;
			total += digits;
			flag = 0;
		} else {
			total = total + parseInt(number.charAt(i));
			flag = 1;
		}
	}
	if ((total%10) == 0) {
		result = number;
	} else {
		var iCheckDigit=Math.floor(number.charAt(number.length-1))-total%10;
		if (iCheckDigit<0){
		  iCheckDigit+=10
		}
		result = number.substring(0,(number.length - 1))+iCheckDigit;
	}
	//alert('original ' + originalNumber);
	//alert('result ' + result);
	if(result == originalNumber){
		//alert('true');
		return true;	
	}else{
		//alert('false');
		return false;	
	}
}
function isValidCard19(number)
{
	/*total = 0;
	cardno = cno.substring(0,15);

	for(i=0;i<19;i++)
	{
		temp = cardno.substring(i,i+1) * 1;
		a = i % 2;
		if(a == "0")
		{
			b = temp * 2;
			if(b>9)
				b = b - 9;
			total = total + b;
		}else{
			total = total + temp;
		}
	}

	cnoCheckBit = 10 - (total % 10);
	if(cno.substring(18,19) == cnoCheckBit){
	    return true;
	}else{
	    return false;
	}*/
	var total = 0;
	var flag  = 0;
	var checkDigit=0;
	var originalNumber = number;
	var result = 0;
	if(number.length <13 || number.length > 19){
		return false;	
	}
	for (var i=(number.length - 1);i>=0; i--) {
		if (flag == 1) {
			var digits = number.charAt(i) * 2;
			if (digits > 9) digits -= 9;
			total += digits;
			flag = 0;
		} else {
			total = total + parseInt(number.charAt(i));
			flag = 1;
		}
	}
	if ((total%10) == 0) {
		result = number;
	} else {
		var iCheckDigit=Math.floor(number.charAt(number.length-1))-total%10;
		if (iCheckDigit<0){
		  iCheckDigit+=10
		}
		result = number.substring(0,(number.length - 1))+iCheckDigit;
	}
	//alert('original ' + originalNumber);
	//alert('result ' + result);
	if(result == originalNumber){
		//alert('true');
		return true;	
	}else{
		//alert('false');
		return false;	
	}
}
