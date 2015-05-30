'use strict';

/* Module for Dishprice */

var dishpriceModule = angular.module('dishprice.module', ['myApp']);

/**
 * Module for dishprice
 */
dishpriceModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/dishprice',    {templateUrl: 'partials/dishprice/dishprice_list.html', controller: 'DishpriceCtrl'});
    $routeProvider.when('/dishprice/new', {templateUrl: 'partials/dishprice/dishprice_form.html', controller: 'DishpriceCtrl'});
    $routeProvider.when('/dishprice/:uid', {templateUrl: 'partials/dishprice/dishprice_form.html', controller: 'DishpriceCtrl'});
}]);
