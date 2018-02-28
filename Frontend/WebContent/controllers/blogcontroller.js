/**
 * BlogCtrl
 */
app.controller('BlogCtrl',function($scope,$rootScope,$location,BlogService){
	$scope.addBlog=function(blog){
		
		BlogService.addBlog(blog).then(
				function(response){
					alert('BlogPost is added successfully and it is waiting for approval..');
					$location.path('/home');
				},function(response){
					
					$rootScope.error=response.data
					if(response.status==401)
						$location.path('/login');
					
				})
				
				
				
	}
	
	
	
})		
