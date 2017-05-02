'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngMaterial',
  'ngResource',
  'uiGmapgoogle-maps',
  'appMaps',
  'ngAnimate',
  'ui.bootstrap',
  'fileUpload',
  'myApp.login',
  'myApp.registro',
  'myApp.publicarLibro',
  'myApp.librosDisponibles',
  'myApp.misLibros',
  'myApp.buscarLibros',
  'myApp.solicitudes',
  'services.fabricaLibro',
  'services.fabricaUser',
  'myApp.intercambiar'

]).
config(['$locationProvider', '$routeProvider', '$httpProvider', function($locationProvider, $routeProvider, $httpProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.otherwise({redirectTo: '/login'});$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest'}]);
