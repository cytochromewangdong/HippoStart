'use strict';

/**
 * Controller for Comboinfo
 **/
comboinfoModule.controller('ComboinfoCtrl', ['Comboinfo',  'Dishinfo', 'Dishspecificationinfo', '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Comboinfo, Dishinfo, Dishspecificationinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	 'Dishinfo',  'Dishspecificationinfo',     // edition mode
    $scope.mode = null;
    
	// list of comboinfos
    $scope.comboinfos = [];
	// comboinfo to edit
    $scope.comboinfo = null;

	// referencies entities
	$scope.items = {};
    // dishinfos
	$scope.items.dishinfos = [];
    // dishspecificationinfos
	$scope.items.dishspecificationinfos = [];

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
		Dishinfo.getAllAsListItems().then(
				function(success) {
        	        $scope.items.dishinfos = success.data;
            	}, 
	            MessageHandler.manageError);
		Dishspecificationinfo.getAllAsListItems().then(
				function(success) {
        	        $scope.items.dishspecificationinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    };
    
    /**
     * Refresh comboinfos list
     */
    $scope.refreshComboinfoList = function() {
    	try {
			$scope.comboinfos = [];
        	Comboinfo.getAll().then(
				function(success) {
        	        $scope.comboinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh comboinfo
     */
    $scope.refreshComboinfo = function(uid, childid, specificationid) {
    	try {
        	$scope.comboinfo = null;
	        Comboinfo.get(uid, childid, specificationid).then(
				function(success) {
        	        $scope.comboinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the comboinfos list page
     */
    $scope.goToComboinfoList = function() {
        $scope.refreshComboinfoList();
        $location.path('/comboinfo');
    }
    /**
     * Go to the comboinfo edit page
     */
    $scope.goToComboinfo = function(uid, childid, specificationid) {
        $scope.refreshComboinfo(uid, childid, specificationid);
        $location.path('/comboinfo/'+uid+'/'+childid+'/'+specificationid);
    }

    // Actions

    /**
     * Save comboinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Comboinfo.create;
			} else {
				save = Comboinfo.update;
			}
			save($scope.comboinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.comboinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete comboinfo
     */
    $scope.delete = function(uid, childid, specificationid) {
	    try {
			MessageHandler.cleanMessage();
    	    Comboinfo.delete(uid, childid, specificationid).then(
				function(success) {
                	$scope.goToComboinfoList();
            	}, 
                MessageHandler.manageError);
        } catch(ex) {
            MessageHandler.manageException(ex);
        }
    };
    
    // Main
	MessageHandler.cleanMessage();
    if( $location.path().endsWith('/new') ) {
        // Creation page
        $scope.comboinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null && $routeParams.childid != null && $routeParams.specificationid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshComboinfo($routeParams.uid, $routeParams.childid, $routeParams.specificationid);
    } else {
        // List page
        $scope.refreshComboinfoList();
    }
    
    
}]);
