'use strict';

/* jasmine specs for controllers go here */

describe('services', function(){
  beforeEach(module('pointrule.module'));
  
  describe('Pointrule', function(){
	var $httpBackend, Pointrule, restURL;
	  
    beforeEach(inject(function($injector) {
    	$httpBackend = $injector.get('$httpBackend');
    	Pointrule = $injector.get('Pointrule');
        restURL = $injector.get('restURL');
    }));

    afterEach(function() {
    	$httpBackend.verifyNoOutstandingExpectation();
    	$httpBackend.verifyNoOutstandingRequest();
    });
    
	it('getAllAsListItems', function() {
		$httpBackend.when('GET', restURL+'/items/pointrule').respond("test");
    	Pointrule.getAllAsListItems().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
	});

    it('getAll', function() {
    	$httpBackend.when('GET', restURL+'/pointrule').respond("test");
    	Pointrule.getAll().then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('get', function() {
    	$httpBackend.when('GET', restURL+'/pointrule/1').respond("test");
    	Pointrule.get('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('create throws exception : id not defined', function() {
    	try{
    		Pointrule.create({type:null,name:'pointrule'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('pointrule.id.not.defined');
    	}
    });
    
    it('create', function() {
    	$httpBackend.when('POST', restURL+'/pointrule').respond("test");
    	Pointrule.create({type:'1',name:'pointrule'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('update throws exception : id not defined', function() {
    	try{
    		Pointrule.update({type:null,name:'pointrule'});
    		$httpBackend.flush();
    	} catch(errors) {
    		expect(errors[0]).toBe('pointrule.id.not.defined');
    	}
    });
    
    it('update', function() {
    	$httpBackend.when('PUT', restURL+'/pointrule/1').respond("test");
    	Pointrule.update({type:'1',name:'pointrule'}).then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
    
    it('delete', function() {
    	$httpBackend.when('DELETE', restURL+'/pointrule/1').respond("test");
    	Pointrule.delete('1').then(function(response) {
        	expect(response.status).toBe(200);
    		expect(response.data).toBe("test");
    	});
    	$httpBackend.flush();
    });
  });
});