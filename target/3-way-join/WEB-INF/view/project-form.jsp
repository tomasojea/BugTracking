<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form action="saveProject" modelAttribute="project" method="POST">
            <form:hidden path="idproject" />
            <form:input path="projectname" />
            <input type="submit" value="Save" />
        </form:form>
    </body>
</html>
