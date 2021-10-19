package uam.mx.azc.verde.pielAnimal.controller;

import java.io.IOException;
import java.sql.*;

import uam.mx.azc.verde.pielAnimal.data.ProductoDTO;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CarritoAddServlet
 */
@WebServlet(name = "CarritoAdd", urlPatterns = { "/CarritoAdd" })
public class CarritoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log("Agregando un producto al carrito de compras");
		
		try {
		  addCarrito(request, response);
		}catch(Exception e) {
		  throw new ServletException(e);
		}
		String base = request.getContextPath();
		response.sendRedirect( base + "/CarritoUpdateForm" );
	}

  private void addCarrito( HttpServletRequest request,
      HttpServletResponse response ) throws NamingException, SQLException
  {
    int id = Integer.parseInt(request.getParameter( "id" ));
    
    ProductoDTO producto = new ProductoDTO();
    
    producto.setId( 0 );
    producto.setIdProducto( id );
    producto.setIdOrden( 1 );
    producto.setCantidad( 1 );
    
    Context context = new InitialContext();
    DataSource source = (DataSource)context.lookup( "java:comp/env/jdbc/TestDS" );
    Connection connection = source.getConnection();
    
    try {
      addCarrito(connection, producto);
    }finally {
      connection.close();
    }
  }

  private void addCarrito( Connection connection, ProductoDTO producto ) throws SQLException
  {
    /*
     * PreparedStatement statement2 = connection.prepareStatement(
     * "SELECT FROM carrito WHERE id_producto = ?" );
     */
    PreparedStatement statement = connection.prepareStatement( "INSERT INTO carrito (id_producto, id_orden, cantidad_producto) VALUES ( ?, ?, ?)" );
    
    try {
      /* statement2.setInt( 1, producto.getIdProducto() ); */
      
      statement.setInt( 1, producto.getIdProducto() );
      statement.setInt( 2, producto.getIdOrden() );
      statement.setInt( 3, producto.getCantidad() );
      statement.executeUpdate();
    }finally {
      statement.close();
    }
  }

}
