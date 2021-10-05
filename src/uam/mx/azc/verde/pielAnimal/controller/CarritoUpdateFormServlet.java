package uam.mx.azc.verde.pielAnimal.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import uam.mx.azc.verde.pielAnimal.data.CantidadDTO;

import javax.naming.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CarritoUpdateFormServlet
 */
/**
 * @author Verde
 *
 */
@WebServlet(name = "CarritoUpdateForm", urlPatterns = { "/CarritoUpdateForm" })
public class CarritoUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
		try {
		  List<CantidadDTO> Cantidad = getCantidad();
		  
		  request.setAttribute( "cantidades", Cantidad );
		}catch (Exception e) {
		  throw new ServletException(e);
		}
		RequestDispatcher dispatcher =
		    request.getRequestDispatcher( "/carrito.jsp" );
		    dispatcher.forward( request, response );
	}

  private List<CantidadDTO> getCantidad()
  throws NamingException, SQLException
  {
    Context context = new InitialContext();
    DataSource source = (DataSource)
    context.lookup( "java:comp/env/jdbc/TestDS" );
    
    Connection connection = source.getConnection();
    
    try {
      return getCantidad(connection);
    }finally {
      connection.close();
    }
    
  }

  private List<CantidadDTO> getCantidad( Connection connection )
  throws SQLException
  {
    Statement statement = connection.createStatement();
    
    ResultSet cursor = statement.executeQuery( "SELECT "
        + "c.id_producto,url,nombre_producto, precio, cantidad_producto "
        + "FROM producto p INNER JOIN carrito c ON p.id_producto=c.id_producto "
        + "WHERE c.id_orden=(select id_orden from orden ORDER BY id_orden DESC LIMIT 1)" );
    
    try {
      List<CantidadDTO> cantidades = new ArrayList<CantidadDTO>();
      while(cursor.next()) {
        CantidadDTO cantidad = new CantidadDTO();
        
        cantidad.setId( cursor.getString( 1 ) );
        cantidad.setUrl( cursor.getString( 2 ) );
        cantidad.setNombre( cursor.getString( 3 ) );
        cantidad.setPrecio( cursor.getDouble( 4 ) );
        cantidad.setCantidad( cursor.getInt( 5 ) );
        log("agregando cantidad");
        System.out.println(cantidad);
        cantidades.add( cantidad );
        
      }
      return cantidades;
    }finally {
      cursor.close();
    }
  }

}
