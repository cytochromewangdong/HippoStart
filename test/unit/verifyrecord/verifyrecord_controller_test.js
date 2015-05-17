'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('verifyrecord.module'));
  
  describe('VerifyrecordCtrl', function(){
    var VerifyrecordCtrl, Verifyrecord,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Verifyrecord service
    	Verifyrecord = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'verifyrecord1'});
    			return deferred.promise;
    		}
    	};
		
				VerifyrecordCtrl = $controller('VerifyrecordCtrl', {
    		'Verifyrecord': Verifyrecord,
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
    	expect($scope.verifyrecord).toBeNull();
    	expect($scope.verifyrecords).toBe('verifyrecord1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshVerifyrecordList', function() {
    	// given
    	Verifyrecord.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'verifyrecord2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshVerifyrecordList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.verifyrecords).toBe('verifyrecord2');
    });
    
    it('refreshVerifyrecord', function() {
    	// given
    	Verifyrecord.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'verifyrecord'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshVerifyrecord('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.verifyrecord).toBe('verifyrecord'+'1');
    });
    
	it('goToVerifyrecordList', function() {
    	// given
    	spyOn($scope, "refreshVerifyrecordList");
    	
    	// when
    	$scope.goToVerifyrecordList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshVerifyrecordList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/verifyrecord');
    });
    
    it('goToVerifyrecord', function() {
    	// given
    	spyOn($scope, "refreshVerifyrecord");
    	var uid = 1;
    	
    	// when
    	$scope.goToVerifyrecord(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshVerifyrecord).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/verifyrecord'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.verifyrecord = {uid:'1', name:'verifyrecord'};
    	
    	$scope.mode = 'create';
    	Verifyrecord.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'verifyrecordSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.verifyrecord).toBe('verifyrecordSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.verifyrecord = {uid:'1', name:'verifyrecord'};
    	
    	$scope.mode = 'update';
    	Verifyrecord.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'verifyrecordSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.verifyrecord).toBe('verifyrecordSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Verifyrecord.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToVerifyrecordList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToVerifyrecordList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : verifyrecord create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/verifyrecord/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.verifyrecord).toBeNull();
    	expect($scope.verifyrecords).toBe('verifyrecord1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});