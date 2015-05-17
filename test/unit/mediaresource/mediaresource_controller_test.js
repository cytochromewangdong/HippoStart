'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('mediaresource.module'));
  
  describe('MediaresourceCtrl', function(){
    var MediaresourceCtrl, Mediaresource,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Mediaresource service
    	Mediaresource = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'mediaresource1'});
    			return deferred.promise;
    		}
    	};
		
				MediaresourceCtrl = $controller('MediaresourceCtrl', {
    		'Mediaresource': Mediaresource,
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
    	expect($scope.mediaresource).toBeNull();
    	expect($scope.mediaresources).toBe('mediaresource1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshMediaresourceList', function() {
    	// given
    	Mediaresource.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'mediaresource2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshMediaresourceList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.mediaresources).toBe('mediaresource2');
    });
    
    it('refreshMediaresource', function() {
    	// given
    	Mediaresource.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'mediaresource'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshMediaresource('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.mediaresource).toBe('mediaresource'+'1');
    });
    
	it('goToMediaresourceList', function() {
    	// given
    	spyOn($scope, "refreshMediaresourceList");
    	
    	// when
    	$scope.goToMediaresourceList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshMediaresourceList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/mediaresource');
    });
    
    it('goToMediaresource', function() {
    	// given
    	spyOn($scope, "refreshMediaresource");
    	var uid = 1;
    	
    	// when
    	$scope.goToMediaresource(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshMediaresource).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/mediaresource'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.mediaresource = {uid:'1', name:'mediaresource'};
    	
    	$scope.mode = 'create';
    	Mediaresource.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'mediaresourceSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.mediaresource).toBe('mediaresourceSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.mediaresource = {uid:'1', name:'mediaresource'};
    	
    	$scope.mode = 'update';
    	Mediaresource.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'mediaresourceSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.mediaresource).toBe('mediaresourceSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Mediaresource.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToMediaresourceList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToMediaresourceList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : mediaresource create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/mediaresource/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.mediaresource).toBeNull();
    	expect($scope.mediaresources).toBe('mediaresource1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});