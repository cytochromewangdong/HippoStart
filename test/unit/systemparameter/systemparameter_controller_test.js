'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('systemparameter.module'));
  
  describe('SystemparameterCtrl', function(){
    var SystemparameterCtrl, Systemparameter,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Systemparameter service
    	Systemparameter = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'systemparameter1'});
    			return deferred.promise;
    		}
    	};
		
				SystemparameterCtrl = $controller('SystemparameterCtrl', {
    		'Systemparameter': Systemparameter,
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
    	expect($scope.systemparameter).toBeNull();
    	expect($scope.systemparameters).toBe('systemparameter1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshSystemparameterList', function() {
    	// given
    	Systemparameter.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'systemparameter2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshSystemparameterList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.systemparameters).toBe('systemparameter2');
    });
    
    it('refreshSystemparameter', function() {
    	// given
    	Systemparameter.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'systemparameter'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshSystemparameter('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.systemparameter).toBe('systemparameter'+'1');
    });
    
	it('goToSystemparameterList', function() {
    	// given
    	spyOn($scope, "refreshSystemparameterList");
    	
    	// when
    	$scope.goToSystemparameterList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshSystemparameterList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/systemparameter');
    });
    
    it('goToSystemparameter', function() {
    	// given
    	spyOn($scope, "refreshSystemparameter");
    	var uid = 1;
    	
    	// when
    	$scope.goToSystemparameter(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshSystemparameter).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/systemparameter'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.systemparameter = {uid:'1', name:'systemparameter'};
    	
    	$scope.mode = 'create';
    	Systemparameter.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'systemparameterSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.systemparameter).toBe('systemparameterSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.systemparameter = {uid:'1', name:'systemparameter'};
    	
    	$scope.mode = 'update';
    	Systemparameter.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'systemparameterSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.systemparameter).toBe('systemparameterSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Systemparameter.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToSystemparameterList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToSystemparameterList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : systemparameter create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/systemparameter/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.systemparameter).toBeNull();
    	expect($scope.systemparameters).toBe('systemparameter1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});