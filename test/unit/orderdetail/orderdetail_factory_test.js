'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('orderdetail.module'));
  
  describe('Orderdetail', function(){
	var $httpBackend, Orderdetail, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Orderdetail = $injector.get('Orderdetail');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/orderdetail').respond("test");
    	Orderdetail.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/orderdetail').respond("test");
    	Orderdetail.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/orderdetail/1/2').respond("test");
    	Orderdetail.get('1', '2').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Orderdetail.create({orderno:null, uid:null,name:'orderdetail'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('orderdetail.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/orderdetail').respond("test");
    	Orderdetail.create({orderno:'1', uid:'2',name:'orderdetail'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Orderdetail.update({orderno:null, uid:null,name:'orderdetail'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('orderdetail.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/orderdetail/1/2').respond("test");
    	Orderdetail.update({orderno:'1', uid:'2',name:'orderdetail'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/orderdetail/1/2').respond("test");
    	Orderdetail.delete('1', '2').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});