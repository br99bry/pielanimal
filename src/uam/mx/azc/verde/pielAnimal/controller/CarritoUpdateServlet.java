package uam.mx.azc.verde.pielAnimal.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String base = request.getContextPath();
		response.sendRedirect(base + "/carrito.jsp");
		
		
	}

}
