'use strict';

/* Module for Sequence */

var sequenceModule = angular.module('sequence.module', ['myApp']);

/**
 * Module for sequence
 */
sequenceModule.config(['$routeProvider', function($routeProvider) {
    // Pages routes
    $routeProvider.when('/sequence',    {templateUrl: 'partials/sequence/sequence_list.html', controller: 'SequenceCtrl'});
    $routeProvider.when('/sequence/new', {templateUrl: 'partials/sequence/sequence_form.html', controller: 'SequenceCtrl'});
    $routeProvider.when('/sequence/:keyword', {templateUrl: 'partials/sequence/sequence_form.html', controller: 'SequenceCtrl'});
}]);
