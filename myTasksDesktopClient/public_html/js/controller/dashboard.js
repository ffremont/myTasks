'use strict';

module.exports = ['$scope', 'Task', 'ngTableParams', function ($scope, Task, ngTableParams) {
        $scope.currentTasks = [];

        $scope.tableParams = new ngTableParams({
            page: 1, // show first page
            count: 20           // count per page
        }, {
            total: 0, // length of data
            getData: function ($defer, params) {
                Task.query(function (data) {
                    $timeout(function () {
                        console.log(params);
                        params.total(data.total);
                        $defer.resolve(data ? data.rows : []);
                    }, 500);
                });
            }
        });
    }];