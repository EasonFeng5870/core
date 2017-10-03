<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html" />
    <script type="application/javascript">
    </script>
</head>
<body>
<div id="msgFromPush">

</div>
<script type="text/javascript" src="<c:url value="assets/js/jquery-3.2.1.js" /> "></script>
<script type="text/javascript">
    var source = new EventSource("push");
    console.log(source);
    var s = "";
    source.addEventListener("message", function(e){
       s += e.data + "<br/>";
       $("#msgFromPush").html(e);
    });

    source.addEventListener("open", function(e){
        console.log("连接打开");
    }, false);

    source.addEventListener("error", function(e){
       if(e.readyState == EventSource.CLOSED) {
           console.log("连接关闭");
       }
       else {
           console.log(e.readyState);
       }
    }, false);
</script>
</body>
</html>