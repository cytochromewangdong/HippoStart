'use strict';

/* Module for Promotioninfo */

var promotioninfoModule = angular.module('promotioninfo.module', ['myApp']);

/**
 * Module for promotioninfo
 */
promotioninfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/promotioninfo',    {templateUrl: 'partials/promotioninfo/promotioninfo_list.html', controller: 'PromotioninfoCtrl'});
    $routeProvider.when('/promotioninfo/new', {templateUrl: 'partials/promotioninfo/promotioninfo_form.html', controller: 'PromotioninfoCtrl'});
    $routeProvider.when('/promotioninfo/:uid', {templateUrl: 'partials/promotioninfo/promotioninfo_form.html', controller: 'PromotioninfoCtrl'});
}]);
