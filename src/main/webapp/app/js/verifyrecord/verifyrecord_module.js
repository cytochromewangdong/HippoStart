'use strict';

/* Module for Verifyrecord */

var verifyrecordModule = angular.module('verifyrecord.module', ['myApp']);

/**
 * Module for verifyrecord
 */
verifyrecordModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/verifyrecord',    {templateUrl: 'partials/verifyrecord/verifyrecord_list.html', controller: 'VerifyrecordCtrl'});
    $routeProvider.when('/verifyrecord/new', {templateUrl: 'partials/verifyrecord/verifyrecord_form.html', controller: 'VerifyrecordCtrl'});
    $routeProvider.when('/verifyrecord/:uid', {templateUrl: 'partials/verifyrecord/verifyrecord_form.html', controller: 'VerifyrecordCtrl'});
}]);
