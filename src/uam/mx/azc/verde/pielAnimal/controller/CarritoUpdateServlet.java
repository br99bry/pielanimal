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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log("Actualizando información del carrito");
		
		response.setContentType("text/html");
		
		Writer writer = response.getWriter();
		writer.write("<html><body><h1 style=font-size:300%;>"
				+ "Ups algo salio mal!</h1>"
				+ "<p style=font-size:160%;>Esta herramienta aún no está lista para su uso :(</body></html>");
		// TODO Auto-generated method stub
	}

}
