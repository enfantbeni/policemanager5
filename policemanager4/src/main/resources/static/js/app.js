/**
 * 
 */
var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/templates/users.html',
            controller: 'usersController'
        })
        .when('/roles',{
            templateUrl: '/templates/roles.html',
            controller: 'rolesController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});