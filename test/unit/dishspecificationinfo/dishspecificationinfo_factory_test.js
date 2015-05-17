'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('dishspecificationinfo.module'));
  
  describe('Dishspecificationinfo', function(){
	var $httpBackend, Dishspecificationinfo, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Dishspecificationinfo = $injector.get('Dishspecificationinfo');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/dishspecificationinfo').respond("test");
    	Dishspecificationinfo.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/dishspecificationinfo').respond("test");
    	Dishspecificationinfo.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/dishspecificationinfo/1/2').respond("test");
    	Dishspecificationinfo.get('1', '2').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Dishspecificationinfo.create({dishid:null, uid:null,name:'dishspecificationinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('dishspecificationinfo.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/dishspecificationinfo').respond("test");
    	Dishspecificationinfo.create({dishid:'1', uid:'2',name:'dishspecificationinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Dishspecificationinfo.update({dishid:null, uid:null,name:'dishspecificationinfo'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('dishspecificationinfo.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/dishspecificationinfo/1/2').respond("test");
    	Dishspecificationinfo.update({dishid:'1', uid:'2',name:'dishspecificationinfo'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/dishspecificationinfo/1/2').respond("test");
    	Dishspecificationinfo.delete('1', '2').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});