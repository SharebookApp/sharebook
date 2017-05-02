'use strict';

angular.module('myApp.misLibros', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/misLibros', {
    templateUrl: 'misLibros/misLibros.html',
    controller: 'misLibrosCtrl'
  });
}])

.controller('misLibrosCtrl', ['$scope','fabricaMisLibro',function($scope,fabricaMisLibro) {

     $scope.listado = [];
     $scope.listado= fabricaMisLibro.query({username:localStorage.getItem("usuario")});

}]  );