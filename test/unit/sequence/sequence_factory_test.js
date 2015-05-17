'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('sequence.module'));
  
  describe('Sequence', function(){
	var $httpBackend, Sequence, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Sequence = $injector.get('Sequence');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/sequence').respond("test");
    	Sequence.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/sequence').respond("test");
    	Sequence.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/sequence/1/2').respond("test");
    	Sequence.get('1', '2').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Sequence.create({uid:null, keyword:null,name:'sequence'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('sequence.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/sequence').respond("test");
    	Sequence.create({uid:'1', keyword:'2',name:'sequence'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Sequence.update({uid:null, keyword:null,name:'sequence'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('sequence.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/sequence/1/2').respond("test");
    	Sequence.update({uid:'1', keyword:'2',name:'sequence'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/sequence/1/2').respond("test");
    	Sequence.delete('1', '2').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});