'use strict';

/* Module for Dishspecificationinfo */

var dishspecificationinfoModule = angular.module('dishspecificationinfo.module', ['myApp']);

/**
 * Module for dishspecificationinfo
 */
dishspecificationinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/dishspecificationinfo',    {templateUrl: 'partials/dishspecificationinfo/dishspecificationinfo_list.html', controller: 'DishspecificationinfoCtrl'});
    $routeProvider.when('/dishspecificationinfo/new', {templateUrl: 'partials/dishspecificationinfo/dishspecificationinfo_form.html', controller: 'DishspecificationinfoCtrl'});
    $routeProvider.when('/dishspecificationinfo/:dishid/:uid', {templateUrl: 'partials/dishspecificationinfo/dishspecificationinfo_form.html', controller: 'DishspecificationinfoCtrl'});
}]);
