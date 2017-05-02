'use strict';

angular.module('myApp.publicarLibro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/publicarLibro', {
    templateUrl: 'publicarLibro/publicarLibro.html',
    controller: 'ControlPublicarLibro'
  });
}])

.controller('ControlPublicarLibro', ['$scope', '$location', 'AddLibroFactory', 'AddLibroPictureFactory',  function ($scope,$location, AddLibroFactory, AddLibroPictureFactory) {


    $scope.updateFactoryLibro = function(nombre, editorial, autor){

    var todo = {
        'Id': ''+localStorage.getItem("usuario")+nombre+4.783042,
        'nombre': nombre,
        'editorial': editorial,
        'autor': autor,
        'latitude': 4.783042,
        'longitude': -74.042682
    };
    AddLibroFactory.save({useremail:localStorage.getItem("usuario")},todo);
      //  AddLibroPictureFactory.save({idlibro:todo.Id}, localStorage.getItem("imagen"));
    $location.path("/misLibros");
    }
}]);