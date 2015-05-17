'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('promotioninfo.module'));
  
  describe('PromotioninfoCtrl', function(){
    var PromotioninfoCtrl, Promotioninfo,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Promotioninfo service
    	Promotioninfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'promotioninfo1'});
    			return deferred.promise;
    		}
    	};
		
				PromotioninfoCtrl = $controller('PromotioninfoCtrl', {
    		'Promotioninfo': Promotioninfo,
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
    	expect($scope.promotioninfo).toBeNull();
    	expect($scope.promotioninfos).toBe('promotioninfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshPromotioninfoList', function() {
    	// given
    	Promotioninfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'promotioninfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPromotioninfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.promotioninfos).toBe('promotioninfo2');
    });
    
    it('refreshPromotioninfo', function() {
    	// given
    	Promotioninfo.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'promotioninfo'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPromotioninfo('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.promotioninfo).toBe('promotioninfo'+'1');
    });
    
	it('goToPromotioninfoList', function() {
    	// given
    	spyOn($scope, "refreshPromotioninfoList");
    	
    	// when
    	$scope.goToPromotioninfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPromotioninfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/promotioninfo');
    });
    
    it('goToPromotioninfo', function() {
    	// given
    	spyOn($scope, "refreshPromotioninfo");
    	var uid = 1;
    	
    	// when
    	$scope.goToPromotioninfo(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPromotioninfo).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/promotioninfo'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.promotioninfo = {uid:'1', name:'promotioninfo'};
    	
    	$scope.mode = 'create';
    	Promotioninfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'promotioninfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.promotioninfo).toBe('promotioninfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.promotioninfo = {uid:'1', name:'promotioninfo'};
    	
    	$scope.mode = 'update';
    	Promotioninfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'promotioninfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.promotioninfo).toBe('promotioninfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Promotioninfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToPromotioninfoList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToPromotioninfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : promotioninfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/promotioninfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.promotioninfo).toBeNull();
    	expect($scope.promotioninfos).toBe('promotioninfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});