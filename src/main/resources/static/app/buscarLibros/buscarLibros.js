'use strict';

angular.module('myApp.buscarLibros', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/buscarLibros', {
    templateUrl: 'buscarLibros/buscarLibros.html',
    controller: 'buscarLibrosCtrl'
  });
}])

.controller('buscarLibrosCtrl', ['$scope','fabricaBuscarLibro',function($scope,fabricaBuscarLibro) {
    $scope.showConfirm = function(ev) {
    console.log("Entro a buscar")
        $scope.listado= fabricaBuscarLibro.query({bookname:localStorage.getItem(ev)});


           }


}]);

/*
$scope.showConfirm = function(ev) {
       $scope.listado= fabricaLibro.getListado();
       for(var i =0;i<$scope.listado.length;i++){
       if(ev===$scope.listado[i].nombre){

                           document.getElementById('status').innerHTML = 'Id:'+$scope.listado[i].id+ "  Nombre: "+$scope.listado[i].nombre+ "  Editorial: "+$scope.listado[i].editorial+"  Autor: "+ $scope.listado[i].autor;
                    break;
                  }
                  else{

                   document.getElementById('status').innerHTML = "El libro no se encuentra disponible.";

                        }
       }
           // Appending dialog to document.body to cover sidenav in docs ap
           }


}

}]);
*/
