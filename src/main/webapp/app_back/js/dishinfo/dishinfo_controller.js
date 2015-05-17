'use strict';

/**
 * Controller for Dishinfo
 **/
dishinfoModule.controller('DishinfoCtrl', ['Dishinfo',  'Category', '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Dishinfo, Category, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	 'Category',     // edition mode
    $scope.mode = null;
    
	// list of dishinfos
    $scope.dishinfos = [];
	// dishinfo to edit
    $scope.dishinfo = null;

	// referencies entities
	$scope.items = {};
    // categorys
	$scope.items.categorys = [];

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
		Category.getAllAsListItems().then(
				function(success) {
        	        $scope.items.categorys = success.data;
            	}, 
	            MessageHandler.manageError);
    };
    
    /**
     * Refresh dishinfos list
     */
    $scope.refreshDishinfoList = function() {
    	try {
			$scope.dishinfos = [];
        	Dishinfo.getAll().then(
				function(success) {
        	        $scope.dishinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh dishinfo
     */
    $scope.refreshDishinfo = function(uid) {
    	try {
        	$scope.dishinfo = null;
	        Dishinfo.get(uid).then(
				function(success) {
        	        $scope.dishinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the dishinfos list page
     */
    $scope.goToDishinfoList = function() {
        $scope.refreshDishinfoList();
        $location.path('/dishinfo');
    }
    /**
     * Go to the dishinfo edit page
     */
    $scope.goToDishinfo = function(uid) {
        $scope.refreshDishinfo(uid);
        $location.path('/dishinfo/'+uid);
    }

    // Actions

    /**
     * Save dishinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Dishinfo.create;
			} else {
				save = Dishinfo.update;
			}
			save($scope.dishinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.dishinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete dishinfo
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Dishinfo.delete(uid).then(
				function(success) {
                	$scope.goToDishinfoList();
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
        $scope.dishinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshDishinfo($routeParams.uid);
    } else {
        // List page
        $scope.refreshDishinfoList();
    }
    
    
}]);
