'use strict';

angular.module('myApp.intercambiar', ['ngRoute', 'ngMaterial'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/intercambiar', {
    templateUrl: 'intercambiar/intercambiar.html',
    controller: 'Ctrlintercambiar'

  });
}])
.controller('Ctrlintercambiar',  function ($scope, LibrosDispoFactory,AddSolicitudFactory,fabricaMisLibro, $mdDialog) {



    $scope.listado = [];
     $scope.selected = [];
    $scope.misli=[];
   $scope.listado= LibrosDispoFactory.query({username:localStorage.getItem("usuario")});
    $scope.misli= fabricaMisLibro.query({username:localStorage.getItem("usuario")});;

 //$scope.selected = $scope.misli[0];
  //$scope.selected.Id = "1";
   $scope.showConfirm = function(ev,sel) {
   console.log("Selcted"+sel.nombre);
       // Appending dialog to document.body to cover sidenav in docs app
       var confirm = $mdDialog.confirm()
             .title('¿Quieres solicitar el libro : ' + ev.nombre + "\n ?, a cambio de su libro :")

             .textContent(sel.nombre +'\n,de la Editorial: '+sel.editorial + '\n Autor: ' + sel.autor  )
             .targetEvent(ev)
             .ok('Solicitar!')
             .cancel('Volver');

       $mdDialog.show(confirm).then(function() {
         $scope.status = 'Usted ha solicitado el libro: '+ev.nombre + ' de '+ ev.autor + '.';
         var todo = {

             };
        AddSolicitudFactory.save({id1:ev.id,id2:sel.id},todo);
       }, function() {
         $scope.status = '';
       });
     };
});