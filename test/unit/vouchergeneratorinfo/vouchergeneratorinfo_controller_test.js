'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('vouchergeneratorinfo.module'));
  
  describe('VouchergeneratorinfoCtrl', function(){
    var VouchergeneratorinfoCtrl, Vouchergeneratorinfo,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Vouchergeneratorinfo service
    	Vouchergeneratorinfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'vouchergeneratorinfo1'});
    			return deferred.promise;
    		}
    	};
		
				VouchergeneratorinfoCtrl = $controller('VouchergeneratorinfoCtrl', {
    		'Vouchergeneratorinfo': Vouchergeneratorinfo,
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
    	expect($scope.vouchergeneratorinfo).toBeNull();
    	expect($scope.vouchergeneratorinfos).toBe('vouchergeneratorinfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshVouchergeneratorinfoList', function() {
    	// given
    	Vouchergeneratorinfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'vouchergeneratorinfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshVouchergeneratorinfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.vouchergeneratorinfos).toBe('vouchergeneratorinfo2');
    });
    
    it('refreshVouchergeneratorinfo', function() {
    	// given
    	Vouchergeneratorinfo.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'vouchergeneratorinfo'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshVouchergeneratorinfo('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.vouchergeneratorinfo).toBe('vouchergeneratorinfo'+'1');
    });
    
	it('goToVouchergeneratorinfoList', function() {
    	// given
    	spyOn($scope, "refreshVouchergeneratorinfoList");
    	
    	// when
    	$scope.goToVouchergeneratorinfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshVouchergeneratorinfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/vouchergeneratorinfo');
    });
    
    it('goToVouchergeneratorinfo', function() {
    	// given
    	spyOn($scope, "refreshVouchergeneratorinfo");
    	var uid = 1;
    	
    	// when
    	$scope.goToVouchergeneratorinfo(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshVouchergeneratorinfo).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/vouchergeneratorinfo'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.vouchergeneratorinfo = {uid:'1', name:'vouchergeneratorinfo'};
    	
    	$scope.mode = 'create';
    	Vouchergeneratorinfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'vouchergeneratorinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.vouchergeneratorinfo).toBe('vouchergeneratorinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.vouchergeneratorinfo = {uid:'1', name:'vouchergeneratorinfo'};
    	
    	$scope.mode = 'update';
    	Vouchergeneratorinfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'vouchergeneratorinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.vouchergeneratorinfo).toBe('vouchergeneratorinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Vouchergeneratorinfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToVouchergeneratorinfoList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToVouchergeneratorinfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : vouchergeneratorinfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/vouchergeneratorinfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.vouchergeneratorinfo).toBeNull();
    	expect($scope.vouchergeneratorinfos).toBe('vouchergeneratorinfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});