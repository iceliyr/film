$(function() {

	$("form").submit(function() {
		var id = $("input[name='id']").val();
		var password = $("input[name='password']").val();
		$.post("/admin/doAdminLogin", {
			"id" : id,
			"password" : password
		}, function(result) {
				if(result=="success") {
					alert(result);
					window.location.href = "/admin/user";
				}else {
					alert(result);
				}
		});
		return false;
	})
})
