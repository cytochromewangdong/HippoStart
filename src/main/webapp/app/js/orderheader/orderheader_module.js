'use strict';

/* Module for Orderheader */

var orderheaderModule = angular.module('orderheader.module', ['myApp']);

/**
 * Module for orderheader
 */
orderheaderModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/orderheader',    {templateUrl: 'partials/orderheader/orderheader_list.html', controller: 'OrderheaderCtrl'});
    $routeProvider.when('/orderheader/new', {templateUrl: 'partials/orderheader/orderheader_form.html', controller: 'OrderheaderCtrl'});
    $routeProvider.when('/orderheader/:uid', {templateUrl: 'partials/orderheader/orderheader_form.html', controller: 'OrderheaderCtrl'});
}]);
