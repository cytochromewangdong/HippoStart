'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('promotiondetailinfo.module'));
  
  describe('PromotiondetailinfoCtrl', function(){
    var PromotiondetailinfoCtrl, Promotiondetailinfo, Dishinfo,  Dishspecificationinfo, $rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Promotiondetailinfo service
    	Promotiondetailinfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'promotiondetailinfo1'});
    			return deferred.promise;
    		}
    	};
		
				Dishinfo = {
			getAllAsListItems: jasmine.createSpy("getAllAsListItems").andCallFake(function() {
				return [];
			})
		};

				Dishspecificationinfo = {
			getAllAsListItems: jasmine.createSpy("getAllAsListItems").andCallFake(function() {
				return [];
			})
		};

				PromotiondetailinfoCtrl = $controller('PromotiondetailinfoCtrl', {
    		'Promotiondetailinfo': Promotiondetailinfo,
						'Dishinfo': Dishinfo,
						'Dishspecificationinfo': Dishspecificationinfo,
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
    	expect($scope.promotiondetailinfo).toBeNull();
    	expect($scope.promotiondetailinfos).toBe('promotiondetailinfo1');
    	expect(Object.keys($scope.items).length).toBe(2);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshPromotiondetailinfoList', function() {
    	// given
    	Promotiondetailinfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'promotiondetailinfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPromotiondetailinfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.promotiondetailinfos).toBe('promotiondetailinfo2');
    });
    
    it('refreshPromotiondetailinfo', function() {
    	// given
    	Promotiondetailinfo.get = function(uid, dishid, specificationid) {
			var deferred = $q.defer();
			deferred.resolve({data:'promotiondetailinfo'+uid+dishid+specificationid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPromotiondetailinfo('1', '2', '3');
    	$scope.$apply();
    	
    	// then
    	expect($scope.promotiondetailinfo).toBe('promotiondetailinfo'+'1'+'2'+'3');
    });
    
	it('goToPromotiondetailinfoList', function() {
    	// given
    	spyOn($scope, "refreshPromotiondetailinfoList");
    	
    	// when
    	$scope.goToPromotiondetailinfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPromotiondetailinfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/promotiondetailinfo');
    });
    
    it('goToPromotiondetailinfo', function() {
    	// given
    	spyOn($scope, "refreshPromotiondetailinfo");
    	var uid = 1;
    	var dishid = 2;
    	var specificationid = 3;
    	
    	// when
    	$scope.goToPromotiondetailinfo(uid, dishid, specificationid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPromotiondetailinfo).toHaveBeenCalledWith(uid, dishid, specificationid);
    	expect($location.path).toHaveBeenCalledWith('/promotiondetailinfo'+'/'+uid+'/'+dishid+'/'+specificationid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.promotiondetailinfo = {uid:'1', dishid:'2', specificationid:'3', name:'promotiondetailinfo'};
    	
    	$scope.mode = 'create';
    	Promotiondetailinfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'promotiondetailinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.promotiondetailinfo).toBe('promotiondetailinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.promotiondetailinfo = {uid:'1', dishid:'2', specificationid:'3', name:'promotiondetailinfo'};
    	
    	$scope.mode = 'update';
    	Promotiondetailinfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'promotiondetailinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.promotiondetailinfo).toBe('promotiondetailinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Promotiondetailinfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToPromotiondetailinfoList");
    	
    	// when
    	$scope.delete('1', '2', '3');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToPromotiondetailinfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : promotiondetailinfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/promotiondetailinfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.promotiondetailinfo).toBeNull();
    	expect($scope.promotiondetailinfos).toBe('promotiondetailinfo1');
    	expect(Object.keys($scope.items).length).toBe(2);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});