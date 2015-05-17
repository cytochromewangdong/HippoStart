'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('storeinfo.module'));
  
  describe('Storeinfo', function(){
	var $httpBackend, Storeinfo, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Storeinfo = $injector.get('Storeinfo');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/storeinfo').respond("test");
    	Storeinfo.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/storeinfo').respond("test");
    	Storeinfo.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/storeinfo/1').respond("test");
    	Storeinfo.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Storeinfo.create({uid:null,name:'storeinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('storeinfo.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/storeinfo').respond("test");
    	Storeinfo.create({uid:'1',name:'storeinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Storeinfo.update({uid:null,name:'storeinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('storeinfo.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/storeinfo/1').respond("test");
    	Storeinfo.update({uid:'1',name:'storeinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/storeinfo/1').respond("test");
    	Storeinfo.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});