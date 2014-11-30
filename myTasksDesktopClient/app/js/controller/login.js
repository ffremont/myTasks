'use strict';

module.exports = ['$scope', 'userService', function ($scope, userService) {
        $scope.login = "";
        $scope.password = "";

        $scope.submit = function () {
            userService.login($scope.login, $scope.password);
        };
    }];