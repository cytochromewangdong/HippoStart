'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('pointrule.module'));
  
  describe('PointruleCtrl', function(){
    var PointruleCtrl, Pointrule,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Pointrule service
    	Pointrule = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'pointrule1'});
    			return deferred.promise;
    		}
    	};
		
				PointruleCtrl = $controller('PointruleCtrl', {
    		'Pointrule': Pointrule,
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
    	expect($scope.pointrule).toBeNull();
    	expect($scope.pointrules).toBe('pointrule1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshPointruleList', function() {
    	// given
    	Pointrule.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'pointrule2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPointruleList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.pointrules).toBe('pointrule2');
    });
    
    it('refreshPointrule', function() {
    	// given
    	Pointrule.get = function(type) {
			var deferred = $q.defer();
			deferred.resolve({data:'pointrule'+type});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshPointrule('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.pointrule).toBe('pointrule'+'1');
    });
    
	it('goToPointruleList', function() {
    	// given
    	spyOn($scope, "refreshPointruleList");
    	
    	// when
    	$scope.goToPointruleList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPointruleList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/pointrule');
    });
    
    it('goToPointrule', function() {
    	// given
    	spyOn($scope, "refreshPointrule");
    	var type = 1;
    	
    	// when
    	$scope.goToPointrule(type);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshPointrule).toHaveBeenCalledWith(type);
    	expect($location.path).toHaveBeenCalledWith('/pointrule'+'/'+type);
    });
    
    it('save : create', function() {
    	// given
    	$scope.pointrule = {type:'1', name:'pointrule'};
    	
    	$scope.mode = 'create';
    	Pointrule.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'pointruleSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.pointrule).toBe('pointruleSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.pointrule = {type:'1', name:'pointrule'};
    	
    	$scope.mode = 'update';
    	Pointrule.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'pointruleSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.pointrule).toBe('pointruleSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Pointrule.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToPointruleList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToPointruleList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : pointrule create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/pointrule/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.pointrule).toBeNull();
    	expect($scope.pointrules).toBe('pointrule1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});