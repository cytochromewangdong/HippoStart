'use strict';

/* Module for Pointrule */

var pointruleModule = angular.module('pointrule.module', ['myApp']);

/**
 * Module for pointrule
 */
pointruleModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/pointrule',    {templateUrl: 'partials/pointrule/pointrule_list.html', controller: 'PointruleCtrl'});
    $routeProvider.when('/pointrule/new', {templateUrl: 'partials/pointrule/pointrule_form.html', controller: 'PointruleCtrl'});
    $routeProvider.when('/pointrule/:type', {templateUrl: 'partials/pointrule/pointrule_form.html', controller: 'PointruleCtrl'});
}]);
