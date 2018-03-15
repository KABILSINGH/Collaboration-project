app.factory('FriendService',function($http){
	var friendService={}
	var BASE_URL="http://localhost:9090/Middleware"
		friendService.getAllSuggestedUsers=function()
		{
				return $http.get(BASE_URL +"/suggestedusers");
	}
	friendService.addFriend=function(toId)
	{ console.log(toId)
		return $http.post(BASE_URL +"/addfriend", toId );
	}
	friendService.getPendingRequests=function()
	{  
		return $http.get(BASE_URL +"/pendingrequests");
	}
	
	return friendService;
})