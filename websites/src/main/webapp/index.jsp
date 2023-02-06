<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String env = System.getProperty("_ENV_LOCAL") ;
    switch (env) {
        case "dev" : {
            out.println("<h1>page dev</h1>");
            break;
        }
        case "hom" : {
            out.println("<h1>page hom</h1>");
            break;
        }
        default: {

            response.sendRedirect("/auth");
            break;
        }
    }

%>