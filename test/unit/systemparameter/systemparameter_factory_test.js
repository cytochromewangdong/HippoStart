'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('systemparameter.module'));
  
  describe('Systemparameter', function(){
	var $httpBackend, Systemparameter, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Systemparameter = $injector.get('Systemparameter');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/systemparameter').respond("test");
    	Systemparameter.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/systemparameter').respond("test");
    	Systemparameter.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/systemparameter/1').respond("test");
    	Systemparameter.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Systemparameter.create({uid:null,name:'systemparameter'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('systemparameter.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/systemparameter').respond("test");
    	Systemparameter.create({uid:'1',name:'systemparameter'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Systemparameter.update({uid:null,name:'systemparameter'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('systemparameter.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/systemparameter/1').respond("test");
    	Systemparameter.update({uid:'1',name:'systemparameter'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/systemparameter/1').respond("test");
    	Systemparameter.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});