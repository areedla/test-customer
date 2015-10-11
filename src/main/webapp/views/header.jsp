<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
	<link href="<c:url value='/resources/css/960.css' />" rel="stylesheet" />
    <link href="<c:url value='/resources/css/jquery-ui.css' />" rel="stylesheet" />
    <link href="<c:url value='/resources/css/jquery-ui.structure.css' />" rel="stylesheet" />
    <link href="<c:url value='/resources/css/jquery-ui.theme.css' />" rel="stylesheet" />
    
    <script src="<c:url value='/resources/js/jquery.js' />"></script>
    <script src="<c:url value='/resources/js/jquery-ui.min.js' />"></script>
    
    <link href="<c:url value='/resources/css/main.css' />" rel="stylesheet" />
    <script src="<c:url value='/resources/js/main.js' />"></script>
</head>
