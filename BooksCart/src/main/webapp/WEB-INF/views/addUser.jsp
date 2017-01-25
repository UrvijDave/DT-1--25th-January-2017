<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/menu.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add User</h1>

            <p class="lead">Fill the below information to add a user:</p>
        </div>

        <form:form action="/BooksCart/admin/addUser" method="post" commandName="user" enctype="multipart/form-data">

        <div class="form-group">
            <label for="username">User Name</label> <form:errors path="username" cssStyle="color: #ff0000;" />
            <form:input path="username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label> <form:errors path="password" cssStyle="color: #ff0000;" />
            <form:input path="password" id="password" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label>  <form:errors path="email" cssStyle="color: #ff0000;" />
            <form:input path="email" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <form:input path="address" id="address" class="form-Control"/>
        </div>
        
        <div class="form-group">
            <label for="mobile">Mobile</label>
            <form:input path="mobile" id="mobile" class="form-Control"/>
        </div>



        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/userInventory" />" class="btn btn-default">Cancel</a>
        </form:form>


