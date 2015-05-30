'use strict';

/* Module for Lottoryvoucherinfo */

var lottoryvoucherinfoModule = angular.module('lottoryvoucherinfo.module', ['myApp']);

/**
 * Module for lottoryvoucherinfo
 */
lottoryvoucherinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/lottoryvoucherinfo',    {templateUrl: 'partials/lottoryvoucherinfo/lottoryvoucherinfo_list.html', controller: 'LottoryvoucherinfoCtrl'});
    $routeProvider.when('/lottoryvoucherinfo/new', {templateUrl: 'partials/lottoryvoucherinfo/lottoryvoucherinfo_form.html', controller: 'LottoryvoucherinfoCtrl'});
    $routeProvider.when('/lottoryvoucherinfo/:uid', {templateUrl: 'partials/lottoryvoucherinfo/lottoryvoucherinfo_form.html', controller: 'LottoryvoucherinfoCtrl'});
}]);
