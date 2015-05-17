'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('scoreinfo.module'));
  
  describe('Scoreinfo', function(){
	var $httpBackend, Scoreinfo, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Scoreinfo = $injector.get('Scoreinfo');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/scoreinfo').respond("test");
    	Scoreinfo.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/scoreinfo').respond("test");
    	Scoreinfo.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/scoreinfo/1').respond("test");
    	Scoreinfo.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Scoreinfo.create({uid:null,name:'scoreinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('scoreinfo.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/scoreinfo').respond("test");
    	Scoreinfo.create({uid:'1',name:'scoreinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Scoreinfo.update({uid:null,name:'scoreinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('scoreinfo.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/scoreinfo/1').respond("test");
    	Scoreinfo.update({uid:'1',name:'scoreinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/scoreinfo/1').respond("test");
    	Scoreinfo.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});