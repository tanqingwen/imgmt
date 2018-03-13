function IsIE(mb)
{var rc=false;if(navigator.userAgent.indexOf("MSIE")>-1){if(navigator.userAgent.indexOf("Opera")==-1){if(null!=mb){if(navigator.userAgent.indexOf(mb)>-1)rc=true;}else rc=true;
}}return rc;
}
function Trim(s){return RTrim(LTrim(s));}
function LTrim(s){
	try{
		do{
			if(null==s||s.length<=0)break;
			var whitespace=" \t\r\n";
			if(whitespace.indexOf(s.charAt(0))>=0){
				var len=s.length;
				var index;
				for(index=0;index<len;++index){
					if(whitespace.indexOf(s.charAt(index))<0)
						break;
				}
				if(index<len)
					s=s.substring(index);
				else
					s="";
			}
		}while(false);
	
	}catch(Cb){
	s="";
	}return s;
}
function RTrim(s){try{do{if(null==s||s.length<=0)break;var len=s.length;var whitespace=" \t\r\n";if(whitespace.indexOf(s.charAt(len-1))>=0){var index;for(index=len-1;index>=0;--index){if(whitespace.indexOf(s.charAt(index))==-1)break;}if(index>=0)s=s.substring(0,index+1);else s="";
}}while(false);
}catch(Db){s="";
}return s;
}

function javaTrim(string)
{
	var length1, i, j;
	var string1 = "";

	length1 = string.length;
	
	for (i = 0 ; i < length1 ; i++)
	{  
		if(string.charAt(i) != " ")
		{
			for (j = i ; j < length1 ; j++)
				string1 = string1 + string.charAt(j);
				break;
		}
	}
	length1 = string1.length;
	string = string1;
	
	string1 = "";
	for (i = length1 - 1 ; i >= 0 ; i--)
	{ 
		if(string.charAt(i) != " ")
		{
			for (j = 0 ; j <= i ; j++)
				string1 = string1 + string.charAt(j);
				break;
		}
	}
	string = string1;
	
	return(string)
	
}


function isEmail(string)

{
	var string1="";
	var len=0;


	string1=javaTrim(string.value);
	len=string1.length;
	
	if(string1.length!=0)
	{
		if (string1.indexOf("@",1)==-1||string1.indexOf(".",1)==-1||string1.length<7)
		{
			return false;
		}

		if (string1.charAt(len-1)=="."||string1.charAt(len-1)=="@")
		{
			tryToFocus(string);
			return false;
		}
	}
	return true;
}



function isLeapYear(year)
{
	if(year%4==0 && year%100!=0 || year % 400 == 0) return true;
	return false;
}


function undoDate(strDate)
   {
   	var strDateFormat=var_dateFormat
   	var strTmp="";
	var strYear="";
	var strMonth="";
	var strDay="";

	while (""!=strDate)
	{
	   	strTmp=strDateFormat.substring(0,1);
   		if (strTmp=="y")
   		{
   			strYear=strDate.substring(0,4);
   			strDate=strDate.substring(4);
   			strDateFormat=strDateFormat.substring(4);
   		}
   		if (strTmp=="M")
   		{
   			strMonth=strDate.substring(0,2);
   			strDate=strDate.substring(2);
   			strDateFormat=strDateFormat.substring(2);
   		}
   		if (strTmp=="d")
   		{
   			strDay=strDate.substring(0,2);
   			strDate=strDate.substring(2);
   			strDateFormat=strDateFormat.substring(2);
   		}
   	}

   	return strYear+strMonth+strDay;
   }



function isDate(obj)
{
	if (obj.value=="") return true;

	if (obj.value.length!=8)
	{
		alert (var_isDate);
		tryToFocus(obj);
		return false;
	}
	var strTmp=undoDate(obj.value);
	if (isValidDate(strTmp.substring(0,4),strTmp.substring(4,6),strTmp.substring(6,8)))
	{
		return true;
	}
	else
	{
	tryToFocus(obj);
	return false;
	}
}

function isValidUndoDate(obj)
{
	if (obj.value=="") return true;

	if (obj.value.length!=8)
	{
		alert (var_isDate);
		tryToFocus(obj);
		return false;
	}
	var strTmp=obj.value;
	if (isValidDate(strTmp.substring(0,4),strTmp.substring(4,6),strTmp.substring(6,8)))
	{
		return true;
	}
	else
	{
	tryToFocus(obj);
	return false;
	}
}
function notValidateDate(text){
  if(isDate(text)) return false;
  return true;
}

function beforeDate(obj,beforeDate)
{
	if (javaTrim(obj.value)=="") return true;
	if (isDate(obj))
	{
		if (undoDate(obj.value)<undoDate(beforeDate))
		{
			return true;
		}
		else
		{
		alert (var_beforeDate)
		tryToFocus(obj);
		return false;
		}

	}

}
function afterDate(obj,beforeDate)
{
	if (javaTrim(obj.value)=="") return true;
	if (isDate(obj))
	{
		if (undoDate(obj.value)>=undoDate(beforeDate))
		{
			return true;
		}
		else
		{
		alert (var_afterDate)
		tryToFocus(obj);
		return false;
		}

	}

}

function largerDate(text1, text2, textName1,textName2)
{
	var strTmp1=undoDate(text1.value);
	var strTmp2=undoDate(text2.value);

	i = compareDates(strTmp1.substring(0,4),strTmp1.substring(4,6),strTmp1.substring(6,8),strTmp2.substring(0,4),strTmp2.substring(4,6),strTmp2.substring(6,8));
	if( i > 0){
		alert (textName1 + " "+var_largerDate1+" "  + textName2 /*+ var_largerDate2 */) ;
		text1.select();
		return true;
	}
	return false;
}



function isValidDate( year, month, day )
{
   if( (year != "" && isNaN(year)) || isNaN(month) || isNaN(day))
   {
		alert(var_date)
		return false
   }
   if(year != "" && ((year.length!=4) || (year.substring(0,1)<1) || year.indexOf(".") != -1))
   {
		alert(var_year)
		return false
   }


   if(month.indexOf(".") != -1)
   {
		   	alert(var_monthexp)
			return false
	}

	if(day.indexOf(".") != -1)
	{
		   	alert(var_dayexp)
			return false
	}
   if(year != "")
    	year  = Math.floor(year,10);
   month = Math.floor(month,10);
   day   = Math.floor(day,10);

	if((month<1) || (month>12)){
		   	alert(var_monthbetween)
			return false
	}
   if (( month==4) || (month==6) || (month==9) || (month==11) )
   { if (( day < 1) || (day > 30) )
     { alert( var_day30 );
       return false;
     }
   }
   else
   { if ( month!=2 )
     { if ( (day < 1) || (day > 31 ))
       {  alert( var_day31 );
          return false;
       }
     }
     else
     {
       if(year != "") {
        	// month == 2
       		if ( ( year % 100 ) != 0 && (year % 4 == 0) || ( year % 100 ) == 0 && ( year % 400) == 0 )
       		{ if ( day > 29 )
         		{  alert( var_day29 );
            		   return false;
                        }
                }
                else
                { if ( day > 28 )
                  { alert( var_day28 );
                    return false;
                  }
                }
       }
       else {
       		if(day > 29) {
       			alert( var_day29 );
            		return false;
       		}
       }
     }
   }
 return (true);
}


function isMoney(string)
{
	var length1 , i , j, k, flag = 0;
	var string1="";

	string1 = javaTrim(string);
	k = length1 = string1.length;

	if ((string1 == "0.00") || (string1 == "0.0") || (string1 == "0.") || (string1 == "0"))
	{
    alert(var_amount);
		return (false);
  }
	if (length1 == 0)
	{
		alert( var_errnul);
		return(false);
	}
	if (string1.charAt(0)=="0" )
	{
		if (length1 == 1)
		{
	        	alert(var_amount);
	        	return(false);
	  }
	  else
	  {
	  	if (!(string1.charAt(1)=="."))
	  	{
				alert(var_amountfirstdig);
				return(false);
			}
		}
	}
	j=0;
	for (i = 0 ; i < length1 ; i++) {  //�ж�ÿλ����
		if(isNaN(Math.floor(string1.charAt(i),10)))
		{
			if(string1.charAt(i) != ".")
			{
				alert( var_inputnumber);
				return(false);
			}
			else  {
				j++;
				if(length1 - i > 3 )
				{
					alert(var_2digexp);
					return(false);
				}
			}
			if (flag == 0) {
				k = i;	flag = 1;
			}

		}
	}

	if (k > 12) {
		alert(var_amountexclmt);
		return false;
	}

	if(j > 1) {
		alert( var_oneexp);
		return false;
	}

	return true;
}

function isInt(noObj,maxValue)
{
	if (noObj.value=="")
	{
		return true;
	}

/************************************************
	if (isNaN(noObj.value) || (noObj.value.indexOf("-")>-1))
	{
		alert (var_overzeroless + maxValue + var_integer);
		tryToFocus(noObj);
		return false;
	}
	
	*****************************************/
	
	if (isNaN(noObj.value) || (noObj.value.indexOf(".")>-1))
	{
		alert (var_inputlessthan + maxValue + var_integer);
		tryToFocus(noObj);
		return false;
	}
	
	strValue=noObj.value;
	for (i=0;i<strValue.length;i++)
	{
		if (strValue.charCodeAt(i,1)!=46 && (strValue.charCodeAt(i,1)<48 || strValue.charCodeAt(i,1)>57))
		{
			alert (var_inputlessthan + maxValue + var_integer);
			tryToFocus(noObj);
			return false;
		}
	}

		if (Math.floor(noObj.value)<Math.floor(maxValue))
		{
			return true;
		}
		else
		{
		alert (var_inputlessthan+ maxValue + "��");
		tryToFocus(noObj);
		return false;
		}

}

/**
 * Checks if the given object containing a bigger-than-0 integer.
 */
function isBiggerThanZeroInt(noObj) {
	boolReturn = false;
	if(isInteger(noObj)) {
		if(noObj.value == 0) {
			alert(var_numberzero);
			noObj.focus();
			noObj.select();
		}
		else
			boolReturn = true;
	}
	return boolReturn;
}
/**
 * Checks if the given object containing a bigger-than-0.
 */
function isBiggerThanZero(noObj) {
	boolReturn = false;
		if(noObj.value <= 0) {
			alert(var_numberzero);
			noObj.focus();
			noObj.select();
		}
		else
			boolReturn = true;
	return boolReturn;
}

function isInteger(noObj)
{
	if (noObj.value=="")
	{
		return true;
	}

	if (isNaN(noObj.value) || (noObj.value.indexOf("-")>-1))
	{
		alert (var_overzero);
		tryToFocus(noObj);
		return false;
	}
	if (isNaN(noObj.value) || (noObj.value.indexOf(".")>-1))
	{
		alert (var_overzero);
		tryToFocus(noObj);
		return false;
	}
	strValue=noObj.value;
	for (i=0;i<strValue.length;i++)
	{
		if (strValue.charCodeAt(i,1)!=46 && (strValue.charCodeAt(i,1)<48 || strValue.charCodeAt(i,1)>57))
		{
			alert (var_overzero);
			tryToFocus(noObj);
			return false;
		}
	}


	return true;
}



function isFloat(noObj,maxValue,decimalNo)
{
	return isFloatVl(noObj,maxValue,decimalNo,0);
}

function isFloatEq(noObj,maxValue,decimalNo)
{
	return isFloatVl(noObj,maxValue,decimalNo,1);
}


function isMinusFloat(noObj,maxValue,decimalNo)
{
	if (noObj.value=="")
	{
		return true;
	}

	if (isNaN(noObj.value))
	{
		alert (var_number);
		tryToFocus(noObj);
		return false;
	}
	strValue=noObj.value;
	for (i=0;i<strValue.length;i++)
	{
		if(i==0&&strValue.charCodeAt(0,1)==45){
		}
		else{
		if (strValue.charCodeAt(i,1)!=46 && (strValue.charCodeAt(i,1)<48 || strValue.charCodeAt(i,1)>57))
		{
			alert (var_number);
			tryToFocus(noObj);
			return false;
		}
		}

	}
	
		if (Math.floor(noObj.value)>=maxValue)
		{
			alert (var_numberlessthan+ maxValue + "!");
			tryToFocus(noObj);
			return false;
		}
	
		if ((Math.ceil(noObj.value)>maxValue))
		{
			alert (var_numberlessthan+ maxValue + "!");
			tryToFocus(noObj);
			return false;
		}

	if(noObj.value.indexOf(".")!=-1){
		if((noObj.value.length-noObj.value.indexOf(".")-1)>decimalNo)
		{
			alert(var_inputonly+decimalNo+var_digitexp);
			tryToFocus(noObj);
			return false;
		}
	}
		return true;
}


function isFloatVl(noObj,maxValue,decimalNo,isEq)
{
	if (noObj.value=="")
	{
		return true;
	}

	if (isNaN(noObj.value) || (noObj.value.indexOf("-")>-1))
	{
		alert (var_number);
		tryToFocus(noObj);
		return false;
	}

	strValue=noObj.value;
	for (i=0;i<strValue.length-1;i++)
	{
		if (strValue.charCodeAt(i,1)!=46 && (strValue.charCodeAt(i,1)<48 || strValue.charCodeAt(i,1)>57))
		{
			alert (var_number);
			tryToFocus(noObj);
			return false;
		}
	}
	if(isEq==0)
	{

		if (Math.floor(noObj.value)>=maxValue)
		{
			alert (var_numberlessthan+ maxValue + " ��");
			tryToFocus(noObj);
			return false;
		}
	}else{
		if ((Math.ceil(noObj.value)>maxValue))
		{
			alert (var_numberlessthan+ maxValue + " ��");
			tryToFocus(noObj);
			return false;
		}
	}

	if(noObj.value.indexOf(".")!=-1){
		if((noObj.value.length-noObj.value.indexOf(".")-1)>decimalNo)
		{
			alert(var_inputonly+decimalNo+var_digitexp);
			tryToFocus(noObj);
			return false;
		}
	}

		return true;
}




function clearSpaceKey(){
	if((event.keyCode == "32")){
		event.returnValue=false
		alert(var_space)
	}
}

function onlyNumPoint(){
	if(!((event.keyCode >"47" )&& (event.keyCode < "58") || (event.keyCode == "46")) && event.keyCode!=13){
		event.returnValue=false
		alert(var_expdot)
	}
}


function onlyNum(){
	if(!((event.keyCode >"47" )&& (event.keyCode < "58")) && event.keyCode!=13){
		event.returnValue = false
		alert(var_numonly)
	}
}

function filterDoubleMarksSpace(){
	if(event.keyCode == "34"){
		event.returnValue = false
		alert(var_doub)
	}
}

function isChecked(objCheckbox)
	{
		isCheck=false;
		if (! objCheckbox)
		{
			alert (var_norecord)
			return false
		}
		if (objCheckbox.length>1)
		{

			for (i=0;i<objCheckbox.length;i++)
			{
				if (objCheckbox[i].checked == true)
				{
					isCheck=true;
				}
			}
		}
		else
		{
			if (objCheckbox.checked == true)
			{
				isCheck=true;
			}
		}
		if (isCheck==false)
		{
			alert (var_selrecord);
			return false;
		}
		else
		{
			return true;
		}
}
function isCheckedSelectNo(objCheckbox)
	{
		SelectNo="";
		if (! objCheckbox)
		{
			alert (var_norecord)
			return ""
		}
		if (objCheckbox.length>1)
		{

			for (i=0;i<objCheckbox.length;i++)
			{
				if (objCheckbox[i].checked == true)
				{
					SelectNo=objCheckbox[i].value;
				}
			}
		}
		else
		{
			if (objCheckbox.checked == true)
			{
				SelectNo=objCheckbox.value;
			}
		}
		if (SelectNo=="")
		{
			alert (var_selrecord);
			return "";
		}
		else
		{
			return SelectNo;
		}
}


function isValidatePasswd(passwd,passwd2)
{
	if (passwd.value.length < 4) {
		alert(var_passlen4);
		tryToFocus(passwd);
		return true;
	}

	if (passwd.value.length > 10) {
		alert(var_passlen10);
		tryToFocus(passwd);
		return true;
	}

	if (passwd.value != passwd2.value){
	    alert(var_password);
		passwd.value="";
		passwd.value="";
		tryToFocus(passwd);
		return true;
	}
	return false;
}


function isValidateNewPasswd(passwd,passwd2,varMin,varMax)
{
	if (passwd.value.length < varMin) {
		alert(var_passlen+varMin+"-"+varMax);
		tryToFocus(passwd);
		return true;
	}

	if (passwd.value.length > varMax) {
		alert(var_passlen+varMin+"-"+varMax);
		tryToFocus(passwd);
		return true;
	}

	if (passwd.value != passwd2.value){
	    alert(var_password);
		passwd.value="";
		passwd2.value="";
		tryToFocus(passwd);
		return true;
	}
	return false;
}

function isPassword(passwd)
{
	if (passwd.value.length < 4) {
		alert(var_passlen4);
		tryToFocus(passwd);
		return true;
	}

	if (passwd.value.length > 10) {
		alert(var_passlen10);
		tryToFocus(passwd);
		return true;
	}

	return true;
}


function compareDates(yy1, mm1, dd1, yy2, mm2, dd2)
{
	if(yy1 > yy2) {	return 1 }
	else if(yy1 < yy2) { return -1 }
	else if(yy1 == yy2){
	    if(mm1 > mm2) { return 1 }
	    else if(mm1 < mm2) { return -1}
	    else if(mm1 == mm2) {
	    	if(dd1 > dd2) {return 1}
	    	else if(dd1 < dd2) {return -1}
	    	else if(dd1 == dd2) { return 0 }
	    }
	}
}

function fGetDaysInMonth(iMonth, iYear) {
  if(iMonth==1|iMonth==3|iMonth==5|iMonth==7|iMonth==8|iMonth==10|iMonth==12)
     {   return 31;}
  if(iMonth==4|iMonth==6|iMonth==9|iMonth==11)
     {  return 30; }
	 var frun,frun1,frun2;
	frun=Math.floor(iYear/4) * 4;
	frun1=Math.floor(iYear/100)*100
	frun2=Math.floor(iYear/400)*400
    if(frun1==iYear)
	{
	   if(frun2==iYear)     return 29;
       else     return 28;
        }
	else
	{
       if(frun==iYear)   {return 29;}
       else  {return 28;}
	 }
}



function strLength(str)
{
	var l=str.length;
	var n=l
	for (var i=0;i<l;i++)
	{
		if (str.charCodeAt(i)<0||str.charCodeAt(i)>255) n++;
	}
	return n;
}


function checkLen(textObj,size)
{
	if (strLength(textObj.value)>size)
	{
		alert (var_inputmax+size+var_chars)
		tryToFocus(textObj)
		return true;
	}
	return false;
}



function isNull(textObj)
{

	if (javaTrim(textObj.value)=="")
	{
		tryToFocus(textObj);
		alert (var_isnull)
		return true;
	}
	return false;
}

function isNullList(textObj)
{
	if (javaTrim(textObj.value)=="")
	{
		tryToFocus(textObj);
		alert (textObj.name + var_isnulllist)
		return true;
	}
	return false;
}


function confirmAdd()
{
	if (confirm(var_confirmadd))
	{
		return true;
	}
}


function confirmPrint()
{
	if (confirm(var_confirmprint))
	{
		return true;
	}
}

function confirmSub()
{
	if (confirm(var_confirmsubmit))
	{
		return true;
	}
}




function confirmDel()
{
	if (confirm(var_confirmdel))
	{
		return true;
	}
}


function confirmUpdate()
{
	if (confirm(var_confirmupdate))
	{
		return true;
	}
}

function confirmCopy()
{
	if (confirm(var_confirmcopy))
	{
		return true;
	}
}


function confirmNext()
{
	return true;
}

function confirmPrev()
{
	return true;
}
function confirmNextYear()
{
	if (confirm(var_confirmnextyear))
	{
		return true;
	}
}

function confirmPrevYear()
{
	if (confirm(var_confirmprevyear))
	{
		return true;
	}
}





function isCheckedTwoKey(objCheckbox,objHid1,objHid2,objField1,ObjField2)
	{
		isCheck=false;
		if (! objCheckbox)
		{
			alert (var_norecord)
			return false
		}
		if (objCheckbox.length>1)
		{

			for (i=0;i<objCheckbox.length;i++)
			{
				if (objCheckbox[i].checked == true)
				{
					objField1.value=objHid1[i].value
					ObjField2.value=objHid2[i].value
					isCheck=true;
				}
			}
		}
		else
		{
			if (objCheckbox.checked == true)
			{
				objField1.value=objHid1.value
				ObjField2.value=objHid2.value
				isCheck=true;
			}
		}
		if (isCheck==false)
		{
			alert (var_selrecord);
			return false;
		}
			return true;
}

function isStartEndDate(ObjStartD,ObjEndD)
	{
		if(ObjStartD.value==""||ObjEndD.value=="") return true;
		if(ObjStartD.value<=ObjEndD.value) return true;
		else {
			alert(var_startenddate);
			return false;
		}
	}

function julianDay(intYear,intMonth,intDay,intYearSize)
{
	intDay=intDay;
	for (i=1;i<intMonth;i++)
	{
		intDay=intDay+fGetDaysInMonth(i,intYear);
	}
	if (intYearSize==0) return intDay;
	strDay=(intYear+"").substring(4-intYearSize,4)
	if ((intDay+"").length==2) return strDay+"0"+intDay;
	if ((intDay+"").length==1) return strDay+"00"+intDay;
	return strDay+intDay;
}
	function tryToFocus(obj)
	{
		if(obj.type!="hidden" && !obj.disabled)
		{
			obj.focus();
		}
		else
		{
			var tmpFouceName=obj.name+"1";
			tmpFouceName="(form1."+tmpFouceName+")";
			if (eval(tmpFouceName))
			{
				tmpFouceName="form1."+obj.name+"1"+".focus()";
				eval(tmpFouceName);
			}

		}
		if(obj.type=="textarea" || obj.type=="text" &&!obj.disabled) obj.select();

	}
	function isOldThan18(birthday,today)
	{
		var dob =parseInt(birthday);
		var tod= parseInt(today);
		if((dob+180000)<tod) return true;
		return false;
	}

function isJulianDate(intDate) {
	sDate = intDate.value;
	if(sDate.length > 3)
		sDate = sDate.substring(sDate.length-3);
	if(sDate > 365 || sDate < 1) {
		alert(var_juliandate);
		intDate.focus();
		intDate.select();
		return false;
	}
	else
		return true;
}

/**
 * Determines whether or not the selected Julian Date is
 * greater than today's Julian Date.
 * Returns true if it is, false otherwise.
 */
function isGreaterJulianDate(dateToday, dateSelected) {
	if(dateSelected.value < dateToday.value) {
		alert(var_greaterjuliandate);
		dateSelected.focus();
		dateSelected.select();
		return false;
	}
	else
		return true;
}

/*
* add by liaokai check name 2003-07-02
*
*/
  function checkName(inputName)
  {
  var strName=inputName.value;
  var r = new RegExp("[A-Z]", "gi");
  var strFlag;
  var strTemp="";
  strFlag= strName.match(r);
  if (strFlag!=null) strTemp=strTemp+strFlag;

  var r = new RegExp("[0-9]", "gi");
  strFlag= strName.match(r);
  if (strFlag!=null) strTemp=strTemp+strFlag;

  var r = new RegExp("[% \(\)$?/^]", "gi");
  strFlag= strName.match(r);
  if (strFlag!=null) strTemp=strTemp+strFlag;

  var r = new RegExp("[,]", "gi");
  strTemp=strTemp.replace(r,"");
  if (strTemp.length!=strName.length)
  {
  	alert (var_checkName);
  	inputName.focus();
  	inputName.select();
  	return false;
  }
  return true;
 }
 
 /*
* add by hualei checkBankAccno on 20030917
*/

 function checkBankAccno(inputName)
  {
  var strName=inputName.value;
  var strFlag;
  var strTemp="";

  var r = new RegExp("[0-9]", "gi");
  strFlag= strName.match(r);
  if (strFlag!=null) strTemp=strTemp+strFlag;

  var r = new RegExp("[ ]", "gi");
  strFlag= strName.match(r);
  if (strFlag!=null) strTemp=strTemp+strFlag;

  var r = new RegExp("[,]", "gi");
  strTemp=strTemp.replace(r,"");
  if (strTemp.length!=strName.length)
  {
   //alert("<%=MsgMgr.getContent(language,"CCPM0112.CHECKBANKACC")%>");
   alert (var_checkBankAccno);
  	inputName.focus();
  	inputName.select();
  	return false;
  }
  return true;
 }

/*
 *  add by frx check whether the string contain the character "'"
 */
 
function checkIllegalString (inputString){
	var tmpString = "";
	var stringLen;
	tmpString = javaTrim(inputString.value);
	stringLen = tmpString.length;
	if(stringLen != 0){
		if(tmpString.indexOf("'",0)!=-1){
			alert(var_checkIllegalString);
			tryToFocus(inputString);
			return false;
		}
		return true;		
	}
	return true;
} 
function largerDateA(text1, text2, textName1,textName2)
{
	//var strTmp1=undoDate(text1.value);
	//var strTmp2=undoDate(text2.value);
	var strTmp1=text1.value;
	var strTmp2=text2.value;

	i = compareDates(strTmp1.substring(0,4),strTmp1.substring(4,6),strTmp1.substring(6,8),strTmp2.substring(0,4),strTmp2.substring(4,6),strTmp2.substring(6,8));
	if( i > 0){
		alert (textName1 + " "+var_largerDate3+" "  + textName2 /*+ var_largerDate2 */) ;
		text1.select();
		return true;
	}
	return false;
}

function   checkNum(e){     
//  re=/^(([1-9]\d*\.\d*)|(0\.\d*)|([1-9]\d*))$/;
  var re=/^\d{1,8}$|^\d{1,8}\.\d{1,3}$/;	
  if(!re.test(e))   
  {   
  return false ;
  }  
  return true ;
} 
function  checkId(idobj){
	var re=/^[A-Za-z0-9]*$/;  
	if(!re.test(idobj.value)){
		alert(var_Id);
		idobj.select();
		return true;
	}
	return false;
}

function getNowDate(){
	var now= new Date();
	var month=(now.getMonth()+1).toString(),date=now.getDate().toString();
	month=month.length==1?"0"+month:month;
	date=date.length==1?"0"+date:date;
	var today=""+now.getFullYear()+month+date;
	return today;
}


function loadApplet(serverurl,returl,backurl) {
    var URL = serverurl+"/plugins/jre-6u21-windows-i586.exe";
    document.write('<OBJECT id="PrintApplet" name="PrintApplet"');
    document.write('classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" WIDTH="0" HEIGHT="0" MAYSCRIPT name="PrintApplet"');
    document.write('codebase='+ URL +'>');
    document.write('<PARAM NAME="CODE" VALUE="util.JRPrinterApplet.class" />');
    document.write('<PARAM NAME="CODEBASE" VALUE="'+serverurl+'/util/" />');
    document.write('<PARAM NAME="ARCHIVE" VALUE="jprint.jar,jasperreports-1.2.3.jar,RXTXcomm.jar" />');
    document.write('<PARAM NAME="type" VALUE="application/x-java-applet;version=1.6" />');
    document.write('<PARAM NAME="scriptable" VALUE="false" />');
    document.write('<PARAM NAME="REPORT_URL" VALUE="'+returl+'" />');
    document.write('<PARAM NAME="BACK_URL" VALUE="'+backurl+'" />');
    document.write('no support java');
    document.write('<comment>');
    document.write('<embed type="application/x-java-applet;version=1.6"');
    document.write('CODE="util.JRPrinterApplet.class"');
    document.write('JAVA_CODEBASE="'+serverurl+'/util/" ARCHIVE="jprint.jar,jasperreports-1.2.3.jar,RXTXcomm.jar"');
    document.write('scriptable=false');
    document.write('pluginspage='+ URL +'>');
    document.write('<noembed></noembed>');
    document.write('</embed>');
    document.write('</comment>');
    document.write('</OBJECT>');
}

//给IE8浏览器下 添加数组的indexOf方法
if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
    var len = this.length >>> 0;
    var from = Number(arguments[1]) || 0;
    from = (from < 0)
         ? Math.ceil(from)
         : Math.floor(from);
    if (from < 0)
      from += len;
    for (; from < len; from++)
    {
      if (from in this &&
          this[from] === elt)
        return from;
    }
    return -1;
  };
}

//检查服务器金额与数据库金额差额
function checkServerUpAmout(upAmount,serverAmount){
	var caseAmt=5;
	if(upAmount-serverAmount>=caseAmt){
		alert("服务器余额与上送余额不符  服务器余额:"+serverAmount+"上送余额:"+upAmount);
	}
	if(serverAmount-upAmount>=caseAmt){
		alert("服务器余额与上送余额不符  服务器余额:"+serverAmount+"上送余额:"+upAmount);
	}
	
}