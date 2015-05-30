'use strict';

/* Module for Adlist */

var adlistModule = angular.module('adlist.module', ['myApp']);

/**
 * Module for adlist
 */
adlistModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/adlist',    {templateUrl: 'partials/adlist/adlist_list.html', controller: 'AdlistCtrl'});
    $routeProvider.when('/adlist/new', {templateUrl: 'partials/adlist/adlist_form.html', controller: 'AdlistCtrl'});
    $routeProvider.when('/adlist/:uid', {templateUrl: 'partials/adlist/adlist_form.html', controller: 'AdlistCtrl'});
}]);
