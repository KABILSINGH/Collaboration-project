/**
 * JOB SERVICE
 */
app.factory('JobService',function($http)
{
	var BASE_URL="http://localhost:9090/Middleware"
	var JobService={}
	JobService.addJob=function(job){
		console.log(user)
		return $http.post(BASE_URL+ "/addJob", job);
		}
	JobService.getAllJobs=function(){
		
		return $http.get(BASE_URL+ "/allJobs");
		}
	
	 return JobService;
	})