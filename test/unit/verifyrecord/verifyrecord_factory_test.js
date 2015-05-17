'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('verifyrecord.module'));
  
  describe('Verifyrecord', function(){
	var $httpBackend, Verifyrecord, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Verifyrecord = $injector.get('Verifyrecord');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/verifyrecord').respond("test");
    	Verifyrecord.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/verifyrecord').respond("test");
    	Verifyrecord.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/verifyrecord/1').respond("test");
    	Verifyrecord.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Verifyrecord.create({uid:null,name:'verifyrecord'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('verifyrecord.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/verifyrecord').respond("test");
    	Verifyrecord.create({uid:'1',name:'verifyrecord'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Verifyrecord.update({uid:null,name:'verifyrecord'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('verifyrecord.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/verifyrecord/1').respond("test");
    	Verifyrecord.update({uid:'1',name:'verifyrecord'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/verifyrecord/1').respond("test");
    	Verifyrecord.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});