'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('mediaresource.module'));
  
  describe('Mediaresource', function(){
	var $httpBackend, Mediaresource, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Mediaresource = $injector.get('Mediaresource');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/mediaresource').respond("test");
    	Mediaresource.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/mediaresource').respond("test");
    	Mediaresource.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/mediaresource/1').respond("test");
    	Mediaresource.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Mediaresource.create({uid:null,name:'mediaresource'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('mediaresource.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/mediaresource').respond("test");
    	Mediaresource.create({uid:'1',name:'mediaresource'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Mediaresource.update({uid:null,name:'mediaresource'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('mediaresource.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/mediaresource/1').respond("test");
    	Mediaresource.update({uid:'1',name:'mediaresource'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/mediaresource/1').respond("test");
    	Mediaresource.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});