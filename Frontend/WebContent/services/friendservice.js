app.factory('FriendService',function($http){
	var friendService={}
	var BASE_URL="http://localhost:9090/Middleware"
		friendService.getAllSuggestedUsers=function()
		{
				return $http.get(BASE_URL +"/suggestedusers");
	}
	return friendService;
})