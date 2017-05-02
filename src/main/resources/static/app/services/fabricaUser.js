'use strict';
angular.module('services.fabricaUser', ['ngRoute'])

    .factory('fabricaUser', function () {
        var data = {
             usuarios: [
                            {"nombre":'daniel', "email":'daniel.ayala@m', "password":'123', "latitude":4.782627, "longitude":-74.042634},
                            {"nombre":'manuel', "email":'manuel@m', "password":'123', "latitude":4.782603, "longitude":-74.044069},
                            {"nombre":'alejandro', "email":'alejo@m', "password":'123', "latitude":4.783699, "longitude":-74.044713}
                            ]
        };
        return {
            getUsuarios: function () {
                return data.usuarios;
            },
            addTodo: function (todo) {
                data.usuarios.push(todo);
            }};
    });