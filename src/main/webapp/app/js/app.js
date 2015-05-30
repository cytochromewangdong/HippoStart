'use strict';

// Add "endsWith" function to the String object
if (typeof String.prototype.endsWith !== 'function') {
    String.prototype.endsWith = function(suffix) {
        return this.indexOf(suffix, this.length - suffix.length) !== -1;
    };
}

// Declare app level module which depends on filters, and services
var myApp = angular.module('myApp', [
   'ngRoute'
  ,'ngResource' 
  ,'ngCookies'
  ,'i18n'
  ,'pascalprecht.translate'
  ,'tmh.dynamicLocale'
  ,'mgcrea.ngStrap.tooltip'
  ,'mgcrea.ngStrap.datepicker'
  ,'myApp.filters'
  ,'myApp.services'
  ,'myApp.directives'
  ,'messageHandler.module'
  ,'adlist.module'
  ,'account.module'
  ,'administrator.module'
  ,'category.module'
  ,'cateringcorpinfo.module'
  ,'comboinfo.module'
  ,'dishprice.module'
  ,'dishspecificationinfo.module'
  ,'externalaccount.module'
  ,'lottoryvoucherinfo.module'
  ,'orderdetail.module'
  ,'orderheader.module'
  ,'payment.module'
  ,'paymentlog.module'
  ,'pointrule.module'
  ,'promotiondetailinfo.module'
  ,'promotioninfo.module'
  ,'scoreinfo.module'
  ,'sequence.module'
  ,'storeinfo.module'
  ,'systemparameter.module'
  ,'targetlist.module'
  ,'uservoucher.module'
  ,'verifyrecord.module'
  ,'vouchergeneratorinfo.module'
]);

/**
 * Main configuration
 */
myApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'partials/welcome.html'});
  $routeProvider.otherwise({redirectTo: '/'});
}]);
