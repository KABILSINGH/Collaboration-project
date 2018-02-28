/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var BASE_URL="http://localhost:9090/Middleware"
		var blogService={}
	blogService.addBlog=function(blog){
		return $http.post(BASE_URL+"/addblogpost", blog)
	}
	
	return blogService;
	
})
