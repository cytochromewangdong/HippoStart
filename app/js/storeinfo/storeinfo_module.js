'use strict';

/* Module for Storeinfo */

var storeinfoModule = angular.module('storeinfo.module', ['myApp']);

/**
 * Module for storeinfo
 */
storeinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/storeinfo',    {templateUrl: 'partials/storeinfo/storeinfo_list.html', controller: 'StoreinfoCtrl'});
    $routeProvider.when('/storeinfo/new', {templateUrl: 'partials/storeinfo/storeinfo_form.html', controller: 'StoreinfoCtrl'});
    $routeProvider.when('/storeinfo/:uid', {templateUrl: 'partials/storeinfo/storeinfo_form.html', controller: 'StoreinfoCtrl'});
}]);
