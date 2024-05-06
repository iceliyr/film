$(function() {
	$("form").submit(function() {
		var email = $("input[name='email']").val();
		var password = $("input[name='password']").val();
		$.get("/index/doLogin", {
			"email" : email,
			"password" : password
		}, function(result) {
			if(result=="success") {
				alert("登录成功");
				window.location.href = "/index";
			}
			else
				alert("登录失败");
		});
		return false;
	})
})