'use strict';

var app = require('angular').module('myNote');

app.constant('ROLES', require('./roles')); 
app.constant('EVENTS', require('./events')); 
app.constant('API', require('./api')); 
app.constant('ICONS', require('./icons')); 