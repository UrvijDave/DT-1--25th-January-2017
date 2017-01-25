<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/menu.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit User</h1>

            <p class="lead">Please update the user information here:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/user/editUser" method="post"
                   commandName="user" enctype="multipart/form-data">
        <form:hidden path="userId" value="${user.userId}" />

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="userName" id="name" class="form-Control" value="${user.userName}"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="userCategory" id="category"
                                                             value="Camera" />Camera</label>
            <label class="checkbox-inline"><form:radiobutton path="userCategory" id="category"
                                                             value="Tablet" />Tablet</label>
            <label class="checkbox-inline"><form:radiobutton path="userCategory" id="category"
                                                             value="EHDD" />External Hard Disk</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="userDescription" id="description" class="form-Control" value="${user.userDescription}"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="userPrice" id="price" class="form-Control" value="${user.userPrice}"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="userCondition" id="condition"
                                                             value="new" />New</label>
            <label class="checkbox-inline"><form:radiobutton path="userCondition" id="condition"
                                                             value="used" />Used</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="userStatus" id="status"
                                                             value="active" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="userStatus" id="status"
                                                             value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="unitInStock" id="unitInStock" class="form-Control" value="${user.unitInStock}"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="userManufacturer" id="manufacturer" class="form-Control" value="${user.userManufacturer}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="userImage">Upload Picture</label>
            <form:input id="userImage" path="userImage" type="file" class="form:input-large" />
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/userInventory" />" class="btn btn-default">Cancel</a>
        </form:form>


