'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('paymentlog.module'));
  
  describe('Paymentlog', function(){
	var $httpBackend, Paymentlog, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Paymentlog = $injector.get('Paymentlog');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/paymentlog').respond("test");
    	Paymentlog.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/paymentlog').respond("test");
    	Paymentlog.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/paymentlog/1').respond("test");
    	Paymentlog.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Paymentlog.create({uid:null,name:'paymentlog'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('paymentlog.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/paymentlog').respond("test");
    	Paymentlog.create({uid:'1',name:'paymentlog'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Paymentlog.update({uid:null,name:'paymentlog'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('paymentlog.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/paymentlog/1').respond("test");
    	Paymentlog.update({uid:'1',name:'paymentlog'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/paymentlog/1').respond("test");
    	Paymentlog.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});