package uam.mx.azc.verde.pielAnimal.controller;

import java.io.IOException;
import java.sql.*;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CarritoDeleteServlet
 */
@WebServlet(name = "CarritoDelete", urlPatterns = { "/CarritoDelete" })
public class CarritoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log("Eliminando elemento del carrito");
		
		try {
		  deleteCarrito(request, response);
		}catch(Exception e) {
		  throw new ServletException(e);
		}
		String base = request.getContextPath();
		response.sendRedirect( base + "/CarritoUpdateForm" );
	}

  private void deleteCarrito( HttpServletRequest request, HttpServletResponse response )
  throws NamingException, SQLException{
    
    String idProd = request.getParameter("id");
    
    Context context = new InitialContext();
    DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/TestDS");
    
    Connection connection = source.getConnection();
    try {
        updateCarrito(connection, idProd);
    }finally {
        connection.close();
    }
    
  }

  private void updateCarrito( Connection connection, String idProd ) throws SQLException
  {
    PreparedStatement statement = 
        connection.prepareStatement( "DELETE FROM carrito" + "WHERE id_producto = ?;" );
    
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

}
