'use strict';

/* Module for Orderdetail */

var orderdetailModule = angular.module('orderdetail.module', ['myApp']);

/**
 * Module for orderdetail
 */
orderdetailModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/orderdetail',    {templateUrl: 'partials/orderdetail/orderdetail_list.html', controller: 'OrderdetailCtrl'});
    $routeProvider.when('/orderdetail/new', {templateUrl: 'partials/orderdetail/orderdetail_form.html', controller: 'OrderdetailCtrl'});
    $routeProvider.when('/orderdetail/:orderno/:uid', {templateUrl: 'partials/orderdetail/orderdetail_form.html', controller: 'OrderdetailCtrl'});
}]);
