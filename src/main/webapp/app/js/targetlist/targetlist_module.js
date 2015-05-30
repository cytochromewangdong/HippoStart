'use strict';

/* Module for Targetlist */

var targetlistModule = angular.module('targetlist.module', ['myApp']);

/**
 * Module for targetlist
 */
targetlistModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/targetlist',    {templateUrl: 'partials/targetlist/targetlist_list.html', controller: 'TargetlistCtrl'});
    $routeProvider.when('/targetlist/new', {templateUrl: 'partials/targetlist/targetlist_form.html', controller: 'TargetlistCtrl'});
    $routeProvider.when('/targetlist/:uid', {templateUrl: 'partials/targetlist/targetlist_form.html', controller: 'TargetlistCtrl'});
}]);
