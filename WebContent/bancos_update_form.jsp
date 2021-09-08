<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html;
      charset=windows-1252">
    <meta name="GENERATOR" content="SeaMonkey/2.40 [en] (Windows; 10;
      Intel(R) Core(TM) i7-4500U CPU @ 1.80GHz 2.40 GHz) [Composer]">
    <meta name="Author" content="Hugo Pablo Leyva">
    <title>Catálogo de Bancos</title>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    <section style="padding: 0 150px" >
    
   
    <div class="step"> Tarjeta guardadas </div>
      <div class="instructions"> Selecciona una tarjeta o da click en agregar </div>
        <br>
        <sql:query var="resultados" dataSource="jdbc/TestDS" sql="SELECT * FROM banco;" />
        <c:forEach var="fila" items="${ resultados.rows }" >
          <form method="post" action="${ pageContext.request.contextPath }/BancoUpdate" >
          <table width="100%">
           <tr class="form" >
             <td align="center">
                <div class="label">Clave</div>
             </td>
             <td align="center">
                <div class="label">Nombre</div>
             </td>
           </tr>
           <tr>
             <td align="center">${ fila.id_banco }<input type="hidden" anme="id" value="${ fila.id_banco }"></td>
             <td align="center">
               <table align="0" cellspacing="0" cellpadding="0" >
               <tr>
               <td><input size="20" name="name_es" value="${ fila.nombre_banco }" >
               </td>
               </tr>
               </table>
               </td>
               <td valing="bottom"><input type="submit" value="Modificar"><input type="submit" value="Borrar"></td>
               </tr>
             </table>
          </form> 
        </c:forEach>
        <form method="post" action="${ pageContextPath }/BancoUpdate" >
          <table width="100%" >
            <tr>
              <!-- <td align="center"><input size="50"></td>  
              <td align="center">
                <table border="0" cellspacing="0" cellpadding="0">
                 <tr>
                 <td>:</td>
                 <td><input size="20"></td> -->
               </tr>
          </table>
          </td>
          <td valing="bottom"  ><input style="margin-bottom: 10px" type="submit" value="Agregar"></td>
         </tr>
         </table>
         <br><input type="button" value="Regresar" onClick="window.location='${ pageContext.request.contextPath }/cliente_update_form.jsp'">
        </form>
        
         </section>
        <br>

</body></html>