<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/menu.jsp"%>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

 <script>
    $(document).ready(function(){

        $('.table').DataTable({
            "lengthMenu": [[1,2,3,5,10,-1], [1,2,3,5,10, "All"]]
        });
    });

</script> 
<!-- <script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script> -->
  <div class="table-responsive">
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Publisher Inventory Page</h1>

            <p class="lead">This is the publisher inventory page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="success">
                <th>Publisher Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Address</th>
                <th>Mobile</th>
                <th>View/Delete/Edit </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${publishers}" var="publisher">
               
                
            <tr >
                    <td>${publisher.publishername}</td>
                    <td>${publisher.password}</td>
                    <td>${publisher.email}</td>
                    <td>${publisher.address}</td>
                   <td>${publisher.mobile}</td>
                   <td><a href="<spring:url value="/publisher/viewPublisher/${publisher.publisherId}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/publisher/deletePublisher/${publisher.publisherId}" />"
                        ><span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/publisher/editPublisher/${publisher.publisherId}" />"
                        ><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>                    
                </tr>
                </c:forEach>
                </tbody>
            
        </table>
        </div>
        </div>
        </div>

