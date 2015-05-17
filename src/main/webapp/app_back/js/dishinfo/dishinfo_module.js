'use strict';

/* Module for Dishinfo */

var dishinfoModule = angular.module('dishinfo.module', ['myApp']);

/**
 * Module for dishinfo
 */
dishinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/dishinfo',    {templateUrl: 'partials/dishinfo/dishinfo_list.html', controller: 'DishinfoCtrl'});
    $routeProvider.when('/dishinfo/new', {templateUrl: 'partials/dishinfo/dishinfo_form.html', controller: 'DishinfoCtrl'});
    $routeProvider.when('/dishinfo/:uid', {templateUrl: 'partials/dishinfo/dishinfo_form.html', controller: 'DishinfoCtrl'});
}]);
