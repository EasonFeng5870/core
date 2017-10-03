<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html" />
    <script type="application/javascript">
    </script>
</head>
<body>
<script type="text/javascript" src="<c:url value="assets/js/jquery-3.2.1.js" /> "></script>
<script type="text/javascript">
    deferred();
    
    function deferred() {
        $.get('defer', function (data) {
            console.log(data);
            deferred();
        })
    }
</script>
</body>
</html>