'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('comboinfo.module'));
  
  describe('ComboinfoCtrl', function(){
    var ComboinfoCtrl, Comboinfo, Dishinfo,  Dishspecificationinfo, $rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Comboinfo service
    	Comboinfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'comboinfo1'});
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

				ComboinfoCtrl = $controller('ComboinfoCtrl', {
    		'Comboinfo': Comboinfo,
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
    	expect($scope.comboinfo).toBeNull();
    	expect($scope.comboinfos).toBe('comboinfo1');
    	expect(Object.keys($scope.items).length).toBe(2);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshComboinfoList', function() {
    	// given
    	Comboinfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'comboinfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshComboinfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.comboinfos).toBe('comboinfo2');
    });
    
    it('refreshComboinfo', function() {
    	// given
    	Comboinfo.get = function(id) {
			var deferred = $q.defer();
			deferred.resolve({data:'comboinfo'+id});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshComboinfo('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.comboinfo).toBe('comboinfo'+'1');
    });
    
	it('goToComboinfoList', function() {
    	// given
    	spyOn($scope, "refreshComboinfoList");
    	
    	// when
    	$scope.goToComboinfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshComboinfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/comboinfo');
    });
    
    it('goToComboinfo', function() {
    	// given
    	spyOn($scope, "refreshComboinfo");
    	var id = 1;
    	
    	// when
    	$scope.goToComboinfo(id);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshComboinfo).toHaveBeenCalledWith(id);
    	expect($location.path).toHaveBeenCalledWith('/comboinfo'+'/'+id);
    });
    
    it('save : create', function() {
    	// given
    	$scope.comboinfo = {id:'1', name:'comboinfo'};
    	
    	$scope.mode = 'create';
    	Comboinfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'comboinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.comboinfo).toBe('comboinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.comboinfo = {id:'1', name:'comboinfo'};
    	
    	$scope.mode = 'update';
    	Comboinfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'comboinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.comboinfo).toBe('comboinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Comboinfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToComboinfoList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToComboinfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : comboinfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/comboinfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.comboinfo).toBeNull();
    	expect($scope.comboinfos).toBe('comboinfo1');
    	expect(Object.keys($scope.items).length).toBe(2);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});