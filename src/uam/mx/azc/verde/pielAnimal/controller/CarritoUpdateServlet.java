package uam.mx.azc.verde.pielAnimal.controller;

import java.io.IOException;
import java.sql.*;

import uam.mx.azc.verde.pielAnimal.data.CantidadDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CarritoUpdateServlet
 */
@WebServlet(name = "CarritoUpdate", urlPatterns = { "/CarritoUpdate" })
public class CarritoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public CarritoUpdateServlet() {
		// TODO Auto-generated constructor stub
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log("Actualizando cantidad del carrito");
		
		try {
			updateCarrito(request, response);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
		String base = request.getContextPath();
		response.sendRedirect(base + "/CarritoUpdateForm");
		
		
	}

	private void updateCarrito(HttpServletRequest request, HttpServletResponse response) 
	throws NamingException, SQLException{
		
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
		
		//id_producto, url, nombre_producto, precio, cantidad_producto
		// TODO Auto-generated method stub 
		
	}

	private void updateCarrito(Connection connection, CantidadDTO cantidad) throws SQLException {
		//Se manda la instrucción para hacer la modificación en la base de datos
		/*Cambiamos el statement por un PreparedStatement
		Statement statement = connection.createStatement();*/
		
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
		// TODO Auto-generated method stub
		
	}

}
