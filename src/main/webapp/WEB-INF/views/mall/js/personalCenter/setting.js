/**
 * Created by admin on 2017/2/13.
 * 弹出框
 */
$(function(){
    $('.main-right-nav li').click(function(){
        var id=parseInt($(this).attr('data-id')),
            obj1=$('.mr-info'),
            obj2= $('.mr-address'),
            obj3=$('.mr-security-center');
        if(!$(this).hasClass('main-right-navselected')){
            $('.main-right-navselected').removeClass('main-right-navselected');
            $(this).addClass('main-right-navselected');
            switch(id){
                case 1:
                    obj1.show();
                    obj2.hide();
                    obj3.hide();
                    break;
                case 2:
                    obj1.hide();
                    obj2.show();
                    obj3.hide();
                    break;
                case 3:
                    obj1.hide();
                    obj2.hide();
                    obj3.show();
                    break;
                default :
            }
        }
    });
    $('.mr-security-operation').click(function(){
        var id=parseInt($(this).attr('data-id')),
            obj1=$('.mr-alert-phonebox'),
            obj2= $('.mr-alert-passwordbox');
        if(id==1){
            obj1.show();
            obj2.hide();
        }else {
            obj1.hide();
            obj2.show();
        }
    });
    $('.mr-alert-phcancel').click(function(){
        $('.mr-alert-phonebox').hide();
    });
    $('.mr-alert-pwcancel').click(function(){
        $('.mr-alert-passwordbox').hide();
    });
});