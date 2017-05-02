'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/register', {
    templateUrl: 'registro/registro.html',
    controller: 'registroCtrl'
  });
}])

.controller('registroCtrl', ['$rootScope', '$scope', '$http', '$location', 'fabricaUser', function ($scope, $rootScope, $http, $location, fabricaUser) {
$scope.usuarios= fabricaUser.getUsuarios;
$scope.updateFactory = function(nombre, email, password){
var todo = {
    'nombre':nombre,
    'email' : email,
    'password' : password
    };
    fabricaUser.addTodo(todo);
    $scope.usuarios= fabricaUser.getUsuarios();
    }

 }]);