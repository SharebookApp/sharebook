'use strict';

angular.module('myApp.solicitudes', ['ngRoute', 'ngMaterial'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/solicitudes', {
    templateUrl: 'solicitudes/solicitudes.html',
    controller: 'ControlSolicitudes'
  });
}])

.controller('ControlSolicitudes',  function ($scope, ListSolicitudesFactory, $mdDialog) {

    $scope.listado = [];
    $scope.lista1 = [];
    $scope.lista2 = [];
    $scope.listadoSoli = [];
   $scope.listadoSoli= ListSolicitudesFactory.query({username:localStorage.getItem("usuario")},function (response) {
           angular.forEach(response, function (item) {
                console.info(item[0].nombre);
                lista1.push(item[0]);
                lista2.push(item[1]);
         });
   $scope.showConfirm = function(ev) {
          // Appending dialog to document.body to cover sidenav in docs app
          var confirm = $mdDialog.confirm()
                .title('¿Quieres solicitar este libro?')
                .textContent('Nombre: '+ev.nombre +'\n  Editorial: '+ev.editorial + '\n   Autor: ' + ev.autor)
                .targetEvent(ev)
                .ok('Solicitar!')
                .cancel('Volver');

          $mdDialog.show(confirm).then(function() {
            $scope.status = 'Usted ha solicitado el libro: '+ev.nombre + ' de '+ ev.autor + '.';
          }, function() {
            $scope.status = '';
          });
        };
});
});