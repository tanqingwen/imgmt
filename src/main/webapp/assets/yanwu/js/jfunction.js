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
			alert(var_isEmail);
			tryToFocus(string);
			return false;
		}

		if (string1.charAt(len-1)=="."||string1.charAt(len-1)=="@")
		{
			alert(var_isEmail);
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
			alert("is later date");	
			return true;
		}
		else
		{
			alert("is not later date");	
		alert (var_afterDate)
		tryToFocus(obj);
		return false;
		}

	}

}

function largerDate(text1, text2, textName1,textName2)
{
	//var strTmp1=undoDate(text1.value);
	//var strTmp2=undoDate(text2.value);
	var strTmp1=text1.value;
	var strTmp2=text2.value;

	i = compareDates(strTmp1.substring(0,4),strTmp1.substring(4,6),strTmp1.substring(6,8),strTmp2.substring(0,4),strTmp2.substring(4,6),strTmp2.substring(6,8));
	if( i > 0){
		alert (textName1 + " "+var_largerDate1+" "  + textName2 /*+ var_largerDate2 */) ;
		text1.select();
		return true;
	}
	return false;
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
	for (i = 0 ; i < length1 ; i++) {
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
		alert (var_inputlessthan+ maxValue + "!");
		tryToFocus(noObj);
		return false;
		}
}
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
	for (i=0;i<strValue.length;i++)
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
			alert (var_numberlessthan+ maxValue + "!");
			tryToFocus(noObj);
			return false;
		}
	}else{
		if ((Math.ceil(noObj.value)>maxValue))
		{
			alert (var_numberlessthan+ maxValue + "!");
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
function isValidatePasswd(passwd,passwd2)
{
	if (passwd.value.length < 4) {
		alert(var_passlen4);
		tryToFocus(passwd);
		return true;
	}

	if (passwd.value.length > 8) {
		alert(var_passlen8);
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
function isValidateNewPasswd(passwd,passwd2,varMin,varMax)
{
	if (passwd.value.length < varMin) {
		alert(var_passlen);
		tryToFocus(passwd);
		return true;
	}

	if (passwd.value.length > varMax) {
		alert(var_passlen);
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
	var l=javaTrim(str).length;
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
	if (textObj.value==""||javaTrim(textObj.value)=="")
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
	return false;
}


function confirmPrint()
{
	if (confirm(var_confirmprint))
	{
		return true;
	}
	return false;
}

function confirmSub()
{
	if (confirm(var_confirmsubmit))
	{
		return true;
	}
	return false;
}
function confirmUpdate()
{
	if (confirm(var_confirmupdate))
	{
		return true;
	}
	return false;
}
function confirmDel()
{
	if (confirm(var_confirmdel))
	{
		return true;
	}
	return false;
}
function confirmUpdate()
{
	if (confirm(var_confirmupdate))
	{
		return true;
	}
	return false;
}
function confirmCopy()
{
	if (confirm(var_confirmcopy))
	{
		return true;
	}
	return false;
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
	return false;
}

function confirmPrevYear()
{
	if (confirm(var_confirmprevyear))
	{
		return true;
	}
	return false;
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

	//	if(obj.type!="hidden") obj.className='notNull';
	}
	function isOldThan18(birthday,today)
	{
		var dob =parseInt(birthday);
		var tod= parseInt(today);
		if((dob+180000)<tod) return true;
		return false;
	}

/**
 * Determines whether or not the given date is a correct Julian Date.
 * The last three digits of Julian Date should be within 1-365.
 * True is returned if it's, false otherwise.
 */
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
* add by liaokai confirm authorize 2003-07-02
*
*/
 
function confirmAuth()
{
	if (confirm(var_confirmAuth))
	{
		return true;
	}
}


function jsSaveDate(strDate)
   {
	if (strDate==null) return null;
	if (strDate.length!=8) return strDate;
		
	var strDateFormat=var_dateFormat;
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
  
   function isIDnum(objIdnum){
        idNumValue=(javaTrim(objIdnum.value)).toLowerCase();
        patten=/^[a-z][12][0-9]{8}$/;
        if(patten.test(idNumValue)){
           h="abcdefghjklmnpqrstuvxywzio";
           x=10+h.indexOf(idNumValue.substring(0,1));
           chksum=(x-(x%10))/10+(x%10)*9;
           for(i=1;i<9;i++){
              chksum+=idNumValue.substring(i,i+1)*(9-i);
           } 
           chksum=(10-chksum%10)%10;
           
           if(chksum==idNumValue.substring(9,10)) return true;
        }
        else return false;
   }
   function taxidchk(data){
	var li_v1, li_v2, li_v3, li_v4, li_v5, li_v6, li_v7, li_v8;
	var ls_v1,ls_v2, ls_v3, ls_v4, ls_v5, ls_v6, ls_v7, ls_v8;
	lb_ret1 = new Boolean(false);
	lb_ret2 = new Boolean(false);
	lb_retval = new Boolean(false);
	
	
	if ( data.length != 8 ){
		return false;
	}else{
		ls_v1=parseInt(data.substr(0,1))*1;
		ls_v1= '00' + ls_v1;
		ls_v2=parseInt(data.substr(1,1))*2;
		ls_v2= '00' + ls_v2;
		ls_v3=parseInt(data.substr(2,1))*1;
		ls_v3= '00' + ls_v3;
		ls_v4=parseInt(data.substr(3,1))*2;
		ls_v4= '00' + ls_v4;
		ls_v5=parseInt(data.substr(4,1))*1;
		ls_v5= '00' + ls_v5;
		ls_v6=parseInt(data.substr(5,1))*2;
		ls_v6= '00' + ls_v6;
		ls_v7=parseInt(data.substr(6,1))*4;
		ls_v7= '00' + ls_v7;
		ls_v8=parseInt(data.substr(7,1))*1;
		ls_v8= '00' + ls_v8;
		
		
		//
		ls_v1=ls_v1.substr(ls_v1.length-2,2);
		ls_v2=ls_v2.substr(ls_v2.length-2,2);
		ls_v3=ls_v3.substr(ls_v3.length-2,2);
		ls_v4=ls_v4.substr(ls_v4.length-2,2);
		ls_v5=ls_v5.substr(ls_v5.length-2,2);
		ls_v6=ls_v6.substr(ls_v6.length-2,2);
		ls_v7=ls_v7.substr(ls_v7.length-2,2);
		ls_v8=ls_v8.substr(ls_v8.length-2,2);
	
		li_v1=parseInt(ls_v1.substr(0,1)) + parseInt(ls_v1.substr(1,1));
		li_v2=parseInt(ls_v2.substr(0,1)) + parseInt(ls_v2.substr(1,1));
		li_v3=parseInt(ls_v3.substr(0,1)) + parseInt(ls_v3.substr(1,1));
		li_v4=parseInt(ls_v4.substr(0,1)) + parseInt(ls_v4.substr(1,1));
		li_v5=parseInt(ls_v5.substr(0,1)) + parseInt(ls_v5.substr(1,1));
		li_v6=parseInt(ls_v6.substr(0,1)) + parseInt(ls_v6.substr(1,1));
		li_v7=parseInt(ls_v7.substr(0,1)) + parseInt(ls_v7.substr(1,1));
		li_v8=parseInt(ls_v8.substr(0,1)) + parseInt(ls_v8.substr(1,1));
		
		if (((li_v1+li_v2+li_v3+li_v4+li_v5+li_v6+li_v7+li_v8)%10) == 0) 
			lb_ret1=true;
		else
		 	lb_ret1=false;
		
		if (li_v7 == 10) {
			if (((li_v1+li_v2+li_v3+li_v4+li_v5+li_v6+ 1 +li_v8)%10) == 0)
				lb_ret2=true;
			else
				lb_ret2=false;
		}else{
			lb_ret2=false;
		}
		
		
		if ( lb_ret1 || lb_ret2 ){
			return true;
		}else{
			return false;
		}

	}
}
function isNull2(textObj)
{

	if (textObj.value==""||javaTrim(textObj.value)=="")
	{
		return true;
	}
	return false;
}
function isInteger2(noObj)
{
	if (noObj.value=="")
	{
		return true;
	}

	if (isNaN(noObj.value) || (noObj.value.indexOf("-")>-1))
	{
		return false;
	}
	if (isNaN(noObj.value) || (noObj.value.indexOf(".")>-1))
	{
		return false;
	}
	strValue=noObj.value;
	for (i=0;i<strValue.length;i++)
	{
		if (strValue.charCodeAt(i,1)!=46 && (strValue.charCodeAt(i,1)<48 || strValue.charCodeAt(i,1)>57))
		{
			return false;
		}
	}
	return true;
}

function checkLen2(textObj,size)
{
	if (strLength(textObj.value)>size)
	{
		return true;
	}
	return false;
}

function checkOnlyNumber(obj){
    if (javaTrim(obj.value)=="") return false;
    if (isNaN(obj.value)|| obj.value.indexOf(' ') > 0 || obj.value.indexOf('.')>0 || obj.value.toUpperCase().indexOf('E')>0 ) {
	    return false;			
    }
    return true;
}

function checkOnlyAlphaNumber(obj){
    var count=0;
    if (javaTrim(obj.value)=="") return false;
    if (obj.value.indexOf(' ') > 0) return false;
    while (count < obj.value.length)
    {

        if (isNaN(obj.value.charAt(count)) && (obj.value.toUpperCase().charAt(count) < 'A' || obj.value.toUpperCase().charAt(count) > 'Z'))
        {
            return false;
        }
        count++;
    }
    return true;
}

function isDate2(obj)
{
	if (obj.value=="") return true;

	if (obj.value.length!=8)
	{
		return false;
	}
	var strTmp=undoDate(obj.value);
	if (isValidDate(strTmp.substring(0,4),strTmp.substring(4,6),strTmp.substring(6,8)))
	{
		return true;
	}
	else
	{
	    return false;
	}
}
function isDate22(obj)
{
	if (obj.value=="") return true;

	if (obj.value.length!=8)
	{
		return false;
	}
	var strTmp=undoDate(obj.value);
	if (isValidDate(strTmp.substring(4,8),strTmp.substring(2,4),strTmp.substring(0,2)))
	{
		return true;
	}
	else
	{
	    return false;
	}
}
function isJulianDate2(intDate) {
	sDate = intDate.value;
	if(sDate.length > 3)
		sDate = sDate.substring(sDate.length-3);
	if(sDate > 365 || sDate < 1) {
		return false;
	}
	else
		return true;
}

function isMoney2(string)
{
	var length1 , i , j, k, flag = 0;
	var string1="";

	string1 = javaTrim(string);
	k = length1 = string1.length;

	if ((string1 == "0.00") || (string1 == "0.0") || (string1 == "0.") || (string1 == "0"))
	{
		return (false);
  }
	if (length1 == 0)
	{
		return(false);
	}
	if (string1.charAt(0)=="0" )
	{
		if (length1 == 1)
		{
	        	return(false);
	  }
	  else
	  {
	  	if (!(string1.charAt(1)=="."))
	  	{
				return(false);
			}
		}
	}
	j=0;
	for (i = 0 ; i < length1 ; i++) {
		if(isNaN(Math.floor(string1.charAt(i),10)))
		{
			if(string1.charAt(i) != ".")
			{
				return(false);
			}
			else  {
				j++;
				if(length1 - i > 3 )
				{
					return(false);
				}
			}
			if (flag == 0) {
				k = i;	flag = 1;
			}

		}
	}

	if (k > 12) {
		return false;
	}

	if(j > 1) {
		return false;
	}

	return true;
}

function isValidDate2( year, month, day )
{
   if( (year != "" && isNaN(year)) || isNaN(month) || isNaN(day))
   {
		return false
   }
   if(year != "" && ((year.length!=4) || (year.substring(0,1)<1) || year.indexOf(".") != -1))
   {
		return false
   }


   if(month.indexOf(".") != -1)
   {
			return false
	}

	if(day.indexOf(".") != -1)
	{
			return false
	}
   if(year != "")
    	year  = Math.floor(year,10);
    month = Math.floor(month,10);
    day   = Math.floor(day,10);

	if((month<1) || (month>12)){
			return false
	}
   if (( month==4) || (month==6) || (month==9) || (month==11) )
   { if (( day < 1) || (day > 30) )
     { 
       return false;
     }
   }
   else
   { if ( month!=2 )
     { if ( (day < 1) || (day > 31 ))
       {  
          return false;
       }
     }
     else
     {
       if(year != "") {
        	// month == 2
       		if ( ( year % 100 ) != 0 && (year % 4 == 0) || ( year % 100 ) == 0 && ( year % 400) == 0 )
       		{ if ( day > 29 )
         		{  
            		   return false;
                        }
                }
                else
                { if ( day > 28 )
                  { 
                    return false;
                  }
                }
       }
       else {
       		if(day > 29) {
       			
            		return false;
       		}
       }
     }
   }
 return (true);
}

/**
 * Variation of original functions, taking extra parameter as alert message
*/

function isNull3(textObj,error)
{

	if (javaTrim(textObj.value)=="")
	{
		tryToFocus(textObj);
		alert (error)
		return true;
	}
	return false;
}

function isInteger3(noObj,error)
{


	if (noObj.value=="")
	{
		return true;
	}

	if (isNaN(noObj.value) || (noObj.value.indexOf("-")>-1))
	{
		alert (error);
		tryToFocus(noObj);
		return false;
	}
	if (isNaN(noObj.value) || (noObj.value.indexOf(".")>-1))
	{
		alert (error);
		tryToFocus(noObj);
		return false;
	}
	strValue=noObj.value;
	for (i=0;i<strValue.length;i++)
	{
		if (strValue.charCodeAt(i,1)!=46 && (strValue.charCodeAt(i,1)<48 || strValue.charCodeAt(i,1)>57))
		{
			alert (error);
			tryToFocus(noObj);
			return false;
		}
	}


	return true;
}


function isInt3(noObj,maxValue,error)
{
	if (noObj.value=="")
	{
		return true;
	}

	if (isNaN(noObj.value) || (noObj.value.indexOf("-")>-1))
	{
		alert (error);
		tryToFocus(noObj);
		return false;
	}
	if (isNaN(noObj.value) || (noObj.value.indexOf(".")>-1))
	{
		alert (error);
		tryToFocus(noObj);
		return false;
	}
	strValue=noObj.value;
	for (i=0;i<strValue.length;i++)
	{
		if (strValue.charCodeAt(i,1)!=46 && (strValue.charCodeAt(i,1)<48 || strValue.charCodeAt(i,1)>57))
		{
			alert (error);
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
		alert (error);
		tryToFocus(noObj);
		return false;
		}

}
function correctMoney(number){
	var array = number.split('.');
	var num1 = array[0];
	var intNum ="";
	var numArray = new Array();
	
    if(num1.charAt(0)=='-'){
    	intNum = num1.substring(1,num1.length);
	}
	else{
		intNum = num1;
	}
	if(intNum.length<4){
		return num1;
	}
	else{
		var j= 0;
		var k= 0;
		for(var i=intNum.length-3;i>0;i=i-3){
			numArray[j]=intNum.substring(i,i+3);
			j++;
			k=i;
		}
		var retNum = intNum.substring(0,k);
		for(var h=j-1;h>=0;h--){
			retNum = retNum+','+numArray[h];
		}
	    if(num1.charAt(0)=='-'){
    		retNum = '-'+retNum;
		}
		if(array.size>1){
			retNum = retNum + '.'+array[1];
		}
		return retNum;
	}
}


/**
 * end 
*/


function SameDate(text1, text2, textName1,textName2,error)
{
	var strTmp1=undoDate(text1.value);
	var strTmp2=undoDate(text2.value);

	i = compareDates(strTmp1.substring(0,4),strTmp1.substring(4,6),strTmp1.substring(6,8),strTmp2.substring(0,4),strTmp2.substring(4,6),strTmp2.substring(6,8));
	if( i == 0){
		alert (error ) ;
		text1.select();
		return true;
	}
	return false;
}