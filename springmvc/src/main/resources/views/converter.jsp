<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html" />
    <script type="application/javascript">
    </script>
</head>
<script type="text/javascript" src="<c:url value="assets/js/jquery-3.2.1.js" /> "></script>
<script type="text/javascript">
    function req() {
        $.ajax({
            url:"convert",
            data:"1-wangyunfei",
            type:"POST",
            contentType:"application/x-wisely",
            success:function(data) {
                $("#resp").html(data);
            }
        });
    }
</script>
<body>
<div id="resp"></div>
<input type="button" onclick="req();" value="请求" />

</body>
</html>