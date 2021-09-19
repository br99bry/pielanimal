<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="Author" content="EQUIPO VERDE">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/carrito.css">
    <title>Carrito - Piel Animal</title>
  </head>
  <body>
    <sql:query var="resultados" dataSource="jdbc/TestDS" sql="SELECT c.id_producto,url,nombre_producto, precio, cantidad_producto 
    														FROM producto p INNER JOIN carrito c ON p.id_producto=c.id_producto;" />
    <section class="carrito__wrapper">
      <h2 class="carrito__title" >Carrito de compras</h2>
      <div class="carrito__items-wrapper">
        <div class="carrito__items-head">
          <h4>Producto</h4>
        </div>
        <div class="carrito__items-head">
          <h4>Precio</h4>
        </div>
        <div class="carrito__items-head">
          <h4>Cantidad</h4>
        </div>
        <div class="carrito__items-head">
          <h4>Total</h4>
        </div>
      </div>

      <c:forEach var="fila" items="${resultados.rows }">
      
        <form method="post" action="${pageContext.request.contextPath }/CarritoUpdate"> 
          
          <div class="carrito__items-wrapper carrito-product">
            
            <div class="carrito__items-img-name">
              <img src="${fila.url}" alt="producto">
              <p>${fila.nombre_producto} <%-- <input type="hidden" name="nombre"
  				value="${fila.nombre_producto }"></p> --%>
  			  <p>${fila.id_producto} <input type="hidden" name="id"
  				value="${fila.id_producto }"></p>
            </div>
            
            <div class="carrito__items-precio">
              <p> 
                <span>$</span>
                <i>
                  ${fila.precio} <input type="hidden" name="precio"
  				value="${fila.precio }"> 
                </i>
              </p>
            </div>
            
            <div class="carrito__items-cantidad">
              <div class="carrito__items-cantidad-wrap">
              	<%-- <button type="submit" class="carrito__add-quantity" > + </button>
                <div class="quantity"> ${fila.cantidad_producto} </div> --%>
                
                <input type=number min="1" max="15" value="${ fila.cantidad_producto}" name="cantidad"/>
                <span><input type="submit" value="Modificar" name="cantidad"/></span>
                
                
                <!-- <button type="submit" class="carrito__substract-quantity" > - </button> -->                
              </div>
            </div>
            
            <div class="carrito__items-total">
              <p> 
                <span>$</span>
                <i>
                  
                </i>
              </p>
            </div>
            
          </div>
        </form>
      </c:forEach>

      <div class="carrito__items-wrapper">
        <div class="carrito__items-subtotal">
          <p>Subtotal</p>
        </div>
        <div class="carrito__items-subtotal-value">
          <p>
            <span>$</span>
            <i id="subtotal">
              
            </i>
          </p>
        </div>
      </div>
     <form method="post"
 		action="${pageContext.request.contextPath }"/CarritoForward">
      <div class="carrito__items-wrapper">
        <div class="carrito__items-buy">
          <button type="submit" >Regresar</button>
        </div>
      </div></form>
      
    </section>
    <script src="./js/carrito.js"></script>
  </body>
</html>