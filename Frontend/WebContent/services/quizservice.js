app.factory('QuizService',function($http){
	var BASE_URL="http://localhost:9090/Middleware"
	var quizService ={}
	
	quizService.addQuiz=function(quiz){
		return $http.post(BASE_URL+"/addquiz", quiz)
	}
	quizService.addQuestion=function(question){
		return $http.post(BASE_URL+"/addQuestion", question)
	}
	quizService.getAllQuesNames=function(){
		return $http.post(BASE_URL+"/getAllQuesNames")
	}
	return quizService;
})
