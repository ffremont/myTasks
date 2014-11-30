'use strict';

module.exports = ['$scope', '$state', function ($scope, $state) {
    $scope.itemActive = function(state){
        return $state.current.name === state;
    };
}];