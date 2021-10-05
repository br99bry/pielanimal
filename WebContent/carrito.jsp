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
      
      <!-- se cambian las variables para desplegar la informacion -->
      <c:forEach var="cantidad" items="${cantidades}">
      
        <form method="post" action="${pageContext.request.contextPath }/CarritoUpdate"> 
          
          <div class="carrito__items-wrapper carrito-product">
            
            <div class="carrito__items-img-name">
              <img src="${cantidad.url}" alt="producto">
              <p>${cantidad.nombre} </p> 
  			      <p style="display: none;">${cantidad.id} <input  type="hidden" name="id"
  				    value="${cantidad.id }"></p>
            </div>
            
            <div class="carrito__items-precio">
              <p> 
                <span>$</span>
                <i>
                  ${cantidad.precio} <input type="hidden" name="precio"
  				        value="${cantidad.precio }"> 
                </i>
              </p>
            </div>
            
            <div class="carrito__items-cantidad">
              <div class="carrito__items-cantidad-wrap">
              	<button value="cantidad" name="boton" type="submit" class="carrito__add-quantity" > + </button>
                <input class="quantity" value="${ cantidad.cantidad}" name="cantidad"/>
                <button value="cantidad" name="boton" type="submit" class="carrito__substract-quantity"  > - </button>                
              </div>
            </div>
            
            <div class="carrito__items-total">
              <p> 
                <span>$</span>
                <i>
                  
                </i>
              </p>
              <button name="boton" type="submit" value="quitar" class="carrito__items-delete">
                <span class="fa fa-trash" aria-hidden="true" ></span>
              </button>
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

      <div class="carrito__items-wrapper">
        <div class="carrito__items-buy">
          <a href="./checkout.jsp" >
            <button type="submit" >Checkout</button>
          </a>
        </div>
      </div>
      
    </section>
    <script src="./js/carrito.js"></script>
  </body>
</html>