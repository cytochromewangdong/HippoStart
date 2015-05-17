'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('dishinfo.module'));
  
  describe('DishinfoCtrl', function(){
    var DishinfoCtrl, Dishinfo, Category, $rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Dishinfo service
    	Dishinfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'dishinfo1'});
    			return deferred.promise;
    		}
    	};
		
				Category = {
			getAllAsListItems: jasmine.createSpy("getAllAsListItems").andCallFake(function() {
				return [];
			})
		};

				DishinfoCtrl = $controller('DishinfoCtrl', {
    		'Dishinfo': Dishinfo,
						'Category': Category,
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
    	expect($scope.dishinfo).toBeNull();
    	expect($scope.dishinfos).toBe('dishinfo1');
    	expect(Object.keys($scope.items).length).toBe(1);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshDishinfoList', function() {
    	// given
    	Dishinfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'dishinfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshDishinfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.dishinfos).toBe('dishinfo2');
    });
    
    it('refreshDishinfo', function() {
    	// given
    	Dishinfo.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'dishinfo'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshDishinfo('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.dishinfo).toBe('dishinfo'+'1');
    });
    
	it('goToDishinfoList', function() {
    	// given
    	spyOn($scope, "refreshDishinfoList");
    	
    	// when
    	$scope.goToDishinfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshDishinfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/dishinfo');
    });
    
    it('goToDishinfo', function() {
    	// given
    	spyOn($scope, "refreshDishinfo");
    	var uid = 1;
    	
    	// when
    	$scope.goToDishinfo(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshDishinfo).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/dishinfo'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.dishinfo = {uid:'1', name:'dishinfo'};
    	
    	$scope.mode = 'create';
    	Dishinfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'dishinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.dishinfo).toBe('dishinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.dishinfo = {uid:'1', name:'dishinfo'};
    	
    	$scope.mode = 'update';
    	Dishinfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'dishinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.dishinfo).toBe('dishinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Dishinfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToDishinfoList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToDishinfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : dishinfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/dishinfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.dishinfo).toBeNull();
    	expect($scope.dishinfos).toBe('dishinfo1');
    	expect(Object.keys($scope.items).length).toBe(1);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});