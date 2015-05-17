'use strict';

/* Module for Payment */

var paymentModule = angular.module('payment.module', ['myApp']);

/**
 * Module for payment
 */
paymentModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/payment',    {templateUrl: 'partials/payment/payment_list.html', controller: 'PaymentCtrl'});
    $routeProvider.when('/payment/new', {templateUrl: 'partials/payment/payment_form.html', controller: 'PaymentCtrl'});
    $routeProvider.when('/payment/:uid', {templateUrl: 'partials/payment/payment_form.html', controller: 'PaymentCtrl'});
}]);
