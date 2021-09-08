<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<html>
<head>
<title><decorator:title default="T�tulo" /></title>
<link rel="stylesheet"
    href="${ pageContext.request.contextPath }/css/style.css">
<decorator:head />
</head>

<body>
    <%@include file="header.jspf" %>
        <decorator:body />
    <%@include file="footer.jspf" %>
    <script src="https://kit.fontawesome.com/288eb97596.js" crossorigin="anonymous"></script>
</body>
</html>

 <!-- 
    Equipo VERDE
Con nuestro grito de guerra �Vamos Verde!  
Nuestros integrantes son: 
Aranda Figueroa Jose Bryan
Mendoza Reboyo Saul
Mitre Alejandra
Le�n Reyes Rub�n (coordinador)
     -->