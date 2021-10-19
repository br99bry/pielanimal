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
 * Servlet implementation class agregarCarritoDesdeHome
 */
@WebServlet(name = "agregarCarrito", urlPatterns = { "/agregarCarrito" })
public class agregarCarritoDesdeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       
        	  try { 
        		  update(request, response);
          }catch(Exception e) { 
        	  throw new ServletException(e); 
          } 
        	  String base = request.getContextPath(); 
        	  response.sendRedirect( base + "/indexStore.jsp" );
          
	}

	  private void update( HttpServletRequest request, HttpServletResponse response ) throws SQLException, NamingException
	  {
	    
		  String idProd = request.getParameter("id");
	    Context context = new InitialContext();
	    DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/TestDS");
	    
	    Connection connection = source.getConnection();
	    try {
	        updateCarrito(connection,idProd);
	    }finally {
	        connection.close();
	    }
	    
	  }

	  private void updateCarrito( Connection connection, String idProd ) throws SQLException
	  {
		  
	    /*PreparedStatement statement = 
	        connection.prepareStatement( "SELECT  " + " cantidad_producto = ? WHERE id_producto = ?;" );
	    
	    try {
	      statement.setInt( 1, cantidad.getCantidad() );
	      statement.setString( 2, cantidad.getId() );
	      statement.executeUpdate();
	      
	      
	      } finally {
	        statement.close();
	    }*/
	    
	  }

}
