'use strict';

/* Module for Comboinfo */

var comboinfoModule = angular.module('comboinfo.module', ['myApp']);

/**
 * Module for comboinfo
 */
comboinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/comboinfo',    {templateUrl: 'partials/comboinfo/comboinfo_list.html', controller: 'ComboinfoCtrl'});
    $routeProvider.when('/comboinfo/new', {templateUrl: 'partials/comboinfo/comboinfo_form.html', controller: 'ComboinfoCtrl'});
    $routeProvider.when('/comboinfo/:uid', {templateUrl: 'partials/comboinfo/comboinfo_form.html', controller: 'ComboinfoCtrl'});
}]);
