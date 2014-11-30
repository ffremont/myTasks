'use strict';

var app = require('angular').module('myNote');

app.factory('User', require('./user')); 
app.factory('Task', require('./task')); 
app.factory('MyHttpInterceptor', require('./myHttpInterceptor')); 