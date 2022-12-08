<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/website-shoponline/login/css/globalstyle.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/website-shoponline/login/css/form.css" />
</head>
<body style="background-image: url('${pageContext.request.contextPath}/resources/website-shoponline/login/img/background.jpg'); background-repeat: no-repeat; background-size: cover;">
    <div class="container">

        <form:form modelAttribute="formRequest" action="login" method="post"   >
            <form:input     path="userName"  />
            <form:password  path="password"         />
            <input type="submit" value="acessar"    />
        </form:form>
    </div>
</body>
</html>
