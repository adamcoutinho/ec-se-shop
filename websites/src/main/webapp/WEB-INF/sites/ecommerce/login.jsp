<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags/v1" prefix="tag" %>
<tag:login_layout>
    <div style="display: flex; align-items: center; justify-content: center;">
    <div class="card">
        <form id="id_form" style="background: white;">
            <input type="text" class="input-login-text" id="userName" name="userName" placeholder="usuario"/>
            <input type="password" class="input-login-password" id="userPassword" name="userPassword"  placeholder="senha"/>
            <a id="id_btn_login" class="bt-login">acessar</a>
        </form>
    </div>
    <script>
        function convertFormToJSON() {
            const array = $("#id_form").serializeArray(); // Encodes the set of form elements as an array of names and values.
            const json = {};
            $.each(array, function () {
                json[this.name] = this.value || "";
            });
            return json;
        }

        $("#id_btn_login").on("click", function (e) {
            e.preventDefault();
            const json = convertFormToJSON();
            post("/login", JSON.stringify(json), "/home")
        });
    </script>
</tag:login_layout>