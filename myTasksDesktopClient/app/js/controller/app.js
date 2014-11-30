'use strict';

module.exports = ['$scope', '$rootScope', '$state', 'userService', 'EVENTS', function ($scope, $rootScope, $state, userService, EVENTS) {
        $scope.$state = $state;
        $scope.user = userService.current;

        $scope.$on('$stateChangeStart', function (e, next, current) {
            console.log("$stateChangeStart");
            var authorizedRoles = next.roles;
            if (!userService.isAuthorized(authorizedRoles)) {
                console.log(">> not auth");
                if (userService.isAuth()) {
                    $rootScope.$broadcast(EVENTS.NOT_AUTHORIZED);
                } else { 
                    $rootScope.$broadcast(EVENTS.NOT_AUTHENTICATED);
                }
                
                if(next.name !== "login"){
                    console.log(">> change to login");
                    e.preventDefault(); 
                    $state.go("login");
                }
            }
        });

        $scope.logout = function ($event) {
            $event.preventDefault();
            
            userService.logout();
        };
    }];