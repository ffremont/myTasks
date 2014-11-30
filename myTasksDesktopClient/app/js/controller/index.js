'use strict';

var app = require('angular').module('myNote');

app.controller('loginCtrl', require('./login')); 
app.controller('appCtrl', require('./app')); 
app.controller('myTasksCtrl', require('./myTasks')); 
app.controller('menuCtrl', require('./menu')); 
app.controller('dashboardCtrl', require('./dashboard')); 
app.controller('addTaskCtrl', require('./addTask')); 