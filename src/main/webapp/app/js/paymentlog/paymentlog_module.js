'use strict';

/* Module for Paymentlog */

var paymentlogModule = angular.module('paymentlog.module', ['myApp']);

/**
 * Module for paymentlog
 */
paymentlogModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/paymentlog',    {templateUrl: 'partials/paymentlog/paymentlog_list.html', controller: 'PaymentlogCtrl'});
    $routeProvider.when('/paymentlog/new', {templateUrl: 'partials/paymentlog/paymentlog_form.html', controller: 'PaymentlogCtrl'});
    $routeProvider.when('/paymentlog/:uid', {templateUrl: 'partials/paymentlog/paymentlog_form.html', controller: 'PaymentlogCtrl'});
}]);
