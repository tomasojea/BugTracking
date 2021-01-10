<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Tickets</title>
    <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
            <div id="header">
                <h2> Tickets from ${projectName}</h2>
            </div>
	</div>
	
	<div id="container">
	
		<div id="content">
                    <table>
                        <tr>
                            <th>User</th>
                            <th>Action</th> 
                        </tr>
                        <c:forEach var="tempTicket" items="${tickets}">
                            <tr>
                                <td> ${tempTicket.user.name} </td>
                            </tr>
                        </c:forEach>
                    </table>
		</div>
            	
        </div>
	

</body>

</html>









