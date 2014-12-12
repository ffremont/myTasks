'use strict';

var angular = require('angular');
module.exports = ['$window', '$http', '$state', function ($window, $http, $state) {
        this.current = {};

        this.isAuth = function () {
            return this.getAuthorization() !== null;
        };
        
        /**
         * 
         * @param {array} authorizedRoles
         * @returns {Boolean}
         */
        this.isAuthorized = function (authorizedRoles) {
            if (!angular.isArray(authorizedRoles)) {
                authorizedRoles = [authorizedRoles];
            }
            return (this.isAuth() &&
                    (authorizedRoles.indexOf(this.current.role) !== -1));
        };
        this.login = function (login, pass) {
            var me = this;
            $http.post('api/login', {login: login, password: pass}).
                success(function (data, status, headers, config) {
                    console.log("ok login");
                    me.current = data;
                    window.localStorage['app.security'] = me.current.hash;
                    
                    $state.go("dashboard");
                    
                }).error(function(){
                    console.log("ko login");
                    
                });
        };
        this.logout = function(){
            $window.localStorage['app.security'] = null;
            $state.reload();
        };

        this.getAuthorization = function () {
            return $window.localStorage && $window.localStorage['app.security'] ? $window.localStorage['app.security'] : null;
        };
    }];