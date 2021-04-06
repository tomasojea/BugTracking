<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Users</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2> Project's users</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
					
			<table>
				<tr>
					
					<th>Name</th>
                                        <th>Action</th> 
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${users}">
				
					<c:url var="updateLink" value="/user/updateForm">
						<c:param name="userId" value="${tempUser.idUser}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${tempUser.idUser}" />
					</c:url>
					<tr>
						
						<td> ${tempUser.name} </td>
                                                <td>
                                                        <!-- display the update link -->
                                                        <a href="${updateLink}">Update</a>
                                                        |
                                                        <a href="${deleteLink}"
                                                           onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                                                </td>
                                               			
					</tr>
                                                                                       
                                     				         
				</c:forEach>
						
			</table>
				
		</div>
            <table>
                <!-- <c:forEach var="tempUser" items="${Ticket}">
                    <tr><td>${tempUser}<td/> <tr/> 
                </c:forEach>     -->  
                 
            </table>
	</div>
	

</body>

</html>









