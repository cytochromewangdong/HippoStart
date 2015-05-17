'use strict';

/* Module for Systemparameter */

var systemparameterModule = angular.module('systemparameter.module', ['myApp']);

/**
 * Module for systemparameter
 */
systemparameterModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/systemparameter',    {templateUrl: 'partials/systemparameter/systemparameter_list.html', controller: 'SystemparameterCtrl'});
    $routeProvider.when('/systemparameter/new', {templateUrl: 'partials/systemparameter/systemparameter_form.html', controller: 'SystemparameterCtrl'});
    $routeProvider.when('/systemparameter/:uid', {templateUrl: 'partials/systemparameter/systemparameter_form.html', controller: 'SystemparameterCtrl'});
}]);
