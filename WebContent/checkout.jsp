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
    <link rel="stylesheet" href="css/home.css">
    <title>Checkout - Piel Animal</title>
    <style>
    body {
    font-family: Arial;
    font-size: 17px;
    padding: 8px;
    }

    * {
    box-sizing: border-box;
    }

    .row {
    display: -ms-flexbox; /* IE10 */
    display: flex;
    -ms-flex-wrap: wrap; /* IE10 */
    flex-wrap: wrap;
    margin: 0 -16px;
    }

    .col-25 {
    -ms-flex: 25%; /* IE10 */
    flex: 25%;
    }

    .col-50 {
    -ms-flex: 50%; /* IE10 */
    flex: 50%;
    }

    .col-75 {
    -ms-flex: 75%; /* IE10 */
    flex: 75%;
    }

    .col-25,
    .col-50,
    .col-75 {
    padding: 0 16px;
    }

    .container {
    background-color: #f2f2f2;
    padding: 5px 20px 15px 20px;
    border: 1px solid lightgrey;
    border-radius: 3px;
    }

    input[type=text] {
    width: 100%;
    margin-bottom: 20px;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 3px;
    }

    label {
    margin-bottom: 10px;
    display: block;
    }

    .icon-container {
    margin-bottom: 20px;
    padding: 7px 0;
    font-size: 24px;
    }

    .btn {
    background-color: #4CAF50;
    color: white;
    padding: 12px;
    margin: 10px 0;
    border: none;
    width: 100%;
    border-radius: 3px;
    cursor: pointer;
    font-size: 17px;
    }

    .btn:hover {
    background-color: #45a049;
    }

    a {
    color: #2196F3;
    }

    hr {
    border: 1px solid lightgrey;
    }

    span.price {
    float: right;
    color: grey;
    }

    
    @media (max-width: 800px) {
    .row {
    flex-direction: column-reverse;
    }
    .col-25 {
    margin-bottom: 20px;
    }
    }
    </style>
  </head>
  <body>
    <h1>Checkout</h1>
    <div class="row">
    <form method="post" action="${pageContext.request.contextPath}/RegistroForm">
  <div class="col-75">
    <div class="container">
      
        
        <div class="row">
          <div class="col-50">
            <h3>Informaci�n de envio</h3>
            <label for="fname"><i class="fa fa-user"></i> Nombre completo</label>
            <input type="text" id="fname" name="firstname" placeholder="nombre">
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder="correo">
            <label for="adr"><i class="fa fa-address-card-o"></i> Direccion</label>
            <input type="text" id="adr" name="address" placeholder="direccion">
            <label for="city"><i class="fa fa-institution"></i> Ciudad</label>
            <input type="text" id="city" name="city" placeholder="Ciudad">

            <div class="row">
              <div class="col-50">
                <label for="state">Estado</label>
                <input type="text" id="state" name="state" placeholder="Estado">
              </div>
              <div class="col-50">
                <label for="zip">Codigo Postal</label>
                <input type="text" id="zip" name="zip" placeholder="CP">
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3>Pago</h3>
            <label for="fname">Tarjetas aceptadas</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Titular de la tarjeta</label>
            <input type="text" id="cname" name="cardname" placeholder="Nombre">
            <label for="ccnum">Numero de tarjeta</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
            <label for="expmonth">Mes de vencimiento</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="Mes">

            <div class="row">
              <div class="col-50">
                <label for="expyear">A�o de vencimiento</label>
                <input type="text" id="expyear" name="expyear" placeholder="A�o">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="CCV">
              </div>
            </div>
          </div>
        </div>
         
         
         
        <label>
          <input type="submit"  name="boton" value="XLS"> Generar reporte en formato XSLX
        </label>
        <label>
          <input type="submit"  name="boton" value="PDF"> Generar reporte en formato PDF
        </label>
        <label>
          <input type="submit"  name="boton" value="HTML"> Generar reporte en formato HTML
        </label>
        <input type="submit" value="Pagar" class="btn">
      
    </div>
  </div>
  
  </form>

  <div class="col-25">
    <div class="container">
      <h4>Resumen de compra
        <span class="price" style="color:black">
          <i class="fa fa-shopping-cart"></i>
          <b>4</b>
        </span>
      </h4>     
      <p><a href="#">Producto 1</a> <span class="price">$15</span></p>
      <p><a href="#">Producto 2</a> <span class="price">$5</span></p>
      <p><a href="#">Producto 3</a> <span class="price">$8</span></p>
      <p><a href="#">Producto 4</a> <span class="price">$2</span></p>
      <hr>
      <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
    </div>
  </div>
</div>
  </body>
</html>