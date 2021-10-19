<!--
Equipo VERDE
Con nuestro grito de guerra ï¿½Vamos Verde!  
Nuestros integrantes son: 
Aranda Figueroa Jose Bryan
Mendoza Reboyo Saul
Mitre Alejandra
León Reyes Rubï¿½n (coordinador)
  -->
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html;
      charset=windows-1252">
    <meta name="Author" content="EQUIPO VERDE">
    <title>Piel Animal</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/home.css">
  </head>
  <body>
  <main class="home__container" >
    <c:set var="pattern" value="${ param.pattern }" />
    <c:if test="${ param.pattern == null }">
      <c:set var="pattern" value="%" />
    </c:if>
    <%--
        String pattern = request.getParameter("pattern");
            if( pattern == null || pattern.equals(""))
                pattern = "%";
            pageContext.setAttribute("pattern",pattern);
    --%>
    <sql:query var="resultados" dataSource="jdbc/TestDS" >
        SELECT * FROM producto WHERE nombre_producto LIKE ? ORDER BY 3;
        <sql:param value="${ pattern }" />
    </sql:query>
    <c:forEach var="fila" items="${ resultados.rows }">
     <form method="post" action="${pageContext.request.contextPath}/ModCar">
      <div class="home__product">
        <img src="${fila.url}" />
        <div class="home__product-details">
          <input  type="hidden" name="id"
                    value="${cantidad.id }"/>
          <p class="home__product-name" > ${fila.nombre_producto} </p>
          <p class="home__product-price" >$ ${fila.precio} </p>
          <button value="add" name="boton" type="submit"> + </button>
        </div>
      </div>
      </form>
    </c:forEach>
  </main>
          
</body>
</html>