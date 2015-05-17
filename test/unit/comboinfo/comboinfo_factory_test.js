'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('comboinfo.module'));
  
  describe('Comboinfo', function(){
	var $httpBackend, Comboinfo, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Comboinfo = $injector.get('Comboinfo');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/comboinfo').respond("test");
    	Comboinfo.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/comboinfo').respond("test");
    	Comboinfo.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/comboinfo/1').respond("test");
    	Comboinfo.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Comboinfo.create({id:null,name:'comboinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('comboinfo.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/comboinfo').respond("test");
    	Comboinfo.create({id:'1',name:'comboinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Comboinfo.update({id:null,name:'comboinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('comboinfo.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/comboinfo/1').respond("test");
    	Comboinfo.update({id:'1',name:'comboinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/comboinfo/1').respond("test");
    	Comboinfo.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});