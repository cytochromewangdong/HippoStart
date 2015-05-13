'use strict';

/* Module for Mediaresource */

var mediaresourceModule = angular.module('mediaresource.module', ['myApp']);

/**
 * Module for mediaresource
 */
mediaresourceModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/mediaresource',    {templateUrl: 'partials/mediaresource/mediaresource_list.html', controller: 'MediaresourceCtrl'});
    $routeProvider.when('/mediaresource/new', {templateUrl: 'partials/mediaresource/mediaresource_form.html', controller: 'MediaresourceCtrl'});
    $routeProvider.when('/mediaresource/:uid', {templateUrl: 'partials/mediaresource/mediaresource_form.html', controller: 'MediaresourceCtrl'});
}]);
