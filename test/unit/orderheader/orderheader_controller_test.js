'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('orderheader.module'));
  
  describe('OrderheaderCtrl', function(){
    var OrderheaderCtrl, Orderheader,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Orderheader service
    	Orderheader = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'orderheader1'});
    			return deferred.promise;
    		}
    	};
		
				OrderheaderCtrl = $controller('OrderheaderCtrl', {
    		'Orderheader': Orderheader,
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
    	expect($scope.orderheader).toBeNull();
    	expect($scope.orderheaders).toBe('orderheader1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshOrderheaderList', function() {
    	// given
    	Orderheader.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'orderheader2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshOrderheaderList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.orderheaders).toBe('orderheader2');
    });
    
    it('refreshOrderheader', function() {
    	// given
    	Orderheader.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'orderheader'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshOrderheader('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.orderheader).toBe('orderheader'+'1');
    });
    
	it('goToOrderheaderList', function() {
    	// given
    	spyOn($scope, "refreshOrderheaderList");
    	
    	// when
    	$scope.goToOrderheaderList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshOrderheaderList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/orderheader');
    });
    
    it('goToOrderheader', function() {
    	// given
    	spyOn($scope, "refreshOrderheader");
    	var uid = 1;
    	
    	// when
    	$scope.goToOrderheader(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshOrderheader).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/orderheader'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.orderheader = {uid:'1', name:'orderheader'};
    	
    	$scope.mode = 'create';
    	Orderheader.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'orderheaderSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.orderheader).toBe('orderheaderSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.orderheader = {uid:'1', name:'orderheader'};
    	
    	$scope.mode = 'update';
    	Orderheader.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'orderheaderSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.orderheader).toBe('orderheaderSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Orderheader.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToOrderheaderList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToOrderheaderList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : orderheader create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/orderheader/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.orderheader).toBeNull();
    	expect($scope.orderheaders).toBe('orderheader1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});