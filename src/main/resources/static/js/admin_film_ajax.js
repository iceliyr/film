$(function() {
    // $("#excel").click(function() {
    //     $.get("/admin/excel",{"type":"film"},function (result){
    //     });
    // });

});

function deleteMovie() {
    var movieId = document.getElementById("movie_id").getAttribute("value");
    $.get("/movie/delete",{"movieId":movieId},function (){
        alert("删除成功");
        window.location.href="/admin/film";
    });
}

function editMovie() {
    alert("功能待开发");
}

