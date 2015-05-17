'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('cateringcorpinfo.module'));
  
  describe('CateringcorpinfoCtrl', function(){
    var CateringcorpinfoCtrl, Cateringcorpinfo,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Cateringcorpinfo service
    	Cateringcorpinfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'cateringcorpinfo1'});
    			return deferred.promise;
    		}
    	};
		
				CateringcorpinfoCtrl = $controller('CateringcorpinfoCtrl', {
    		'Cateringcorpinfo': Cateringcorpinfo,
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
    	expect($scope.cateringcorpinfo).toBeNull();
    	expect($scope.cateringcorpinfos).toBe('cateringcorpinfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshCateringcorpinfoList', function() {
    	// given
    	Cateringcorpinfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'cateringcorpinfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshCateringcorpinfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.cateringcorpinfos).toBe('cateringcorpinfo2');
    });
    
    it('refreshCateringcorpinfo', function() {
    	// given
    	Cateringcorpinfo.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'cateringcorpinfo'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshCateringcorpinfo('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.cateringcorpinfo).toBe('cateringcorpinfo'+'1');
    });
    
	it('goToCateringcorpinfoList', function() {
    	// given
    	spyOn($scope, "refreshCateringcorpinfoList");
    	
    	// when
    	$scope.goToCateringcorpinfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshCateringcorpinfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/cateringcorpinfo');
    });
    
    it('goToCateringcorpinfo', function() {
    	// given
    	spyOn($scope, "refreshCateringcorpinfo");
    	var uid = 1;
    	
    	// when
    	$scope.goToCateringcorpinfo(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshCateringcorpinfo).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/cateringcorpinfo'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.cateringcorpinfo = {uid:'1', name:'cateringcorpinfo'};
    	
    	$scope.mode = 'create';
    	Cateringcorpinfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'cateringcorpinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.cateringcorpinfo).toBe('cateringcorpinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.cateringcorpinfo = {uid:'1', name:'cateringcorpinfo'};
    	
    	$scope.mode = 'update';
    	Cateringcorpinfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'cateringcorpinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.cateringcorpinfo).toBe('cateringcorpinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Cateringcorpinfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToCateringcorpinfoList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToCateringcorpinfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : cateringcorpinfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/cateringcorpinfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.cateringcorpinfo).toBeNull();
    	expect($scope.cateringcorpinfos).toBe('cateringcorpinfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});