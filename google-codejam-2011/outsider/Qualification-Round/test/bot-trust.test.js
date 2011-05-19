var bot = require('../main/bot-trust.js'),
    assert = require('assert');

module.exports = {
    'Case #3 시간을 계산한다': function() {
        bot.orange.length = 0;
        bot.parseQuestion('2 B 2 B 1');
        assert.eql('4', bot.computeTime());
    }
}
