'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('payment.module'));
  
  describe('PaymentCtrl', function(){
    var PaymentCtrl, Payment,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Payment service
    	Payment = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'payment1'});
    			return deferred.promise;
    		}
    	};
		
				PaymentCtrl = $controller('PaymentCtrl', {
    		'Payment': Payment,
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
    	expect($scope.payment).toBeNull();
    	expect($scope.payments).toBe('payment1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshPaymentList', function() {
    	// given
    	Payment.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'payment2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPaymentList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.payments).toBe('payment2');
    });
    
    it('refreshPayment', function() {
    	// given
    	Payment.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'payment'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPayment('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.payment).toBe('payment'+'1');
    });
    
	it('goToPaymentList', function() {
    	// given
    	spyOn($scope, "refreshPaymentList");
    	
    	// when
    	$scope.goToPaymentList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPaymentList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/payment');
    });
    
    it('goToPayment', function() {
    	// given
    	spyOn($scope, "refreshPayment");
    	var uid = 1;
    	
    	// when
    	$scope.goToPayment(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPayment).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/payment'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.payment = {uid:'1', name:'payment'};
    	
    	$scope.mode = 'create';
    	Payment.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'paymentSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.payment).toBe('paymentSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.payment = {uid:'1', name:'payment'};
    	
    	$scope.mode = 'update';
    	Payment.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'paymentSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.payment).toBe('paymentSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Payment.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToPaymentList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToPaymentList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : payment create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/payment/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.payment).toBeNull();
    	expect($scope.payments).toBe('payment1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});