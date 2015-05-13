'use strict';

/**
 * Controller for Category
 **/
categoryModule.controller('CategoryCtrl', ['Category',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Category, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of categorys
    $scope.categorys = [];
	// category to edit
    $scope.category = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh categorys list
     */
    $scope.refreshCategoryList = function() {
    	try {
			$scope.categorys = [];
        	Category.getAll().then(
				function(success) {
        	        $scope.categorys = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh category
     */
    $scope.refreshCategory = function(corpid, uid) {
    	try {
        	$scope.category = null;
	        Category.get(corpid, uid).then(
				function(success) {
        	        $scope.category = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the categorys list page
     */
    $scope.goToCategoryList = function() {
        $scope.refreshCategoryList();
        $location.path('/category');
    }
    /**
     * Go to the category edit page
     */
    $scope.goToCategory = function(corpid, uid) {
        $scope.refreshCategory(corpid, uid);
        $location.path('/category/'+corpid+'/'+uid);
    }

    // Actions

    /**
     * Save category
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Category.create;
			} else {
				save = Category.update;
			}
			save($scope.category).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.category = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete category
     */
    $scope.delete = function(corpid, uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Category.delete(corpid, uid).then(
				function(success) {
                	$scope.goToCategoryList();
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
        $scope.category = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.corpid != null && $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshCategory($routeParams.corpid, $routeParams.uid);
    } else {
        // List page
        $scope.refreshCategoryList();
    }
    
    
}]);
