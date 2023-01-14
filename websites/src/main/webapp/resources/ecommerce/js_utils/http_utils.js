function  post(url, dataObject){
        $.post(url,dataObject,function(data){
                alert("success - 1")
        })  .done(function(){alert("success - 2")})
            .always(function(){

            })
            .fail(function(){

            })
    }

function  post(url, dataObject, urlServlet){
    $.post(url,dataObject,function(data){
        // alert("success - 1")
    })  .done(function(){
        // alert("success - 2")
    })
        .always(function(){
                redirect(urlServlet);
        })
        .fail(function(){

        })
}
