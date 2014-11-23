'use strict';

var app = require('angular').module('myNote');

app.service('userService', require('./user')); 
app.service('notificationService', require('./notification')); 