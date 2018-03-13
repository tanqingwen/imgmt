////rem自适应代码
//(function(){
//  var doc=document,
//      win=window;
//  var docEl = doc.documentElement,
//      resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
//      recalc = function () {
//        var clientWidth = docEl.clientWidth;
//        if (!clientWidth) return;
//        if (clientWidth > 640) clientWidth = 640;
//        if (clientWidth < 320) clientWidth = 320;
//        docEl.style.fontSize = 20 * (clientWidth / 320) + 'px';
//      };
//
//  if (!doc.addEventListener) return;
//  win.addEventListener(resizeEvt, recalc, false);
//  doc.addEventListener('DOMContentLoaded', recalc, false);
//})();
// 动态计算屏幕的宽度，从而得到网页的fontSize大小
(function (doc, win) {
    var docEl = doc.documentElement,
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            if(clientWidth>750) clientWidth=750;//这里限制最大的宽度尺寸，从而实现PC端的两边留白等
            docEl.style.fontSize = 10 * (clientWidth / 320) + 'px';
        };

    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window);