'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('externalaccount.module'));
  
  describe('ExternalaccountCtrl', function(){
    var ExternalaccountCtrl, Externalaccount,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Externalaccount service
    	Externalaccount = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'externalaccount1'});
    			return deferred.promise;
    		}
    	};
		
				ExternalaccountCtrl = $controller('ExternalaccountCtrl', {
    		'Externalaccount': Externalaccount,
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
    	expect($scope.externalaccount).toBeNull();
    	expect($scope.externalaccounts).toBe('externalaccount1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshExternalaccountList', function() {
    	// given
    	Externalaccount.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'externalaccount2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshExternalaccountList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.externalaccounts).toBe('externalaccount2');
    });
    
    it('refreshExternalaccount', function() {
    	// given
    	Externalaccount.get = function(userid, usersource) {
			var deferred = $q.defer();
			deferred.resolve({data:'externalaccount'+userid+usersource});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshExternalaccount('1', '2');
    	$scope.$apply();
    	
    	// then
    	expect($scope.externalaccount).toBe('externalaccount'+'1'+'2');
    });
    
	it('goToExternalaccountList', function() {
    	// given
    	spyOn($scope, "refreshExternalaccountList");
    	
    	// when
    	$scope.goToExternalaccountList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshExternalaccountList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/externalaccount');
    });
    
    it('goToExternalaccount', function() {
    	// given
    	spyOn($scope, "refreshExternalaccount");
    	var userid = 1;
    	var usersource = 2;
    	
    	// when
    	$scope.goToExternalaccount(userid, usersource);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshExternalaccount).toHaveBeenCalledWith(userid, usersource);
    	expect($location.path).toHaveBeenCalledWith('/externalaccount'+'/'+userid+'/'+usersource);
    });
    
    it('save : create', function() {
    	// given
    	$scope.externalaccount = {userid:'1', usersource:'2', name:'externalaccount'};
    	
    	$scope.mode = 'create';
    	Externalaccount.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'externalaccountSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.externalaccount).toBe('externalaccountSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.externalaccount = {userid:'1', usersource:'2', name:'externalaccount'};
    	
    	$scope.mode = 'update';
    	Externalaccount.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'externalaccountSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.externalaccount).toBe('externalaccountSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Externalaccount.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToExternalaccountList");
    	
    	// when
    	$scope.delete('1', '2');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToExternalaccountList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : externalaccount create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/externalaccount/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.externalaccount).toBeNull();
    	expect($scope.externalaccounts).toBe('externalaccount1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});