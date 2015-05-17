'use strict';

/**
 * Controller for Vouchergeneratorinfo
 **/
vouchergeneratorinfoModule.controller('VouchergeneratorinfoCtrl', ['Vouchergeneratorinfo',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Vouchergeneratorinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of vouchergeneratorinfos
    $scope.vouchergeneratorinfos = [];
	// vouchergeneratorinfo to edit
    $scope.vouchergeneratorinfo = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh vouchergeneratorinfos list
     */
    $scope.refreshVouchergeneratorinfoList = function() {
    	try {
			$scope.vouchergeneratorinfos = [];
        	Vouchergeneratorinfo.getAll().then(
				function(success) {
        	        $scope.vouchergeneratorinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh vouchergeneratorinfo
     */
    $scope.refreshVouchergeneratorinfo = function(uid) {
    	try {
        	$scope.vouchergeneratorinfo = null;
	        Vouchergeneratorinfo.get(uid).then(
				function(success) {
        	        $scope.vouchergeneratorinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the vouchergeneratorinfos list page
     */
    $scope.goToVouchergeneratorinfoList = function() {
        $scope.refreshVouchergeneratorinfoList();
        $location.path('/vouchergeneratorinfo');
    }
    /**
     * Go to the vouchergeneratorinfo edit page
     */
    $scope.goToVouchergeneratorinfo = function(uid) {
        $scope.refreshVouchergeneratorinfo(uid);
        $location.path('/vouchergeneratorinfo/'+uid);
    }

    // Actions

    /**
     * Save vouchergeneratorinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Vouchergeneratorinfo.create;
			} else {
				save = Vouchergeneratorinfo.update;
			}
			save($scope.vouchergeneratorinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.vouchergeneratorinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete vouchergeneratorinfo
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Vouchergeneratorinfo.delete(uid).then(
				function(success) {
                	$scope.goToVouchergeneratorinfoList();
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
        $scope.vouchergeneratorinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshVouchergeneratorinfo($routeParams.uid);
    } else {
        // List page
        $scope.refreshVouchergeneratorinfoList();
    }
    
    
}]);
