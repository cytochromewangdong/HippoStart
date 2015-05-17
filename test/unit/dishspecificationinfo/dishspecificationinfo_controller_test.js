'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('dishspecificationinfo.module'));
  
  describe('DishspecificationinfoCtrl', function(){
    var DishspecificationinfoCtrl, Dishspecificationinfo, Dishinfo, $rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Dishspecificationinfo service
    	Dishspecificationinfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'dishspecificationinfo1'});
    			return deferred.promise;
    		}
    	};
		
				Dishinfo = {
			getAllAsListItems: jasmine.createSpy("getAllAsListItems").andCallFake(function() {
				return [];
			})
		};

				DishspecificationinfoCtrl = $controller('DishspecificationinfoCtrl', {
    		'Dishspecificationinfo': Dishspecificationinfo,
						'Dishinfo': Dishinfo,
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
    	expect($scope.dishspecificationinfo).toBeNull();
    	expect($scope.dishspecificationinfos).toBe('dishspecificationinfo1');
    	expect(Object.keys($scope.items).length).toBe(1);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshDishspecificationinfoList', function() {
    	// given
    	Dishspecificationinfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'dishspecificationinfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshDishspecificationinfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.dishspecificationinfos).toBe('dishspecificationinfo2');
    });
    
    it('refreshDishspecificationinfo', function() {
    	// given
    	Dishspecificationinfo.get = function(dishid, uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'dishspecificationinfo'+dishid+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshDishspecificationinfo('1', '2');
    	$scope.$apply();
    	
    	// then
    	expect($scope.dishspecificationinfo).toBe('dishspecificationinfo'+'1'+'2');
    });
    
	it('goToDishspecificationinfoList', function() {
    	// given
    	spyOn($scope, "refreshDishspecificationinfoList");
    	
    	// when
    	$scope.goToDishspecificationinfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshDishspecificationinfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/dishspecificationinfo');
    });
    
    it('goToDishspecificationinfo', function() {
    	// given
    	spyOn($scope, "refreshDishspecificationinfo");
    	var dishid = 1;
    	var uid = 2;
    	
    	// when
    	$scope.goToDishspecificationinfo(dishid, uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshDishspecificationinfo).toHaveBeenCalledWith(dishid, uid);
    	expect($location.path).toHaveBeenCalledWith('/dishspecificationinfo'+'/'+dishid+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.dishspecificationinfo = {dishid:'1', uid:'2', name:'dishspecificationinfo'};
    	
    	$scope.mode = 'create';
    	Dishspecificationinfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'dishspecificationinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.dishspecificationinfo).toBe('dishspecificationinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.dishspecificationinfo = {dishid:'1', uid:'2', name:'dishspecificationinfo'};
    	
    	$scope.mode = 'update';
    	Dishspecificationinfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'dishspecificationinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.dishspecificationinfo).toBe('dishspecificationinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Dishspecificationinfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToDishspecificationinfoList");
    	
    	// when
    	$scope.delete('1', '2');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToDishspecificationinfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : dishspecificationinfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/dishspecificationinfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.dishspecificationinfo).toBeNull();
    	expect($scope.dishspecificationinfos).toBe('dishspecificationinfo1');
    	expect(Object.keys($scope.items).length).toBe(1);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});