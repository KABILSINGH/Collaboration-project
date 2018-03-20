app.factory('ChatService',function($rootScope){
	var socket=new SockJs("/Middleware/chatmodule")
	var stompClient=Stomp.over(socket);
	stompClient.connect('','',function(frame){
		alert('Connected')
		$rootScope.$broadcast('sockConnected',frame)
	});
	return{
		stompClient:stompClient
	}
})