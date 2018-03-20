/**
 * 
 */
app.controller('ChatCtrl',function($rootScope,$scope,ChatService){
	$scope.stompClient=ChatService.stompClient
	$scope.users=[];
	$scope.chats=[];
	$scope.$on('sockConnected',function(event,frame){
		alert('Successfully Connected with websocket')
		alert('Joined the chat room')
	})
})