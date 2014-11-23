'use strict';

module.exports = ['$q', 'notificationService', function ($q, notificationService) {
        return {
            // optional method
            'request': function (config) {
                // do something on success
                return config;
            },
            // optional method
            'requestError': function (rejection) {
                notificationService.notifyError("requestError", "Client indisponible");
                return $q.reject(rejection);
            },
            // optional method
            'response': function (response) {
                // do something on success
                return response;
            },
            // optional method
            'responseError': function (rejection) {
                notificationService.notifyError("responseError", "Serveur indisponible");
                return $q.reject(rejection);
            }
        };
    }];