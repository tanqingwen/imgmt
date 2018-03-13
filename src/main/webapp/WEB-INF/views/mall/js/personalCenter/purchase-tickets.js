/**
 * Created by admin on 2017/2/14.
 */
$(function(){
    $('.mr-table-details').click(function(){
        $('.main-order-list').hide();
        $('.mr-order-details').show();
        $('.main-right-back').show();
        $('.main-right-title span').text('会员中心 > 已订购票券 > 订单详情');
    });
    $('.main-right-back').click(function(){
        $('.main-order-list').show();
        $('.mr-order-details').hide();
        $(this).hide();
        $('.main-right-title span').text('会员中心 > 已订购票券 > 订单列表');
    });
});