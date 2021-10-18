package uam.mx.azc.verde.pielAnimal.controller;

import java.io.IOException;
import java.sql.*;

import uam.mx.azc.verde.pielAnimal.data.CantidadDTO;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ModCarServlet
 */
@WebServlet(name = "ModCar", urlPatterns = { "/ModCar" })
public class ModCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
		log("Aplicando cambios al carrito de compras///");
		
		String action = request.getParameter( "boton" );
		if("cantidad".equals(action)) {
		  try {
		    update(request, response);
		  }catch(Exception e) {
            throw new ServletException(e);
          }
		  String base = request.getContextPath();
          response.sendRedirect(base + "/CarritoUpdateForm");
		  
		}else if("quitar".equals(action)) {
		  try {
	          delete(request, response);
	       }catch(Exception e) {
	          throw new ServletException(e);
	       }
	        String base = request.getContextPath();
	        response.sendRedirect( base + "/CarritoUpdateForm" );
		  
          } /*
             * else if("add".equals(action)) { try { add(request, response);
             * }catch(Exception e) { throw new ServletException(e); } String
             * base = request.getContextPath(); response.sendRedirect( base +
             * "/CarritoUpdateForm" ); }
             */
	}

  private void add( HttpServletRequest request, HttpServletResponse response )
  {
    //DEfinir el metodo
    
  }

  private void delete( HttpServletRequest request,
      HttpServletResponse response ) throws SQLException, NamingException
  {
    String idProd = request.getParameter("id");
    
    Context context = new InitialContext();
    DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/TestDS");
    
    Connection connection = source.getConnection();
    try {
        deleteCarrito(connection, idProd);
    }finally {
        connection.close();
    }
    
  }

  private void deleteCarrito( Connection connection, String idProd ) throws SQLException
  {
    PreparedStatement statement = 
        connection.prepareStatement( "DELETE FROM carrito WHERE id_producto = ?;" );
    
    try {
      statement.setString( 1, idProd );
      statement.executeUpdate();
      /* Antiguo código
       * statement.executeUpdate("UPDATE carrito SET "
       * +" cantidad_producto = '" + cantidad.getCantidad() +
       * "' WHERE id_producto = '" + cantidad.getId() + "';");
       */
      
      } finally {
        statement.close();
    }
    
  }

  private void update( HttpServletRequest request, HttpServletResponse response ) throws SQLException, NamingException
  {
    String idProd = request.getParameter("id");
    int cantidadProd = Integer.parseInt(request.getParameter("cantidad"));
    CantidadDTO cantidad = new CantidadDTO();
    cantidad.setId( idProd );
    cantidad.setCantidad( cantidadProd );
    
    System.out.print("Cantidad nueva: " + cantidadProd);
    
    Context context = new InitialContext();
    DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/TestDS");
    
    Connection connection = source.getConnection();
    try {
        updateCarrito(connection, cantidad);
    }finally {
        connection.close();
    }
    
  }

  private void updateCarrito( Connection connection, CantidadDTO cantidad ) throws SQLException
  {
    PreparedStatement statement = 
        connection.prepareStatement( "UPDATE carrito SET " + " cantidad_producto = ? WHERE id_producto = ?;" );
    
    try {
      statement.setInt( 1, cantidad.getCantidad() );
      statement.setString( 2, cantidad.getId() );
      statement.executeUpdate();
      /* Antiguo código
       * statement.executeUpdate("UPDATE carrito SET "
       * +" cantidad_producto = '" + cantidad.getCantidad() +
       * "' WHERE id_producto = '" + cantidad.getId() + "';");
       */
      
      } finally {
        statement.close();
    }
    
  }

}
