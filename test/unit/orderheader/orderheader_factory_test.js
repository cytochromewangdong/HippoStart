'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('orderheader.module'));
  
  describe('Orderheader', function(){
	var $httpBackend, Orderheader, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Orderheader = $injector.get('Orderheader');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/orderheader').respond("test");
    	Orderheader.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/orderheader').respond("test");
    	Orderheader.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/orderheader/1').respond("test");
    	Orderheader.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Orderheader.create({uid:null,name:'orderheader'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('orderheader.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/orderheader').respond("test");
    	Orderheader.create({uid:'1',name:'orderheader'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Orderheader.update({uid:null,name:'orderheader'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('orderheader.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/orderheader/1').respond("test");
    	Orderheader.update({uid:'1',name:'orderheader'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/orderheader/1').respond("test");
    	Orderheader.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});