var remAdjust = function(defaultFontSize, defaultScreenWidth) {
      var htmlNode = document.getElementsByTagName('html')[0];

      function resize() {
        var screenWidth = document.body.offsetWidth;
        var screenHeight = window.screen.height;
        htmlNode.style.fontSize = screenWidth / defaultScreenWidth * defaultFontSize + 'px';
      }

      document.addEventListener('DOMContentLoaded', function () {
        resize();
      });
      window.addEventListener('resize', resize);
    };
    remAdjust(32, 640);