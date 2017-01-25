<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/menu.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Publisher</h1>

            <p class="lead">Please update the publisher information here:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/publisher/editPublisher" method="post"
                   commandName="publisher" enctype="multipart/form-data">
        <form:hidden path="publisherId" value="${publisher.publisherId}" />

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="publisherName" id="name" class="form-Control" value="${publisher.publisherName}"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="publisherCategory" id="category"
                                                             value="Books" />Books</label>
            <label class="checkbox-inline"><form:radiobutton path="publisherCategory" id="category"
                                                             value="SC" />Soft Cover</label>
            <label class="checkbox-inline"><form:radiobutton path="publisherCategory" id="category"
                                                             value="HC" /> Hard Cover</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="publisherDescription" id="description" class="form-Control" value="${publisher.publisherDescription}"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="publisherPrice" id="price" class="form-Control" value="${publisher.publisherPrice}"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="publisherCondition" id="condition"
                                                             value="new" />New</label>
            <label class="checkbox-inline"><form:radiobutton path="publisherCondition" id="condition"
                                                             value="used" />INR</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="publisherStatus" id="status"
                                                             value="active" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="publisherStatus" id="status"
                                                             value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="unitInStock" id="unitInStock" class="form-Control" value="${publisher.unitInStock}"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="publisherManufacturer" id="manufacturer" class="form-Control" value="${publisher.publisherManufacturer}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="publisherImage">Upload Picture</label>
            <form:input id="publisherImage" path="publisherImage" type="file" class="form:input-large" />
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/publisherInventory" />" class="btn btn-default">Cancel</a>
        </form:form>


