<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html lang="en">
<head>
    
    <link rel="stylesheet" href="/css/mainStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Muli&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/admin.css">
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zona de adminisracion</title>
</head>
<body>
    <header class="header">
        <img class="header__img" src="images/logo-platzi-video.png" alt="">
    </header>

    <section class="login">
        <section class="login-container">
            <h2>productos</h2>
            <form action="" class="login-container-form">
                <input type="text" class="input" placeholder="Nombre del producto">
                <input type="text" class="input" placeholder="Url Imagen">
                <input type="text" class="input" placeholder="Precio">
                <button class="button">Registrarme</button>
                <a href="${ pageContext.request.contextPath }/index.jsp">Salir</a>
            </form>
        </section>
        <section class="login-container">
            <h2>Ingresa los datos del nuevo producto</h2>
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
              <div class="home__product">
                <img src="${fila.url}" />
                <div class="home__product-details">
                  <p class="home__product-name" > ${fila.nombre_producto} </p>
                  <p class="home__product-price" >$ ${fila.precio} </p>
                </div>
              </div>
            </c:forEach>
        </section>
    </section>

    <footer class="footer">
        <a href="/">Terminos de uso</a>
        <a href="/">Declaración de privacidad</a>
        <a href="/">Centro de ayuda</a>
    </footer>
</body>
</html>