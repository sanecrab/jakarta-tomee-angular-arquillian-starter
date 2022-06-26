'use strict';

/* Controllers */

var starterProjectSampleApp = angular.module('starterProjectSampleApp', []);

starterProjectSampleApp.controller('ProjectCtrl', function ($scope, $http) {
    $http.get('api/sample/list')
            .then(function (response) {
                $scope.samples = response.data;
            }, function (error) {
                console.log(error, 'can\'t get data.');
            });
    $scope.orderProp = 'age';
});
