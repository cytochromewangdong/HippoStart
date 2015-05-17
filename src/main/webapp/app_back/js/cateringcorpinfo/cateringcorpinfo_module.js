'use strict';

/* Module for Cateringcorpinfo */

var cateringcorpinfoModule = angular.module('cateringcorpinfo.module', ['myApp']);

/**
 * Module for cateringcorpinfo
 */
cateringcorpinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/cateringcorpinfo',    {templateUrl: 'partials/cateringcorpinfo/cateringcorpinfo_list.html', controller: 'CateringcorpinfoCtrl'});
    $routeProvider.when('/cateringcorpinfo/new', {templateUrl: 'partials/cateringcorpinfo/cateringcorpinfo_form.html', controller: 'CateringcorpinfoCtrl'});
    $routeProvider.when('/cateringcorpinfo/:uid', {templateUrl: 'partials/cateringcorpinfo/cateringcorpinfo_form.html', controller: 'CateringcorpinfoCtrl'});
}]);
