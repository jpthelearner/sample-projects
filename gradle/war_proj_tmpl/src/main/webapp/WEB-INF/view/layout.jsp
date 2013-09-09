<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<style type="text/css" title="currentStyle">
		@import "${contextPath}/resources/css/structure.css";
		@import "${contextPath}/resources/css/matrix360.css";
		@import "${contextPath}/resources/css/jquery.dataTables.css";
		@import "${contextPath}/resources/css/demo_table.css";
	</style>
	<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/jquery.blockUI.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/jquery.dataTables.min.js"></script>	
</head>
<body>
	<div id="pageWrapper">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="menu" />
		<div id="bodyWrap">
			<div id="bodyContent" style="margin:0 auto;">	
			
				<tiles:insertAttribute name="body" />
			</div><!-- bodyContent -->
		</div><!-- bodyWrap -->
		<tiles:insertAttribute name="footer" />
	</div><!-- pageWrapper -->	
</body>
</html>