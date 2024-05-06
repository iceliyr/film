$(function() {

});

function deleteMember() {
    var email = document.getElementById("email").getAttribute("value");
    $.get("/members/delete",{"email":email},function (){
        alert("删除成功");
        window.location.href="/admin/user";
    });
}
