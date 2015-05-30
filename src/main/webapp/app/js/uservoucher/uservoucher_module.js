'use strict';

/* Module for Uservoucher */

var uservoucherModule = angular.module('uservoucher.module', ['myApp']);

/**
 * Module for uservoucher
 */
uservoucherModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/uservoucher',    {templateUrl: 'partials/uservoucher/uservoucher_list.html', controller: 'UservoucherCtrl'});
    $routeProvider.when('/uservoucher/new', {templateUrl: 'partials/uservoucher/uservoucher_form.html', controller: 'UservoucherCtrl'});
    $routeProvider.when('/uservoucher/:uid', {templateUrl: 'partials/uservoucher/uservoucher_form.html', controller: 'UservoucherCtrl'});
}]);
