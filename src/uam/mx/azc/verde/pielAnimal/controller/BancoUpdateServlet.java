package uam.mx.azc.verde.pielAnimal.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BancoUpdateServlet
 */
@WebServlet("/BancoUpdateServlet")
public class BancoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BancoUpdateServlet() {
        // TODO Auto-generated constructor stubsfsdgdgfgdgdgdd
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		log("Actualizando información del Banco");
		
		response.setContentType("text/html");
		Writer writer = response.getWriter();
		writer.write("<html><body><p>¿Como estas?</p></body></html>");
	}

}
