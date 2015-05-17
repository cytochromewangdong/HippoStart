'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('externalaccount.module'));
  
  describe('Externalaccount', function(){
	var $httpBackend, Externalaccount, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Externalaccount = $injector.get('Externalaccount');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/externalaccount').respond("test");
    	Externalaccount.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/externalaccount').respond("test");
    	Externalaccount.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/externalaccount/1/2').respond("test");
    	Externalaccount.get('1', '2').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Externalaccount.create({userid:null, usersource:null,name:'externalaccount'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('externalaccount.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/externalaccount').respond("test");
    	Externalaccount.create({userid:'1', usersource:'2',name:'externalaccount'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Externalaccount.update({userid:null, usersource:null,name:'externalaccount'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('externalaccount.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/externalaccount/1/2').respond("test");
    	Externalaccount.update({userid:'1', usersource:'2',name:'externalaccount'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/externalaccount/1/2').respond("test");
    	Externalaccount.delete('1', '2').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});