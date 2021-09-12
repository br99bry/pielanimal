<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	
	<sql:query var="resultados" dataSource="jdbc/TestDS" sql="SELECT c.id_producto,nombre_producto, precio, cantidad_producto
														 FROM producto p INNER JOIN carrito c ON p.id_producto=c.id_producto;" />
	
  	<!-- funcionalidad con javascript, despues la activo -->
  	<!-- encabezados -->
  	
  	<div class="carrito__items-wrapper carrito-product">
       <c:forEach var="fila" items="${resultados.rows }">
       <form method="post"
  		action="${pageContext.request.contextPath }/CarritoUpdate"> 
  		
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
           
      <%-- <div class="carrito__items-wrapper carrito-product">
       <c:forEach var="fila" items="${resultados.rows }">
       <form method="post"
  		action="${pageContext.request.contextPath }/CarritoUpdate"> --%>
        
        <%-- <table>
        	<tr>
        		<td><div class="carrito__items-img-name">
          			<img src="${fila.url}" />
          			<p>${fila.nombre_producto}</p>
        		</div></td>
        
        		<td>
        			<div class="carrito__items-precio">
          			<p> 
            		<span>$</span>
            		<i>
             		 ${fila.precio}
            		</i>
          			</p>
       			</div></td>
       			
       			<td>
       			<div class="carrito__items-cantidad">
          		<div class="carrito__items-cantidad-wrap">
            		<button type="button" class="carrito__substract-quantity" > - </button>
            		<div class="quantity" > ${fila.cantidad_producto} </div>
            		<button type="button" class="carrito__add-quantity" > + </button>
          		</div>
        		</div></td>
        		
        		<td><div class="carrito__items-total">
          			<p> 
            		<span>$</span>
            		<i>
              
            		</i>
          			</p>
        		</div></td>
        	</tr>
        </table> --%>
        
        <div class="carrito__items-img-name">
          <img src="${fila.url}" />>
          <p>${fila.nombre_producto}</p>
        </div>
        
        <div class="carrito__items-precio">
          <p> 
            <span>$</span>
            <i>
              ${fila.precio}
            </i>
          </p>
        </div>
        
        <div class="carrito__items-cantidad">
          <div class="carrito__items-cantidad-wrap">
            <button type="button" class="carrito__substract-quantity" > - </button>
            <div class="quantity" > ${fila.cantidad_producto} </div>
            <button type="button" class="carrito__add-quantity" > + </button>
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
      
      <!-- <div class="carrito__items-wrapper carrito-product">
        <div class="carrito__items-img-name">
          <img src="./img//blueball.png" alt="producto">
          <p>Mochila</p>
        </div>
        <div class="carrito__items-precio">
          <p> 
            <span>$</span>
            <i>
              100.50 
            </i>
          </p>
        </div>
        <div class="carrito__items-cantidad">
          <div class="carrito__items-cantidad-wrap">
            <button type="button" class="carrito__substract-quantity" > - </button>
            <div class="quantity" > 2 </div>
            <button type="button" class="carrito__add-quantity" > + </button>
          </div>
        </div>
        <div class="carrito__items-total">
          <p> 
            <span>$</span>
            <i>
               
            </i>
          </p>
        </div>
      </div> -->
      
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
      
      <div class="carrito__items-wrapper">
        <div class="carrito__items-buy">
          <button type="button" >Checkout</button>
        </div>
      </div>
      
    </section>
    <script src="./js/carrito.js"></script>
    
  </body>
</html>