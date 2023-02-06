<%@taglib tagdir="/WEB-INF/tags/ecommerce/v1" prefix="page" %>
<%@include file="../../ecommerce/template/v1/import/import_tag.jsp" %>

<page:template_login>

    <div class="container-flex">
        <div class="box">
                 <form>
                     <div class="form-login">
                     <input type="text" placeholder="login" name="userName" class="input-text"/>
                     <input type="password" placeholder="password" name="password" class="input-password"/>
                     <a href="#"  style="width: 163px;" id="id_button" class="button-login"> acessar </a>
                     </div>
                 </form>
        </div>
    </div>


    <script>
        $(document).ready(function () {

            $("#id_button").on("click", function (event) {
                event.preventDefault();
                var data = JSON.stringify($("form").serializeJSON());
                alert(data)
                $.ajax({
                    method: "POST",
                    url: "http://localhost:8080/auth",
                    data: data,
                    contentType: "application/json",
                    dataType:"json",
                    beforeSend: function(response){
                      // alert("first call")
                    },
                    success: function(response){

                        // alert("finish call")
                        // alert(JSON.stringify(response));
                     // $("#id_button").hide();

                    },
                    fail:function(response){
                        // alert("error call")
                    },
                    complete: function (response){
                        // alert("finish call 2")
                        // alert(JSON.stringify(response));
                        window.location.href="/page";
                    }

                });

            });

        });
    </script>
</page:template_login>