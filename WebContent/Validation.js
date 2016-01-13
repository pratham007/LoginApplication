$(document).ready(function() {
	$("#ok").click(function(){
	var email=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var pwd= /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
	var username=$("#uname").val();
	var password=$("#pass").val();

	var p=password.length;
	var u=username.length;
	if(username=="" || password=="")
		{
		alert("Please Fill Username/Password ");
		}	
	else if (!email.test(username)) {
	  alert("Incorrect Email ");
	}
	else if(p<8)
	{
	alert("Password Must Be 8 to 10 Char");
	}
	else if(!pwd.test(password)){
		alert("Password Must Contain Uppercase/Lowercase/Number/Special Symbol");
	}
	
 });
	
	
	 $("#ok").click(function(){
		 var username = $('#uname').val();
		 var password = $('#pass').val();
		    $.ajax(
		    		{
		    			url: "/LOGIN/DBConn",
		    			data : { "username" : username, "password" : password}, 
		    			success: function(result){
		    				if(result == 'success') {
		    					window.location="/LOGIN/home.jsp";
		    				}
		    			}
		    		});
		});
	 
	 
});
