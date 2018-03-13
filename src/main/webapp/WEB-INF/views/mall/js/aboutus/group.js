/*
 *	Author		：蔡应
 *	Abstract	：长隆集团js文件
 *	Time		：2014年8月25日18:25:02
 */

//长隆集团首页

if( document.getElementById("bannerI")){
	fnIndex();
}
function fnIndex(){
	//banner
	fnBanner();
	function fnBanner(){
		var banner = document.getElementById("bannerI"),
			aBanner = banner.getElementsByTagName("li"),
			prev = getByClass(banner,"prev")[0],
			next = getByClass(banner,"next")[0],
			iNow = 0,
			timer = null ;
		
		prev.onclick = function(){
			if( iNow >0 ){
				iNow-- ;
			}else {
				iNow = aBanner.length-1 ;
			}
			bannerAni();
		}
		
		next.onclick = function(){
			if( iNow <aBanner.length-1 ){
				iNow++ ;
			}else {
				iNow = 0 ;
			}
			bannerAni();
		}
		
		prev.onmouseover = next.onmouseover = function(){
			clearInterval(timer);
		}
		
		prev.onmouseout = next.onmouseout = function(){
			timer = setInterval(function(){
				if( iNow <aBanner.length-1 ){
					iNow++ ;
				}else {
					iNow = 0 ;
				}
				bannerAni();
			},3000);
		}
		
		
		timer = setInterval(function(){
			if( iNow <aBanner.length-1 ){
				iNow++ ;
			}else {
				iNow = 0 ;
			}
			bannerAni();
		},3000);
		
		function bannerAni(){
			for( var z=0; z<aBanner.length ; z++ ){
				aBanner[z].style.zIndex = 9;
				startMove(aBanner[z],{"opacity":0},15);
			}	
			aBanner[iNow].style.zIndex = 10;
			startMove(aBanner[iNow],{"opacity":100},15);
		}
	}
	
	//新闻焦点图
	fnNewsPic();
	
	function fnNewsPic(){
		var parWrap = getByClass02("IfocusPicBox")[1],
			aPic = parWrap.getElementsByTagName("img"),
			prev = getByClass(parWrap,"prev")[0],
			next = getByClass(parWrap,"next")[0],
			iNow = 0,
			timer = null ;
		
		prev.onclick = function(){
			if( iNow >0 ){
				iNow-- ;
			}else {
				iNow = aPic.length-1 ;
			}
			picAni();
		}
		
		next.onclick = function(){
			if( iNow <aPic.length-1 ){
				iNow++ ;
			}else {
				iNow = 0 ;
			}
			picAni();
		}
		
		prev.onmouseover = next.onmouseover = function(){
			clearInterval(timer);
		}
		
		prev.onmouseout = next.onmouseout = function(){
			timer = setInterval(function(){
				if( iNow <aPic.length-1 ){
					iNow++ ;
				}else {
					iNow = 0 ;
				}
				picAni();
			},3000);
		}
		
		
		timer = setInterval(function(){
			if( iNow <aPic.length-1 ){
				iNow++ ;
			}else {
				iNow = 0 ;
			}
			picAni();
		},3000);
		
		function picAni(){
			for( var z=0; z<aPic.length ; z++ ){
				aPic[z].style.zIndex = 9;
				startMove(aPic[z],{"opacity":0},15);
			}	
			aPic[iNow].style.zIndex = 10;
			startMove(aPic[iNow],{"opacity":100},15);
		}
	}
	
	//小动画
	fnSmallAni();
	function fnSmallAni(){
		var toCl = document.getElementById("toCl");
		
		
		fnSp0();
		fnSp1();
		function fnSp0(){
			var sp = toCl.getElementsByTagName("span")[0];
			var i=0;
			var timer = setInterval(function(){
				if(i>-3){
					i--;
				}else { 
					i=0;
				}
				sp.style.backgroundPosition = "0px "+(i*30)+"px";
			},500);
		}
		
		function fnSp1(){
			var sp = toCl.getElementsByTagName("span")[1];
			var i=0;
			var timer = setInterval(function(){
				if(i>-3){
					i--;
				}else { 
					i=0;
				}
				sp.style.backgroundPosition = "-88px "+(i*30)+"px";
			},500);
		}
	}
	
	//焦点图
	function fnFocusPic(){
		
	}
		
}

//关于长隆 
if( getByClass02("conTabMenu")[0]){
	fnConTab();
}
function fnConTab(){
	var parMenu = getByClass02("conTabMenu")[0],
		aMenu = parMenu.getElementsByTagName("a"),
		parConWrap = getByClass02("conTabMenu")[0],
		aConItem = getByClass02("conItem");
		
	for ( var i=0; i<aMenu.length ; i++){
		aMenu[i].index = i;
		aMenu[i].onclick = function(){
			for ( var z=0; z<aMenu.length ; z++){
				aMenu[z].className = "null";
				aConItem[z].style.display = "none";
				startMove(aConItem[z],{"left":50,"opacity":0},8);
			}
			aMenu[this.index].className = "active";
			aConItem[this.index].style.display = "block";
			startMove(aConItem[this.index],{"left":0,"opacity":100},8);
		}
	}
		
}
//关于长隆焦点图
if( getByClass02("aboutFocusWrap")[0]){
	for( var n=0; n<getByClass02("aboutFocusWrap").length ; n++){
		fnAboutPic(n);
	}
}


function fnAboutPic(iNum){
	var parWrap = getByClass02("aboutFocusWrap")[iNum],
			picTitle = getByClass(parWrap,"focusPicT")[0],
			aPic = parWrap.getElementsByTagName("img"),
			prev = getByClass(parWrap,"prevPic")[0],
			next = getByClass(parWrap,"nextPic")[0],
			iNow = 0,
			timer = null ;
		
		prev.onclick = function(){
			if( iNow >0 ){
				iNow-- ;
			}else {
				iNow = aPic.length-1 ;
			}
			picAni();
		}
		
		next.onclick = function(){
			if( iNow <aPic.length-1 ){
				iNow++ ;
			}else {
				iNow = 0 ;
			}
			picAni();
		}
		
		prev.onmouseover = next.onmouseover = function(){
			clearInterval(timer);
		}
		
		prev.onmouseout = next.onmouseout = function(){
			timer = setInterval(function(){
				if( iNow <aPic.length-1 ){
					iNow++ ;
				}else {
					iNow = 0 ;
				}
				picAni();
			},3000);
		}
		
		
		timer = setInterval(function(){
			if( iNow <aPic.length-1 ){
				iNow++ ;
			}else {
				iNow = 0 ;
			}
			picAni();
		},3000);
		
		function picAni(){
			for( var z=0; z<aPic.length ; z++ ){
				aPic[z].style.zIndex = 9;
				startMove(aPic[z],{"opacity":0},15);
			}	
			aPic[iNow].style.zIndex = 10;
			picTitle.innerHTML = aPic[iNow].alt;
			startMove(aPic[iNow],{"opacity":100},15);
		}
}

//大事记
if( getByClass02("eventsNav")[0]){
	fnEvents();
}
function fnEvents(){
	var parNav = getByClass02("eventsNav")[0],
		oNav = parNav.getElementsByTagName("ul")[0],
		aNav = parNav.getElementsByTagName("ul")[0].getElementsByTagName("a"),
		moveActive = parNav.getElementsByTagName("em")[0],
		prev = getByClass(parNav,"eventsNavPre")[0],
		next = getByClass(parNav,"eventsNavNext")[0],
		tabCon = getByClass02("eventsConWrap"),
		iThis = 0;
	
	for( var i=0; i<aNav.length ; i++){
		aNav[i].index = i; 
		aNav[i].onclick = function(){
			iThis = this.index; 
			fnAni();
		}
	}
	
	prev.onclick = function(){
		if( iThis > 0 ){
			iThis--;
		}else {
			iThis = aNav.length-1;
		}
		fnAni();
	}
	
	next.onclick = function(){
		if( iThis < aNav.length-1 ){
			iThis++;
		}else {
			iThis = 0;
		}
		fnAni();
	}
	
	function fnAni(){
		for( var z=0; z<aNav.length ; z++){
			aNav[z].className = "null";
			tabCon[z].style.display = "none"; 
		}
		aNav[iThis].className = "active";
		tabCon[iThis].style.display = "block"; 
		startMove(moveActive,{"left":iThis*151+60},5);
		
		if( iThis >3 && iThis< aNav.length-3 ){
			startMove(oNav,{"left":-(iThis-3)*151+54},5);
		}else if( iThis> aNav.length-4 ){
			startMove(oNav,{"left":-(aNav.length-5)*151+54},5);
		}else if( iThis < 4 ){
			startMove(oNav,{"left":54},5);
		}
	}	
}

//旗下机构
//关于长隆 
if( getByClass02("qConWrap")[0]){
	fnQConTab();
}
function fnQConTab(){
	
	var parWrap = getByClass02("qConWrap")[0],
		prev = getByClass(parWrap,"prev")[0],
		next = getByClass(parWrap,"next")[0],
		parMenu = getByClass02("qItemMenu")[0],
		aMenu = parMenu.getElementsByTagName("a"),
		parPic = getByClass02("qItemPic")[0],
		aPic = parPic.getElementsByTagName("img"),
		parLogo = getByClass02("qItemLogo")[0],
		aLogo = parLogo.getElementsByTagName("li"),
		aConItem = getByClass02("qConInfo"),
		iThis = 0;
		
	for ( var i=0; i<aMenu.length ; i++){
		aMenu[i].index = i;
		aMenu[i].onclick = function(){
			iThis = this.index;
			fnAni();
		}
	}
	
	
	prev.onclick = function(){
		if( iThis > 0 ){
			iThis--;
		}else {
			iThis = aPic.length-1;
		}
		fnAni();
	}
	
	next.onclick = function(){
		if( iThis < aPic.length-1 ){
			iThis++;
		}else {
			iThis = 0;
		}
		fnAni();
	}
	function fnAni(){
		for ( var z=0; z<aMenu.length ; z++){
			aMenu[z].className = "null";
			aConItem[z].style.display = "none";
			startMove(aConItem[z],{"left":50,"opacity":0},8);
			aLogo[z].style.display= "none";
			aPic[z].style.zIndex = 9;
			startMove(aPic[z],{"opacity":0},8);
		}
		aMenu[iThis].className = "active";
		aConItem[iThis].style.display = "block";
		startMove(aConItem[iThis],{"left":0,"opacity":100},8);
		aLogo[iThis].style.display= "block";
		aPic[iThis].style.zIndex = 10;
		startMove(aPic[iThis],{"opacity":100},8);
	}
		
}