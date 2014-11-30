'use strict';

var angular = require('angular');
require('angular-route');
require('angular-resource');
require('angular-ui-router');
require('angular-bootstrap');
require('ng-table');
require('ng-tags-input');
angular.module("myNote", ["ui.router", "ngResource", "ui.bootstrap", "ngTable", "ngTagsInput"]).config(['$stateProvider', '$httpProvider', 'ROLES', function ($stateProvider, $httpProvider, ROLES) {
        $stateProvider.state('login', {
            url: '/login',
            views: {
                'login': {
                    templateUrl: 'views/login.html',
                    controller: "loginCtrl"
                }
            },
            roles: [ROLES.ANONYMOUS]
        }).state('dashboard', {
            url: '/dashboard',
            views: { 
                'menu': {
                    templateUrl: 'views/menu.html',
                    controller: "menuCtrl"
                },
                'main': {
                    templateUrl: 'views/dashboard.html',
                    controller: "dashboardCtrl"
                }
            },
            roles: [ROLES.ADMIN, ROLES.USER, ROLES.MANAGER]
        }).state('myTasks', {
            url: '/myTasks',
            views: { 
                'menu': {
                    templateUrl: 'views/menu.html',
                    controller: "menuCtrl"
                },
                'main': {
                    templateUrl: 'views/myTasks.html',
                    controller: "myTasksCtrl"
                }
            },
            roles: [ROLES.ADMIN, ROLES.USER, ROLES.MANAGER]
        }).state('add-task', {
            url: '/add-task',
            views: { 
                'menu': {
                    templateUrl: 'views/menu.html',
                    controller: "menuCtrl"
                },
                'main': {
                    templateUrl: 'views/add-task.html',
                    controller: "addTaskCtrl"
                }
            },
            roles: [ROLES.ADMIN, ROLES.USER, ROLES.MANAGER]
        });

        $httpProvider.interceptors.push('MyHttpInterceptor');
    }])
        .run(['$state', '$location', 'userService', function ($state, $location, userService) {
                if (!userService.isAuth()) {
                    var urlLogin = $state.href("login");
                    if ($location.path() !== urlLogin) {
                        $location.path(urlLogin);
                        return;
                    }
                }
                
                $state.go("dashboard");
            }]);

require('./constant');
require('./factory');
require('./service');
require('./controller');