'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function(){
  beforeEach(module('sequence.module'));
  
  describe('SequenceCtrl', function(){
    var SequenceCtrl, Sequence,$rootScope, $scope, $routeParams, $httpBackend, $location, MessageHandler, $q, $controller;
	  
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

    	// Sequence service
    	Sequence = {
    		getAll: function() {
    			var deferred = $q.defer();
    			deferred.resolve({data:'sequence1'});
    			return deferred.promise;
    		}
    	};
		
				SequenceCtrl = $controller('SequenceCtrl', {
    		'Sequence': Sequence,
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
    	expect($scope.sequence).toBeNull();
    	expect($scope.sequences).toBe('sequence1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('refreshSequenceList', function() {
    	// given
    	Sequence.getAll = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'sequence2'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshSequenceList();
    	$scope.$apply();

    	// then
    	$rootScope.$apply();
    	expect($scope.sequences).toBe('sequence2');
    });
    
    it('refreshSequence', function() {
    	// given
    	Sequence.get = function(uid, keyword) {
			var deferred = $q.defer();
			deferred.resolve({data:'sequence'+uid+keyword});
			return deferred.promise;
		}
    	
    	// when
    	$scope.refreshSequence('1', '2');
    	$scope.$apply();
    	
    	// then
    	expect($scope.sequence).toBe('sequence'+'1'+'2');
    });
    
	it('goToSequenceList', function() {
    	// given
    	spyOn($scope, "refreshSequenceList");
    	
    	// when
    	$scope.goToSequenceList();
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshSequenceList).toHaveBeenCalled();
    	expect($location.path).toHaveBeenCalledWith('/sequence');
    });
    
    it('goToSequence', function() {
    	// given
    	spyOn($scope, "refreshSequence");
    	var uid = 1;
    	var keyword = 2;
    	
    	// when
    	$scope.goToSequence(uid, keyword);
    	$scope.$apply();
    	
    	// then
    	expect($scope.refreshSequence).toHaveBeenCalledWith(uid, keyword);
    	expect($location.path).toHaveBeenCalledWith('/sequence'+'/'+uid+'/'+keyword);
    });
    
    it('save : create', function() {
    	// given
    	$scope.sequence = {uid:'1', keyword:'2', name:'sequence'};
    	
    	$scope.mode = 'create';
    	Sequence.create = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'sequenceSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.sequence).toBe('sequenceSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('save : update', function() {
    	// given
    	$scope.sequence = {uid:'1', keyword:'2', name:'sequence'};
    	
    	$scope.mode = 'update';
    	Sequence.update = function() {
			var deferred = $q.defer();
			deferred.resolve({data:'sequenceSaved'});
			return deferred.promise;
		}
    	
    	// when
    	$scope.save();
    	$scope.$apply();
    	
    	// then
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    	expect($scope.sequence).toBe('sequenceSaved');
    	expect(MessageHandler.addSuccess).toHaveBeenCalledWith('save ok');
    });
    
    it('delete', function() {
    	// given
    	Sequence.delete = function() {
			var deferred = $q.defer();
			deferred.resolve(null);
			return deferred.promise;
		}
    	spyOn($scope, "goToSequenceList");
    	
    	// when
    	$scope.delete('1', '2');
    	$scope.$apply();
    	
    	// then
    	expect($scope.goToSequenceList).toHaveBeenCalled();
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
    
    it('init : sequence create page', function() {
    	// given
		$location.path.andCallFake(function() {
        	return "/sequence/new";
       	});

		// when
		$scope.$apply();
		
		// then
    	expect($scope.mode).toBeNull();
    	expect($scope.sequence).toBeNull();
    	expect($scope.sequences).toBe('sequence1');
    	expect(Object.keys($scope.items).length).toBe(0);
    	expect(MessageHandler.cleanMessage).toHaveBeenCalled();
    });
	
  });
});