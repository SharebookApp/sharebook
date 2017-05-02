
angular.module('appMaps', ['ngRoute', 'uiGmapgoogle-maps'])
  .config(['$routeProvider', function($routeProvider) {
      $routeProvider.when('/mapa', {
        templateUrl: 'mapa/mapa.html',
        controller: 'mainCtrl'
      });
    }])

    .controller('mainCtrl', function($scope, $timeout, LibrosDispoFactory, LibroById,$mdDialog) {
    var markerId = 0;
    var libros = [];
    var data = [];
     $scope.listado = [];
        $scope.listado = LibrosDispoFactory.query({username:localStorage.getItem("usuario")},function (response) {
            angular.forEach(response, function (item) {
                    data.push(item);
            });
        $scope.listado = [];
            function refresh(marker) {
                	 $timeout(function(){
                		$scope.map.control.refresh({latitude: marker.latitude,
                		longitude: marker.longitude});
                		},3000);
                	}

                	function create(latitude, longitude, id) {
                		var marker = {
                			options: {
                				animation: 1,
                				labelAnchor: "30 -5",
                				labelClass: 'markerlabel'
                			},
                			latitude: latitude,
                			longitude: longitude,
                			id: id
                		};
                		return marker;
                	}

                	function invokeSuccessCallback(successCallback, marker) {
                		if (typeof successCallback === 'function') {
                			successCallback(marker);
                		}
                	}

                	function createByCoords(latitude, longitude, id, successCallback) {
                		var marker = create(latitude, longitude, id);
                		invokeSuccessCallback(successCallback, marker);
                	}
                    for (i = 0; i < data.length; i++) {
                        createByCoords(data[i].latitude, data[i].longitude, data[i].id, function (marker) {
                            		marker.options.labelContent = data[i].nombre;
                            		marker.options.icon = '/app/imagenes/book.png';
                            		refresh(marker);
                            		libros.push(marker);

                            	});
                    }

                    $scope.showConfirm = function(ev) {
                           // Appending dialog to document.body to cover sidenav in docs app
                           var confirm = $mdDialog.confirm()
                                 .title('¿Quieres solicitar este libro?')
                                 .textContent('Nombre: '+ev.nombre +'\n  Editorial: '+ev.editorial + '\n   Autor: ' + ev.autor)
                                 .targetEvent(ev)
                                 .ok('Solicitar!')
                                 .cancel('Volver');

                           $mdDialog.show(confirm).then(function() {

                           }, function() {

                           });
                         };

                	function createByCurrentLocation(successCallback) {
                    	if (navigator.geolocation) {
                    		navigator.geolocation.getCurrentPosition(function (position) {
                    			var marker = create(position.coords.latitude, position.coords.longitude);
                    			invokeSuccessCallback(successCallback, marker);
                    		});
                    	} else {
                    		alert('Unable to locate current position');
                    	}
                    }

                    createByCurrentLocation(function (marker) {
                    	marker.options.labelContent = 'Aqui estas';
                    	$scope.map.markers.push(marker);
                    	refresh(marker);
                    });

                $scope.map = {
                        		center: {
                        			latitude: 4.782627,
                        			longitude: -74.042634
                        		},
                        		zoom: 18,
                        		markers: [],
                        		options : {
                        			scrollwheel: true
                        		},
                        		window: {
                                        model: {},
                                        show: false,
                                        options:{
                                          pixelOffset: {width:-1,height:-20}
                                        }
                                      },
                                markersEvents: {
                                        click: function(marker, eventName, model, args) {

                                          for (i = 0; i < data.length; i++) {
                                                if(model.id === data[i].id){
                                                    $scope.libroMarcador = data[i];
                                                    $scope.nombrema = data[i].nombre;
                                                    console.info("  "+data[i].nombre);
                                                    }
                                           }

                                           $scope.map.window.model = model;
                                            $scope.map.window.show = true;
                                        }
                                      },
                        		control: {}
                        	};
                for (i = 0; i < libros.length; i++) {
                    $scope.map.markers.push(libros[i]);

                    }
        });


           })
           .controller('templateController',function($scope){});
