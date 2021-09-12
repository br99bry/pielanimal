<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
<meta http-equiv="content-type" 
    content="text/html;
      charset=windows-1252">
    <meta name="GENERATOR" 
    content="SeaMonkey/2.40 [en] (Windows; 10;
      Intel(R) Core(TM) i7-4500U CPU @ 1.80GHz 2.40 GHz) [Composer]">
    <meta name="Author" content="Verde">
<title>Carrito</title>
	<link rel="stylesheet" 
    href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>
  	<div class="step">Carrito</div>
  	<div class="intructions">Selecciona los elementos a eliminar</div>
  	<br>
  	
  	<sql:query var="resultados" dataSource="jdbc/TestDS" sql="SELECT *FROM carrito;" />
  	<%--usamos comando query, se declara la variable resultados, definimos cual es el dataSource y 
  	escribimos un comando de sql para mostrar los elementos de la tabla banco --%>
  	
  	<c:forEach var="fila" items="${resultados.rows }">
  	<%--hacemos un for, donde definimos la variable fila, y los itemas serán cada renglon
  	que iteremos --%>
  	<form method="post"
  		action="${pageContext.request.contextPath }/CarritoUpdate">
  	<%--hacemos una petición a BancoUpdate que es mi servlet --%>
  		
  			
  	<table width="100%">
  	<%-- define el 1er renglon --%>
  		<tr class="form"> 
  			<td align="center"> <%-- define alineado de la celda en el renglon tr --%>
  				<div class="label">Clave</div>
  			</td>
  			<td align="center">
  				<div class="label">Nombre</div>
  			</td>
  			<%--deja una celda vacia --%>
  			<td></td>
  		</tr>
  	<%--2do renglón --%>
  		<tr>
  			<td align="center">${fila.id}
  			<input type="hidden" name="id"
  			value="${fila.id }">
  		</td>
  		
  		<td align="center">
  			<table border="0" cellspacing="0"
  			cellpadding="0">
  			<tr>
  			<td><input size="20" name="nombre"
  				value="${fila.nombre_prod }">
  				</td>
  		    </tr>
  		    </table>
  		</td>
  	<%--los renglones anteriores se van a ir iterando por eso se muestran los encabezados repetidos --%>
  	<td valign="bottom"><input type="submit"
  		value="Modificar"><input
  		type="submit" value="Borrar"></td>
  	   </tr>
  	   
  	</table>
    </form>
  </c:forEach>	
  
 <form method="post"
 	action="${pageContext.request.contextPath }/BancoUpdate">
 	<table width="100%">
 		<tr>
 			<%-- <td align="center"><input size="50"></td>
 			<td align="center">
 				<table border="0" cellspacing="0" cellpadding="0">
 					<tr>
 						<td>:</td>
 						<td><input size="20"></td>
 					</tr>
 				</table>
 			</td>--%>
 			<td valign="bottom"><input type="submit"
 				value="Agregar"></td>
 			</tr>
 		</table>
 		
 		<br><input type="button" value="Regresar"
 			onClick="window.location='${pageContext.request.contextPath}/cliente_update_form.jsp'">
 		</form>
 		<br>
 		</body>
</html>