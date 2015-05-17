'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('storeinfo.module'));
  
  describe('StoreinfoCtrl', function(){
    var StoreinfoCtrl, Storeinfo,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Storeinfo service
    	Storeinfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'storeinfo1'});
    			return deferred.promise;
    		}
    	};
		
				StoreinfoCtrl = $controller('StoreinfoCtrl', {
    		'Storeinfo': Storeinfo,
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
    	expect($scope.storeinfo).toBeNull();
    	expect($scope.storeinfos).toBe('storeinfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshStoreinfoList', function() {
    	// given
    	Storeinfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'storeinfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshStoreinfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.storeinfos).toBe('storeinfo2');
    });
    
    it('refreshStoreinfo', function() {
    	// given
    	Storeinfo.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'storeinfo'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshStoreinfo('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.storeinfo).toBe('storeinfo'+'1');
    });
    
	it('goToStoreinfoList', function() {
    	// given
    	spyOn($scope, "refreshStoreinfoList");
    	
    	// when
    	$scope.goToStoreinfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshStoreinfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/storeinfo');
    });
    
    it('goToStoreinfo', function() {
    	// given
    	spyOn($scope, "refreshStoreinfo");
    	var uid = 1;
    	
    	// when
    	$scope.goToStoreinfo(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshStoreinfo).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/storeinfo'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.storeinfo = {uid:'1', name:'storeinfo'};
    	
    	$scope.mode = 'create';
    	Storeinfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'storeinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.storeinfo).toBe('storeinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.storeinfo = {uid:'1', name:'storeinfo'};
    	
    	$scope.mode = 'update';
    	Storeinfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'storeinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.storeinfo).toBe('storeinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Storeinfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToStoreinfoList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToStoreinfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : storeinfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/storeinfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.storeinfo).toBeNull();
    	expect($scope.storeinfos).toBe('storeinfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});