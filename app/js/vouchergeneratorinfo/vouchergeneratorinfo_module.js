'use strict';

/* Module for Vouchergeneratorinfo */

var vouchergeneratorinfoModule = angular.module('vouchergeneratorinfo.module', ['myApp']);

/**
 * Module for vouchergeneratorinfo
 */
vouchergeneratorinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/vouchergeneratorinfo',    {templateUrl: 'partials/vouchergeneratorinfo/vouchergeneratorinfo_list.html', controller: 'VouchergeneratorinfoCtrl'});
    $routeProvider.when('/vouchergeneratorinfo/new', {templateUrl: 'partials/vouchergeneratorinfo/vouchergeneratorinfo_form.html', controller: 'VouchergeneratorinfoCtrl'});
    $routeProvider.when('/vouchergeneratorinfo/:uid', {templateUrl: 'partials/vouchergeneratorinfo/vouchergeneratorinfo_form.html', controller: 'VouchergeneratorinfoCtrl'});
}]);
