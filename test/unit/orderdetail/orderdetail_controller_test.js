'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('orderdetail.module'));
  
  describe('OrderdetailCtrl', function(){
    var OrderdetailCtrl, Orderdetail,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Orderdetail service
    	Orderdetail = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'orderdetail1'});
    			return deferred.promise;
    		}
    	};
		
				OrderdetailCtrl = $controller('OrderdetailCtrl', {
    		'Orderdetail': Orderdetail,
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
    	expect($scope.orderdetail).toBeNull();
    	expect($scope.orderdetails).toBe('orderdetail1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshOrderdetailList', function() {
    	// given
    	Orderdetail.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'orderdetail2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshOrderdetailList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.orderdetails).toBe('orderdetail2');
    });
    
    it('refreshOrderdetail', function() {
    	// given
    	Orderdetail.get = function(orderno, uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'orderdetail'+orderno+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshOrderdetail('1', '2');
    	$scope.$apply();
    	
    	// then
    	expect($scope.orderdetail).toBe('orderdetail'+'1'+'2');
    });
    
	it('goToOrderdetailList', function() {
    	// given
    	spyOn($scope, "refreshOrderdetailList");
    	
    	// when
    	$scope.goToOrderdetailList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshOrderdetailList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/orderdetail');
    });
    
    it('goToOrderdetail', function() {
    	// given
    	spyOn($scope, "refreshOrderdetail");
    	var orderno = 1;
    	var uid = 2;
    	
    	// when
    	$scope.goToOrderdetail(orderno, uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshOrderdetail).toHaveBeenCalledWith(orderno, uid);
    	expect($location.path).toHaveBeenCalledWith('/orderdetail'+'/'+orderno+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.orderdetail = {orderno:'1', uid:'2', name:'orderdetail'};
    	
    	$scope.mode = 'create';
    	Orderdetail.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'orderdetailSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.orderdetail).toBe('orderdetailSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.orderdetail = {orderno:'1', uid:'2', name:'orderdetail'};
    	
    	$scope.mode = 'update';
    	Orderdetail.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'orderdetailSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.orderdetail).toBe('orderdetailSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Orderdetail.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToOrderdetailList");
    	
    	// when
    	$scope.delete('1', '2');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToOrderdetailList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : orderdetail create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/orderdetail/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.orderdetail).toBeNull();
    	expect($scope.orderdetails).toBe('orderdetail1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});