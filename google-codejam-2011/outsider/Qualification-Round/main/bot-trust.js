var fs = require('fs'),
    bot = exports;

var robot = function() {
   return {
      type: null,
      button: null
   };
};

bot.orange = new Array();
bot.blue = new Array();

bot.parseQuestion = function(input) {
   var arr = input.split(' ');
   for (var i = 1; i <= arr[0]*2; i += 2) {
      var rb = new robot();
      rb.type = arr[i];
      rb.button = arr[i+1]*1;
      
      if (rb.type === 'O') {
         this.orange.push(rb);      
      } else {
         this.blue.push(rb);      
      }
   }
};

bot.computeTime = function() {
   var sum = 0;
   
   var isEnd = true;
   while (isEnd) {
      sum++;
      if (this.orange.length > 0) {
         this.orange[0].button -= 1;
         //console.log('Orange: '+ this.orange[0].button);
         if (this.orange[0].button < 1) {
            this.orange.splice(0, 1);
         }
      }      
      
      if (this.blue.length > 0) {
         this.blue[0].button -= 1;
         //console.log('Blue: '+ this.blue[0].button);
         if (this.blue[0].button < 1) {
            this.blue.splice(0, 1);
         }
      }
      
      if (this.orange.length < 1 && this.blue.length < 1) {
         isEnd = false;
      }
   }
   return sum;
}
