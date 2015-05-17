'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('administrator.module'));
  
  describe('AdministratorCtrl', function(){
    var AdministratorCtrl, Administrator,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Administrator service
    	Administrator = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'administrator1'});
    			return deferred.promise;
    		}
    	};
		
				AdministratorCtrl = $controller('AdministratorCtrl', {
    		'Administrator': Administrator,
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
    	expect($scope.administrator).toBeNull();
    	expect($scope.administrators).toBe('administrator1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshAdministratorList', function() {
    	// given
    	Administrator.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'administrator2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshAdministratorList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.administrators).toBe('administrator2');
    });
    
    it('refreshAdministrator', function() {
    	// given
    	Administrator.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'administrator'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshAdministrator('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.administrator).toBe('administrator'+'1');
    });
    
	it('goToAdministratorList', function() {
    	// given
    	spyOn($scope, "refreshAdministratorList");
    	
    	// when
    	$scope.goToAdministratorList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshAdministratorList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/administrator');
    });
    
    it('goToAdministrator', function() {
    	// given
    	spyOn($scope, "refreshAdministrator");
    	var uid = 1;
    	
    	// when
    	$scope.goToAdministrator(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshAdministrator).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/administrator'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.administrator = {uid:'1', name:'administrator'};
    	
    	$scope.mode = 'create';
    	Administrator.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'administratorSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.administrator).toBe('administratorSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.administrator = {uid:'1', name:'administrator'};
    	
    	$scope.mode = 'update';
    	Administrator.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'administratorSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.administrator).toBe('administratorSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Administrator.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToAdministratorList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToAdministratorList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : administrator create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/administrator/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.administrator).toBeNull();
    	expect($scope.administrators).toBe('administrator1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});