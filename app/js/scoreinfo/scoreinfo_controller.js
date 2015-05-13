'use strict';

/**
 * Controller for Scoreinfo
 **/
scoreinfoModule.controller('ScoreinfoCtrl', ['Scoreinfo',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Scoreinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of scoreinfos
    $scope.scoreinfos = [];
	// scoreinfo to edit
    $scope.scoreinfo = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh scoreinfos list
     */
    $scope.refreshScoreinfoList = function() {
    	try {
			$scope.scoreinfos = [];
        	Scoreinfo.getAll().then(
				function(success) {
        	        $scope.scoreinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh scoreinfo
     */
    $scope.refreshScoreinfo = function(uid) {
    	try {
        	$scope.scoreinfo = null;
	        Scoreinfo.get(uid).then(
				function(success) {
        	        $scope.scoreinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the scoreinfos list page
     */
    $scope.goToScoreinfoList = function() {
        $scope.refreshScoreinfoList();
        $location.path('/scoreinfo');
    }
    /**
     * Go to the scoreinfo edit page
     */
    $scope.goToScoreinfo = function(uid) {
        $scope.refreshScoreinfo(uid);
        $location.path('/scoreinfo/'+uid);
    }

    // Actions

    /**
     * Save scoreinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Scoreinfo.create;
			} else {
				save = Scoreinfo.update;
			}
			save($scope.scoreinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.scoreinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete scoreinfo
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Scoreinfo.delete(uid).then(
				function(success) {
                	$scope.goToScoreinfoList();
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
        $scope.scoreinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshScoreinfo($routeParams.uid);
    } else {
        // List page
        $scope.refreshScoreinfoList();
    }
    
    
}]);
