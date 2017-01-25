<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="">
<!--   symbol is not displayed on the browser  -->
<title>BooksCart</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>


	<c:if test="${empty successMsg}">
		<li class="upper-links"><a class="links" href="registration">
				SignUp </a>
	</c:if>
	<c:if test="${empty successMsg }">

		<h1>${successMsg}</h1>
		<c:if test="${showLoginPage}">
			<jsp:include page="login.jsp"></jsp:include>
		</c:if>

		<c:if test="${not empty errorMsg}">
										${errorMsg}

					

			<c:if test="${showPublisherPage}">
				<jsp:include page="publisher.jsp"></jsp:include>
			</c:if>

			<c:if test="${showCategoryPage}">
				<jsp:include page="category.jsp"></jsp:include>
			</c:if>
			<c:if test="${showFictionPage}">
				<jsp:include page="fiction.jsp"></jsp:include>
			</c:if>

			<c:if test="${showSciencePage}">
				<jsp:include page="science.jsp"></jsp:include>
			</c:if>
			
			<c:if test="${showSpiritualPage}">
				<jsp:include page="spiritual.jsp"></jsp:include>
			</c:if>
			<jsp:include page="login.jsp"></jsp:include>
		</c:if>
	</c:if>


</body>
</html>
