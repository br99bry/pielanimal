package uam.mx.azc.verde.pielAnimal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoForwardServlet
 */
@WebServlet(name = "CarritoForward", urlPatterns = { "/CarritoForward" })
public class CarritoForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	* Default constructor.
	*/
	public CarritoForwardServlet() {
	// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log( "Cambiando de página");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/indexStore.jsp");
		dispatcher.forward(request, response);
	}

}
