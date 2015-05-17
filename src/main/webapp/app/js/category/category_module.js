'use strict';

/* Module for Category */

var categoryModule = angular.module('category.module', ['myApp']);

/**
 * Module for category
 */
categoryModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/category',    {templateUrl: 'partials/category/category_list.html', controller: 'CategoryCtrl'});
    $routeProvider.when('/category/new', {templateUrl: 'partials/category/category_form.html', controller: 'CategoryCtrl'});
    $routeProvider.when('/category/:corpid/:uid', {templateUrl: 'partials/category/category_form.html', controller: 'CategoryCtrl'});
}]);
