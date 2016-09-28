<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen"/>
    <title>Error</title>
</head>

<body>
Request from ${pageContext.errorData.requestURI} is failed
<br/>
Servlet name or type: ${pageContext.errorData.servletName}
<br/>
Status code: ${pageContext.errorData.statusCode}
<br/>
Exception: ${pageContext.errorData.throwable}

<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script src="../js/bootstrap.js"></script>
</body>
</html>