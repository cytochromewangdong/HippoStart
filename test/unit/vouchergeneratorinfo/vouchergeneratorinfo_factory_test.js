'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('vouchergeneratorinfo.module'));
  
  describe('Vouchergeneratorinfo', function(){
	var $httpBackend, Vouchergeneratorinfo, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Vouchergeneratorinfo = $injector.get('Vouchergeneratorinfo');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/vouchergeneratorinfo').respond("test");
    	Vouchergeneratorinfo.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/vouchergeneratorinfo').respond("test");
    	Vouchergeneratorinfo.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/vouchergeneratorinfo/1').respond("test");
    	Vouchergeneratorinfo.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Vouchergeneratorinfo.create({uid:null,name:'vouchergeneratorinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('vouchergeneratorinfo.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/vouchergeneratorinfo').respond("test");
    	Vouchergeneratorinfo.create({uid:'1',name:'vouchergeneratorinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Vouchergeneratorinfo.update({uid:null,name:'vouchergeneratorinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('vouchergeneratorinfo.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/vouchergeneratorinfo/1').respond("test");
    	Vouchergeneratorinfo.update({uid:'1',name:'vouchergeneratorinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/vouchergeneratorinfo/1').respond("test");
    	Vouchergeneratorinfo.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});