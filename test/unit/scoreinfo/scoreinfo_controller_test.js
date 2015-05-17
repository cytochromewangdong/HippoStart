'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('scoreinfo.module'));
  
  describe('ScoreinfoCtrl', function(){
    var ScoreinfoCtrl, Scoreinfo,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Scoreinfo service
    	Scoreinfo = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'scoreinfo1'});
    			return deferred.promise;
    		}
    	};
		
				ScoreinfoCtrl = $controller('ScoreinfoCtrl', {
    		'Scoreinfo': Scoreinfo,
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
    	expect($scope.scoreinfo).toBeNull();
    	expect($scope.scoreinfos).toBe('scoreinfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshScoreinfoList', function() {
    	// given
    	Scoreinfo.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'scoreinfo2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshScoreinfoList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.scoreinfos).toBe('scoreinfo2');
    });
    
    it('refreshScoreinfo', function() {
    	// given
    	Scoreinfo.get = function(uid) {
			var deferred = $q.defer();
			deferred.resolve({data:'scoreinfo'+uid});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshScoreinfo('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.scoreinfo).toBe('scoreinfo'+'1');
    });
    
	it('goToScoreinfoList', function() {
    	// given
    	spyOn($scope, "refreshScoreinfoList");
    	
    	// when
    	$scope.goToScoreinfoList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshScoreinfoList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/scoreinfo');
    });
    
    it('goToScoreinfo', function() {
    	// given
    	spyOn($scope, "refreshScoreinfo");
    	var uid = 1;
    	
    	// when
    	$scope.goToScoreinfo(uid);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshScoreinfo).toHaveBeenCalledWith(uid);
    	expect($location.path).toHaveBeenCalledWith('/scoreinfo'+'/'+uid);
    });
    
    it('save : create', function() {
    	// given
    	$scope.scoreinfo = {uid:'1', name:'scoreinfo'};
    	
    	$scope.mode = 'create';
    	Scoreinfo.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'scoreinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.scoreinfo).toBe('scoreinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.scoreinfo = {uid:'1', name:'scoreinfo'};
    	
    	$scope.mode = 'update';
    	Scoreinfo.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'scoreinfoSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.scoreinfo).toBe('scoreinfoSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Scoreinfo.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToScoreinfoList");
    	
    	// when
    	$scope.delete('1');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToScoreinfoList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : scoreinfo create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/scoreinfo/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.scoreinfo).toBeNull();
    	expect($scope.scoreinfos).toBe('scoreinfo1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});