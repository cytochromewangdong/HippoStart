'use strict';

/* Module for Externalaccount */

var externalaccountModule = angular.module('externalaccount.module', ['myApp']);

/**
 * Module for externalaccount
 */
externalaccountModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/externalaccount',    {templateUrl: 'partials/externalaccount/externalaccount_list.html', controller: 'ExternalaccountCtrl'});
    $routeProvider.when('/externalaccount/new', {templateUrl: 'partials/externalaccount/externalaccount_form.html', controller: 'ExternalaccountCtrl'});
    $routeProvider.when('/externalaccount/:uid', {templateUrl: 'partials/externalaccount/externalaccount_form.html', controller: 'ExternalaccountCtrl'});
}]);
