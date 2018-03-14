app.controller('FriendCtrl',function($scope,$rootScope,$location,FriendService){
	function getAllSuggestedUsers() {
		FriendService.getAllSuggestedUsers().then(
				function(response){
					$scope.suggestedUsers=response.data
				},function(response){
					$rootScope.error=response.data
					if(response.status==401)
						{
						$location.path('/login')
						}
				})
	}
	getAllSuggestedUsers()
})