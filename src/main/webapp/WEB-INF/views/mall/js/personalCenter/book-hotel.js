/**
 * Created by admin on 2017/2/14.
 */
$(function(){
    $('.mr-table-details').click(function(){
        $('.main-order-list').hide();
        $('.mr-hotle').show();
        $('.main-right-back').show();
        $('.main-right-title span').text('会员中心 > 已预订酒店 > 订单详情');
    });
    $('.main-right-back').click(function(){
        $('.main-order-list').show();
        $('.mr-hotle').hide();
        $(this).hide();
        $('.main-right-title span').text('会员中心 > 已预订酒店 > 订单列表');
    });
});