'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('promotiondetailinfo.module'));
  
  describe('Promotiondetailinfo', function(){
	var $httpBackend, Promotiondetailinfo, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Promotiondetailinfo = $injector.get('Promotiondetailinfo');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/promotiondetailinfo').respond("test");
    	Promotiondetailinfo.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/promotiondetailinfo').respond("test");
    	Promotiondetailinfo.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/promotiondetailinfo/1/2/3').respond("test");
    	Promotiondetailinfo.get('1', '2', '3').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Promotiondetailinfo.create({uid:null, dishid:null, specificationid:null,name:'promotiondetailinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('promotiondetailinfo.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/promotiondetailinfo').respond("test");
    	Promotiondetailinfo.create({uid:'1', dishid:'2', specificationid:'3',name:'promotiondetailinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Promotiondetailinfo.update({uid:null, dishid:null, specificationid:null,name:'promotiondetailinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('promotiondetailinfo.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/promotiondetailinfo/1/2/3').respond("test");
    	Promotiondetailinfo.update({uid:'1', dishid:'2', specificationid:'3',name:'promotiondetailinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/promotiondetailinfo/1/2/3').respond("test");
    	Promotiondetailinfo.delete('1', '2', '3').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});