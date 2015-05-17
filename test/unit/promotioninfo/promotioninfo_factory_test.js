'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('promotioninfo.module'));
  
  describe('Promotioninfo', function(){
	var $httpBackend, Promotioninfo, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Promotioninfo = $injector.get('Promotioninfo');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/promotioninfo').respond("test");
    	Promotioninfo.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/promotioninfo').respond("test");
    	Promotioninfo.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/promotioninfo/1').respond("test");
    	Promotioninfo.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Promotioninfo.create({uid:null,name:'promotioninfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('promotioninfo.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/promotioninfo').respond("test");
    	Promotioninfo.create({uid:'1',name:'promotioninfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Promotioninfo.update({uid:null,name:'promotioninfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('promotioninfo.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/promotioninfo/1').respond("test");
    	Promotioninfo.update({uid:'1',name:'promotioninfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/promotioninfo/1').respond("test");
    	Promotioninfo.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});