/*
 * Quiz Controller
 */
app.controller('QuizController',function($scope,$window,$rootScope,$location,$route,QuizService){

	$scope.addQuiz=function (){
		QuizService.addQuiz($scope.quiz).then(
				function(response){
					alert('Quiz is added successfully');
					$location.path('/addquiz');
					$route.reload();
				},function(response){

					$rootScope.error=response.data
					if(response.status==401)
						$location.path('/login');
				}	
		)
	}
	
	QuizService.getAllQuesNames().then(function(response){
		$scope.quizz=response.data
	},function(response){
		$rootScope.error=response.data
		if(response.status==401)
			$location.path('/login');
	})
  var counter=0;
    $scope.answers = [ {id:counter, value : ''} ];
   /* $scope.question = { "text": "", 
    		            "quizName":"", 
    		            "answers": [{id:counter, value : ''}],
                        "answerType":"",
                        "correctAnswer": ""
    };*/
    $scope.newItem = function(){
      counter++;
      $scope.answers.push(  { id:counter,value:''} );
  }
  
    $scope.removeUser = function(answer) {
        var index = $scope.answers.indexOf(answer);
        if ($window.confirm("Remove: " + answer.value)) {
        	$scope.answers.splice(index,1);
        }
    }
    
    $scope.addQuestion=function (){
    	if ($window.confirm("Question is going to save")) {
    		QuizService.addQuestion($scope.question).then(
    				function(response){
    					alert('Question is added successfully');
    					$location.path('/addquestion');
    					$route.reload();
    				},function(response){

    					$rootScope.error=response.data
    					if(response.status==401)
    						$location.path('/login');
    				}	
    		)
    	}
	}
  
})