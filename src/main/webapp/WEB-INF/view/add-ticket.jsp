<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>  User List  </title>
        <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
        <!-- CSS Files -->
        <link href="${pageContext.request.contextPath}/resources/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="${pageContext.request.contextPath}/resources/demo/demo.css" rel="stylesheet" />
    </head>
    <body>
        
      
   <div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
   
      <div class="logo"><a href="http://www.creative-tim.com" class="simple-text logo-normal">
          Bug Tracking
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item  ">
            <a class="nav-link" href="./dashboard.html">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./user.html">
              <i class="material-icons">person</i>
              <p>User Profile</p>
            </a>
          </li>
          <li class="nav-item active ">
            <a class="nav-link" href="./tables.html">
              <i class="material-icons">content_paste</i>
              <p>User List</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./notifications.html">
              <i class="material-icons">notifications</i>
              <p>Notifications</p>
            </a>
          </li>
          </ul>
      </div>
    </div>
    <div class="main-panel">   
       <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title ">User and Projects</h4>
                  <p class="card-category"> Assign users to projects</p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <form:form action="/saveProject" modelAttribute="wrapper" method="POST">
                    <div class="form-group border rounded w-50">
                        <label class="navbar-text">Projects:</label>
                        <form:select  path="projects" cssClass="form-group border rounded w-50">
                            <form:option value="NONE"> --SELECT--</form:option>
                            <form:options items="${projects}" itemValue="idproject" itemLabel="projectname"></form:options>
                        </form:select>  
                    </div>
                    <div class="form-group border rounded w-50">
                        <label class="navbar-text" >Users:</label>
                        <form:select multiple="true" path="tickets" cssClass="form-group border rounded w-50">
                            <form:option value="NONE"> --SELECT--</form:option>
                            <form:options items="${tickets}" itemValue="idticket" itemLabel="idticket"></form:options>
                        </form:select>    
		    </div>
		 <input type="submit" value="Save" class="btn btn-primary" />
		</form:form>
                  </div>
                </div>
              </div>
            </div>
           </div>
        </div>
      </div>
     </div>    
    </div>       
    </body>
</html>
