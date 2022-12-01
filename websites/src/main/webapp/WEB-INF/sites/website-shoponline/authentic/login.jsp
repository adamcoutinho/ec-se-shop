<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="formRequest" action="login" method="post"   >
    <form:input     path="userName       "  />
    <form:password  path="password"         />
    <input type="submit" value="acessar"    />
</form:form>
</body>
</html>
