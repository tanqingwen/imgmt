<!--author Hugh 20160831-->
<!--content 明华非接触式读卡器-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<body>
<!--装载ActiveX -->
<object id="MWRFATL" classid="CLSID:856964B5-F42F-447B-A37D-ED07E8973ED2"></object>
</body>

<script language="javascript">
function readerOpen() {
	try {
	    var version = MWRFATL.openReader(1, 9600);
	    if (MWRFATL.LastRet != 0) {
	        alert("请连接乐园读卡器");
	        return;
	    }
	}catch (e) {
	    alert(e.Message);
	}
}


function readerClose() {
	try {
	    var result = MWRFATL.closeReader();
	    if (MWRFATL.LastRet != 0) {
	        alert("关闭读写器失败");
	    }
	}catch (e) {
	    alert(e.Message);
	}
}
</script>

<script>
var mt_block0;
var mt_block4;
var mt_block5;
var mt_block6;
var serialCard;

function doReady(){
	readerOpen();
    var result = MWRFATL.openCard(1, 16); //打开卡片,让其显示16进制字符串卡号
    serialCard=result;
    if (MWRFATL.LastRet != 0) {
        throw new Error("请放入乐园卡片");
    }
}


function readBlock0(){
	mt_block0 = readBlock(0,"FFFFFFFFFFFF");
	return mt_block0;
}


function readBlock(index,key){
	try{
		doReady();
		result = MWRFATL.cardDirVerifyPassword(0, index, key);
		if (MWRFATL.LastRet != 0) {
               alert("验证密码失败");
               return;
        }
		var block = cardRead(index);
		return block;
	}catch(e){
		readerClose();
		alert(e.message);
		return null;
	}finally{
		readerClose();
	}
}


function blankCheck(){
	var key = "FFFFFFFFFFFF";
	try{
		doReady();
		for(var i=0;i<24;i++){
			if(i%4==0){
				result = MWRFATL.cardDirVerifyPassword(0, i, key);
				if (MWRFATL.LastRet != 0) {
                    alert("验证密码失败");
                    return;
                }
			}
		}
	}catch(e){
		readerClose();
		throw new Error("只能使用空白卡,请更换");
	}finally{
		readerClose();
	}
}


function cardRead(BlockM1){
	return MWRFATL.cardReadHex(BlockM1);
}


function firstWrite(p){
	var key="FFFFFFFFFFFF";
	try{
		doReady();
		for(var i=0;i<p.length;i++){
			if(i%4==0){
				 MWRFATL.cardDirVerifyPassword(0, i, key);
			}
			if (MWRFATL.LastRet != 0) {
                   alert("验证密码失败");
                   return;
            }
			if(p[i]!=null&&p[i]!=""){
				MWRFATL.cardWriteHex(i, p[i]); //写数据,引函数只能写入16进制字符串,且长度必须为32位
			}
			if (MWRFATL.LastRet != 0) {
                  alert("写数据失败");
                  return;
            }
		}
	}catch(e){
		readerClose();
		return "";
	}finally{
		readerClose();
	}
}


function writeSector(sector,sectoridx,key){
	var p = sector;
	try{
		doReady();
		MWRFATL.cardDirVerifyPassword(0, sectoridx*4, key);
		for(var i =0;i<4;i++){
			if(p[i]!=null&&p[i]!=""){
				MWRFATL.cardWriteHex(sectoridx*4+i, p[i]); //写数据,引函数只能写入16进制字符串,且长度必须为32位
			}
		}
		return true;
	}catch(e){
		readerClose();
		alert(e.message);
		return false ;
	}finally{
		readerClose();
	}
}


function readCardNo(name,i){
	var cardno = getCardNo();
	document.getElementsByName("cbCardholderNo"+i+"")[0].value=cardno;
}


function getCardNo(){
	try{
		doReady();
		MWRFATL.cardDirVerifyPassword(0, 0, "A0A1A2A3A4A5"); //需要修改：A0A1A2A3A4A5
		if (MWRFATL.LastRet != 0) {
               alert("此卡是空卡，请实卡激活以后操作");
               return;
        }
		mt_block0=cardRead(0);
		var key1 = mt_block0.substr(0,6);
		MWRFATL.cardDirVerifyPassword(0, 4, key1+""+key1);
		if (MWRFATL.LastRet != 0) {
               alert("此卡已坏，请换一张卡操作");
               return;
        }
        mt_block4=cardRead(4);
		return mt_block4.substr(6,10);	
	}catch(e){
		readerClose();	
		alert(e.message);
		return "";
	}finally{
		readerClose();	
	}
}


function blockCheck(i,key){
	try{
		doReady();
		MWRFATL.cardDirVerifyPassword(0, i, key); 
		if (MWRFATL.LastRet != 0) {
               alert("验证密码失败");
               return;
        }
	}catch(e){
		readerClose();
		alert("卡片密钥异常,无法操作");
		return;
	}finally{
		readerClose();
	}
}



</script>
</head>
</html>