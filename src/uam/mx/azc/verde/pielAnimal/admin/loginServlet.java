package uam.mx.azc.verde.pielAnimal.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log("Iniciando sesión");
		
		String n = request.getParameter( "user" );
		String m = request.getParameter( "pwd" );
		
		if(n.equals( "admin" ) && m.equals( "admin" )) {
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/indexStore.jsp");
	      dispatcher.forward(request, response);
		}String base = request.getContextPath();
        response.sendRedirect(base + "/index.jsp");
		
		
		
	  
	}

}
