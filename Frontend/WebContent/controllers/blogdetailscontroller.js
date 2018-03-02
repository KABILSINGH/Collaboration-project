/**
 * #/getblog/id
 */
app.controller('BlogDetailsCtrl',function($scope,$rootScope,$location,$sce,BlogService,$routeParams)
		{ var id=$routeParams.id; 
		
		BlogService.getBlog(id).then(
				function(response){
					$scope.blog=response.data
					$scope.content=$sce.trustAsHtml($scope.blog.blogcontent)
				},function(response){
					$rootScope.error=response.data
					if(response.status==401)
						$location.path('/login');
				})
		
	
		})