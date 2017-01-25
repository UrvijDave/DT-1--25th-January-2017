<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/menu.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>User Detail</h1>

            <p class="lead">Here is the detail information of the user!
            </p>
        </div>

        <div class="container" ng-app = "cartApp">
            

                <div class="col-md-5">
                    <h3>${user.username}</h3>
                    <p>${user.password}</p>
                    <p>
                       <strong>Manufacturer</strong> : ${user.email}
                    </p>
                    <p>
                        <strong>Category</strong> : ${user.address}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${user.mobile}
                    </p>

                    <br>

                    <!--<c:set var="role" scope="page" value="${param.role}" />
                    <c:set var="url" scope="page" value="/user/userList" />
                    <c:if test="${role='admin'}"> -->
                        <c:set var="url" scope="page" value="/admin/userInventory" />
                    </c:if>

                    <!--<p ng-controller="cartCtrl">
                        <a href="<c:url value="/user/userList/all" />" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large"
                           ng-click="addToCart('${user.userId}')"><span
                                class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                        <a href="<spring:url value="/customer/cart" />"
                           class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                    </p> -->
                </div>
            </div>
        </div>
<br>
<br>
</div>
</div>

<br>
<br>
    <script src="<c:url value="/resources/js/controller.js" /> "></script>
    <!-- Angular JS -->
	<script type="text/javascript" src="<c:url value="/resources/js/angular.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/angular-resource.js"/>"></script>
	
	<script type="text/javascript" src="<c:url value="/resources/js/angular.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/controller.js" />"></script>
    
    <%--Jquery--%>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.min.js"/>"></script>
	