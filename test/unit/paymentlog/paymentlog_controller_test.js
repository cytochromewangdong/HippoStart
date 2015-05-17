'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('paymentlog.module'));
  
  describe('PaymentlogCtrl', function(){
    var PaymentlogCtrl, Paymentlog,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
    beforeEach(inject(function($injector) {
    	$controller = $injector.get('$controller');
    	$q = $injector.get('$q');
    	$rootScope = $injector.get('$rootScope');
    	$scope = $rootScope.$new();
    	$routeParams = $injector.get('$routeParams');
    	$httpBackend = $injector.get('$httpBackend');
    	
    	// location is mocked due to redirection in browser : karma does not support it
    	$location = {
    		path: jasmine.createSpy("path").andCallFake(function() {
        	    return "";
        	})
    	};
    	
    	// Messages
    	MessageHandler = {
    		cleanMessage: jasmine.createSpy("cleanMessage"),
    		addSuccess: jasmine.createSpy("addSuccess"),
    		manageError: jasmine.createSpy("manageError"),
    		manageException: jasmine.createSpy("manageException"),
    	};

    	// Paymentlog service
    	Paymentlog = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'paymentlog1'});
    			return deferred.promise;
    		}
    	};
		
				PaymentlogCtrl = $controller('PaymentlogCtrl', {
    		'Paymentlog': Paymentlog,
			    		'$scope': $scope,
    		'$routeParams': $routeParams,
    		'$http': $httpBackend,
    		'$location': $location,
    		'MessageHandler': MessageHandler
    	});
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
    it('init', function() {
    	$rootScope.$apply();
    	expect($scope.mode).toBeNull();
    	expect($scope.paymentlog).toBeNull();
    	expect($scope.paymentlogs).toBe('paymentlog1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshPaymentlogList', function() {
    	// given
    	Paymentlog.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'paymentlog2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPaymentlogList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.paymentlogs).toBe('paymentlog2');
    });
    
    it('refreshPaymentlog', function() {
    	// given
    	Paymentlog.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'paymentlog'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPaymentlog('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.paymentlog).toBe('paymentlog'+'1');
    });
    
	it('goToPaymentlogList', function() {
    	// given
    	spyOn($scope, "refreshPaymentlogList");
    	
    	// when
    	$scope.goToPaymentlogList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPaymentlogList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/paymentlog');
    });
    
    it('goToPaymentlog', function() {
    	// given
    	spyOn($scope, "refreshPaymentlog");
    	var uid = 1;
    	
    	// when
    	$scope.goToPaymentlog(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPaymentlog).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/paymentlog'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.paymentlog = {uid:'1', name:'paymentlog'};
    	
    	$scope.mode = 'create';
    	Paymentlog.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'paymentlogSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.paymentlog).toBe('paymentlogSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.paymentlog = {uid:'1', name:'paymentlog'};
    	
    	$scope.mode = 'update';
    	Paymentlog.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'paymentlogSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.paymentlog).toBe('paymentlogSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Paymentlog.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToPaymentlogList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToPaymentlogList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : paymentlog create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/paymentlog/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.paymentlog).toBeNull();
    	expect($scope.paymentlogs).toBe('paymentlog1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});