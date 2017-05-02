'use strict';

angular.module('myApp.login', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'login/login.html',
    controller: 'loginCtrl'
  });
}])

.controller('loginCtrl', ['$rootScope', '$scope', '$http', '$location', function ($scope, $rootScope, $http, $location) {

    var authenticate = function (credentials, callback) {

        var headers = credentials ? {authorization: "Basic " + btoa(credentials.username + ":" + credentials.password)} : {};
            $http.get('/app/user', {headers: headers}).then(function (data) {
                console.log(data);
                        if (data.data.name) {
                            $rootScope.authenticated = true;

                        } else {
                            $rootScope.authenticated = false;
                        }
                callback && callback();
            },function (error) {
                $rootScope.authenticated = false;
                callback && callback();
            });

    };

    authenticate();
    $scope.credentials = {};
    $scope.login = function () {
        authenticate($scope.credentials, function () {
            if ($rootScope.authenticated) {
                 localStorage.setItem("usuario", $scope.credentials.username);
                $location.path("/intercambiar");
                $scope.error = false;

            } else {
                $location.path("/login");
                $scope.error = true;
            }
        });
    };

    $scope.logout = function () {
                $http.post('/logout', {}).then(function () {
                    $rootScope.authenticated = false;
                    $location.path("/login");
                 }),function (data) {
                    $rootScope.authenticated = false;
                 };
            };

}]);