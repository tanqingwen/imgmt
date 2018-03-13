		$(function(e){
		
			function contains(parentNode, childNode) {
		    if (parentNode.contains) {
		        return parentNode != childNode && parentNode.contains(childNode);
		    } else {
		        return !!(parentNode.compareDocumentPosition(childNode) & 16);
		    }
		}
			function checkHover(e,target){
			    if (getEvent(e).type=="mouseover")  {
			        return !contains(target,getEvent(e).relatedTarget||getEvent(e).fromElement) && !((getEvent(e).relatedTarget||getEvent(e).fromElement)===target);
			    } else {
			        return !contains(target,getEvent(e).relatedTarget||getEvent(e).toElement) && !((getEvent(e).relatedTarget||getEvent(e).toElement)===target);
			    }
			}
			
			function getEvent(e){
			    return e||window.event;
			}
			
			$(".header-nav-main-nav li").on('mouseover',function(e){
				 if(checkHover(e,this)){
				 	
			      $(this).find(".hidden-nav").stop().css("z-index","888").slideDown(100);
			  }	
			})
			$(".header-nav-main-nav li").on('mouseout',function(e){
				 if(checkHover(e,this)){
			      $(this).find(".hidden-nav").stop().hide();
			  }	
			})
			
			$(".tick-logo").on('mouseover',function(e){
				 if(checkHover(e,this)){
			     $(this).find("img").stop().animate({marginTop:'-15px'},300);
			  }	
			})
			$(".tick-logo").on('mouseout',function(e){
				 if(checkHover(e,this)){
			         $(this).find("img").stop().animate({marginTop:'0'},300);
			  }	
			})
			
		
			
		})