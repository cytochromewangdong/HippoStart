'use strict';

/* Module for Promotiondetailinfo */

var promotiondetailinfoModule = angular.module('promotiondetailinfo.module', ['myApp']);

/**
 * Module for promotiondetailinfo
 */
promotiondetailinfoModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/promotiondetailinfo',    {templateUrl: 'partials/promotiondetailinfo/promotiondetailinfo_list.html', controller: 'PromotiondetailinfoCtrl'});
    $routeProvider.when('/promotiondetailinfo/new', {templateUrl: 'partials/promotiondetailinfo/promotiondetailinfo_form.html', controller: 'PromotiondetailinfoCtrl'});
    $routeProvider.when('/promotiondetailinfo/:uid/:dishid/:specificationid', {templateUrl: 'partials/promotiondetailinfo/promotiondetailinfo_form.html', controller: 'PromotiondetailinfoCtrl'});
}]);
