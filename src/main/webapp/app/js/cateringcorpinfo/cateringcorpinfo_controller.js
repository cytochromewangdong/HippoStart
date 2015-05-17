'use strict';

/**
 * Controller for Cateringcorpinfo
 **/
cateringcorpinfoModule.controller('CateringcorpinfoCtrl', ['Cateringcorpinfo',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Cateringcorpinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of cateringcorpinfos
    $scope.cateringcorpinfos = [];
	// cateringcorpinfo to edit
    $scope.cateringcorpinfo = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh cateringcorpinfos list
     */
    $scope.refreshCateringcorpinfoList = function() {
    	try {
			$scope.cateringcorpinfos = [];
        	Cateringcorpinfo.getAll().then(
				function(success) {
        	        $scope.cateringcorpinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh cateringcorpinfo
     */
    $scope.refreshCateringcorpinfo = function(uid) {
    	try {
        	$scope.cateringcorpinfo = null;
	        Cateringcorpinfo.get(uid).then(
				function(success) {
        	        $scope.cateringcorpinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the cateringcorpinfos list page
     */
    $scope.goToCateringcorpinfoList = function() {
        $scope.refreshCateringcorpinfoList();
        $location.path('/cateringcorpinfo');
    }
    /**
     * Go to the cateringcorpinfo edit page
     */
    $scope.goToCateringcorpinfo = function(uid) {
        $scope.refreshCateringcorpinfo(uid);
        $location.path('/cateringcorpinfo/'+uid);
    }

    // Actions

    /**
     * Save cateringcorpinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Cateringcorpinfo.create;
			} else {
				save = Cateringcorpinfo.update;
			}
			save($scope.cateringcorpinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.cateringcorpinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete cateringcorpinfo
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Cateringcorpinfo.delete(uid).then(
				function(success) {
                	$scope.goToCateringcorpinfoList();
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
        $scope.cateringcorpinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshCateringcorpinfo($routeParams.uid);
    } else {
        // List page
        $scope.refreshCateringcorpinfoList();
    }
    
    
}]);
