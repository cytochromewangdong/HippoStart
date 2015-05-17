'use strict';

/* Module for Administrator */

var administratorModule = angular.module('administrator.module', ['myApp']);

/**
 * Module for administrator
 */
administratorModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/administrator',    {templateUrl: 'partials/administrator/administrator_list.html', controller: 'AdministratorCtrl'});
    $routeProvider.when('/administrator/new', {templateUrl: 'partials/administrator/administrator_form.html', controller: 'AdministratorCtrl'});
    $routeProvider.when('/administrator/:uid', {templateUrl: 'partials/administrator/administrator_form.html', controller: 'AdministratorCtrl'});
}]);
