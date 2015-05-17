'use strict';

/* Module for Scoreinfo */

var scoreinfoModule = angular.module('scoreinfo.module', ['myApp']);

/**
 * Module for scoreinfo
 */
scoreinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/scoreinfo',    {templateUrl: 'partials/scoreinfo/scoreinfo_list.html', controller: 'ScoreinfoCtrl'});
    $routeProvider.when('/scoreinfo/new', {templateUrl: 'partials/scoreinfo/scoreinfo_form.html', controller: 'ScoreinfoCtrl'});
    $routeProvider.when('/scoreinfo/:uid', {templateUrl: 'partials/scoreinfo/scoreinfo_form.html', controller: 'ScoreinfoCtrl'});
}]);
