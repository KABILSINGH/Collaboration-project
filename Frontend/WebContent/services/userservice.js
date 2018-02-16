/**
 * UserService
 */
app.factory('UserService',function($http)
{
	var BASE_URL="http://localhost:9090/Middleware"
	var userService={}
	userService.registerUser=function(user)
	{
		console.log(user)
		return $http.post(BASE_URL+ "/registeruser", user)
	}
	
	userService.login=function(user)
	{   console.log('userservice-->login') 
		console.log(user)
		return $http.post(BASE_URL +"/login", user)
	}
	
	userService.logout=function()
	{
		return $http.put(BASE_URL +"/logout")
	}
	/*userService.getUser=function(){
		return $http.get(BASE_URL +"/getuser")
	}
	userService.editUserProfile=function(user){
		return $http.put(BASE_URL +"/edituserprofile",user)
	}*/
	
	return userService;
	})