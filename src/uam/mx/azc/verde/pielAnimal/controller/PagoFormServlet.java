package uam.mx.azc.verde.pielAnimal.controller;

import java.awt.Color;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import uam.mx.azc.verde.pielAnimal.data.PagoDTO;

import com.lowagie.text.*;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.PdfWriter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.naming.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PagoFormServlet
 */


/**
 * @author 
 * Equipo Verde
 *
 */
@WebServlet(name = "RegistroForm", urlPatterns = { "/RegistroForm" })
public class PagoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PagoFormServlet() {

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String accion = request.getParameter("boton");
		if(accion.equals("PDF")) {
			try {
				GenerarPDF(request, response);
				log("Generando PDF");
			} catch(Exception e) {
				log("No se puede Generar PDF");
			}
		} else if(accion.equals("HTML")) {
			try {
				GenerarHTML(request, response);
				log("Generando HTML");
			} catch(Exception e) {
				log("No se puede Generar HTML");
			}
		}else if(accion.equals("XLS")) {
			try {
				GenerarXLS(request, response);
				log("Generando XLS");
			} catch(Exception e) {
				log("No se puede Generar XLS");
			}
		}
		//String base = request.getContextPath();
		//response.sendRedirect(base + "/main.jsp");	
		
	}

	private void GenerarPDF(HttpServletRequest request, HttpServletResponse response)
		throws NamingException, SQLException, ParsePropertyException, IOException, ServletException {
		PagoDTO pago = getPago(request);		
		try {
			documentShowPDF(pago,response);
		} finally {
			
		}
	}
	
	private void GenerarHTML(HttpServletRequest request, HttpServletResponse response)
			throws NamingException, SQLException, ParsePropertyException, IOException, ServletException {
			PagoDTO pago = getPago(request);		
			try {
				documentShowHTML(pago,response);
			} finally {
				
			}
	}


	private PagoDTO getPago(HttpServletRequest request) {
		String Nombre = request.getParameter("firstname");
		String email = request.getParameter("email");
		String Direccion = request.getParameter("address");
		String Ciudad = request.getParameter("city");
		String Estado = request.getParameter("state");
		String Codigo = request.getParameter("zip");
		
		String TarjetaNombre = request.getParameter("cardname");
		String TarjetaNumero = request.getParameter("cardnumber");
		String ExpMes = request.getParameter("expmonth");
		String ExpYear = request.getParameter("expyear");
		String CVV = request.getParameter("cvv");
		
		PagoDTO pago = new PagoDTO();
		pago.setFirstname(Nombre);
		pago.setEmail(email);
		pago.setAddress(Direccion);
		pago.setCity(Ciudad);
		pago.setState(Estado);
		pago.setZip(Codigo);
		pago.setCardname(TarjetaNombre);
		pago.setCardnumber(TarjetaNumero);
		pago.setExpmonth(ExpMes);
		pago.setExpyear(ExpYear);
		pago.setCvv(CVV);
		return pago;
	}
	
	public void documentShowPDF( PagoDTO pago,HttpServletResponse response ){
		 try{
			 response.setContentType( "application/pdf" );
			 response.addHeader( "Content-Disposition","attachment;filename=PagoCliente.pdf" );
			 OutputStream fos = response.getOutputStream();
			 Document document = new Document( PageSize.LETTER.rotate() );
			 PdfWriter writer = PdfWriter.getInstance( document,fos );
			 document.addTitle( "Detalles del Pago" );
			 document.addAuthor( "Verde" );
			 document.addCreationDate();
			 document.addSubject( "Pago en PDF" );
			 document.addCreator( "iText" );
			 document.open();
		 Font font = FontFactory.getFont( FontFactory.COURIER, 18,Font.BOLD,new Color( 0, 0, 128 ) );
		 Phrase phrase = new Phrase( "\n\nVerde\n", font );
		 Table tabla = new Table( 8 );
   		 tabla.setBorderWidth( 6 );
   		 tabla.setBorderColor( new Color( 0, 0, 255 ) );
   		 tabla.setBackgroundColor( new Color( 226, 222, 222 ) );
   		 tabla.setPadding( 5 );
   		 tabla.setSpacing( 5 );
   		 Cell celda = new Cell( "Datos Cliente" );
   		 celda.setHeader( true );
   		 celda.setColspan( 8 );
   		 celda.setBorderColor( new Color( 0, 192, 0 ) );
   		 tabla.addCell( celda );
   		 document.add( tabla );
   		 tabla = new Table( 6 );
   		 tabla.setBorderWidth( 3 );
   		 tabla.setBorderColor( new Color( 0, 0, 255 ) );
   		 tabla.setBackgroundColor( new Color( 226, 222, 222 ) );
   		 tabla.setPadding( 6 );
   		 tabla.setSpacing( 6 );
   		 font = FontFactory.getFont( FontFactory.COURIER, 8, Font.BOLD, new Color( 64, 64, 255 ) );
   		 phrase = new Phrase( "Nombre", font );
   		 tabla.addCell( phrase );
   		 phrase = new Phrase( "email", font );
   		 tabla.addCell( phrase );
   		 phrase = new Phrase( "Direccion", font );
   		 tabla.addCell( phrase );
   		 phrase = new Phrase( "Ciudad", font );
   		 tabla.addCell( phrase );
   		 phrase = new Phrase( "Estado", font );
   		 tabla.addCell( phrase );
   		 phrase = new Phrase( "Codigo Postal", font );
  		 tabla.addCell( phrase );
   		 document.add( tabla );
   		 tabla = new Table( 6 );
   		 font = FontFactory.getFont( FontFactory.COURIER, 8, Font.BOLD,new Color( 0, 128, 0 ) );
   		    	 phrase = new Phrase( pago.getFirstname(), font );
   			     tabla.addCell( phrase );
	    		 phrase = new Phrase( pago.getEmail(), font );
	    		 tabla.addCell( phrase );
	    		 phrase = new Phrase( pago.getAddress(), font );
	    		 tabla.addCell( phrase );
	    		 phrase = new Phrase( pago.getCity(), font );
	    		 tabla.addCell( phrase );
	    		 phrase = new Phrase( pago.getState(), font );
	    		 tabla.addCell( phrase );
	    		 phrase = new Phrase( pago.getZip(), font );
	    		 tabla.addCell( phrase );
	    		 document.add( tabla );	 
	    		 
	    		 
	    		 Font font1 = FontFactory.getFont( FontFactory.COURIER, 18,Font.BOLD,new Color( 0, 0, 128 ) );
	    		 Phrase phrase1 = new Phrase( "\n\nVerde\n", font1 );
	    		 
	    		 Table tabla1 = new Table( 8 );
	       		 tabla1.setBorderWidth( 6 );
	       		 tabla1.setBorderColor( new Color( 0, 0, 255 ) );
	       		 tabla1.setBackgroundColor( new Color( 226, 222, 222 ) );
	       		 tabla1.setPadding( 5 );
	       		 tabla1.setSpacing( 5 );
	       		 Cell celda1 = new Cell( "Datos Tarjeta" );
	       		 celda1.setHeader( true );
	       		 celda1.setColspan( 8 );
	       		 celda1.setBorderColor( new Color( 0, 192, 0 ) );
	       		 tabla1.addCell( celda1 );
	       		 document.add( tabla1 );
	       		 tabla1 = new Table( 6 );
	       		 tabla1.setBorderWidth( 3 );
	       		 tabla1.setBorderColor( new Color( 0, 0, 255 ) );
	       		 tabla1.setBackgroundColor( new Color( 226, 222, 222 ) );
	       		 tabla1.setPadding( 6 );
	       		 tabla1.setSpacing( 6 );
	       		 font1 = FontFactory.getFont( FontFactory.COURIER, 8, Font.BOLD, new Color( 64, 64, 255 ) );
	       		 phrase1 = new Phrase( "Titular de la Tarjeta", font1 );
	       		 tabla1.addCell( phrase1 );
	       		 phrase1 = new Phrase( "Numero de Tarjeta", font1 );
	       		 tabla1.addCell( phrase1 );
	       		 phrase1 = new Phrase( "Exp Mes", font1 );
	       		 tabla1.addCell( phrase1 );
	       		 phrase1 = new Phrase( "Exp Año", font1 );
	       		 tabla1.addCell( phrase1 );
	       		 phrase1 = new Phrase( "CVV", font1 );
	       		 tabla1.addCell( phrase1 );
	       		 document.add( tabla1 );
	       		 tabla1 = new Table( 6 );
	       		 font1 = FontFactory.getFont( FontFactory.COURIER, 8, Font.BOLD,new Color( 0, 128, 0 ) );
	       		    	 phrase1 = new Phrase( pago.getCardname(), font1 );
	       			     tabla1.addCell( phrase1 );
	    	    		 phrase1 = new Phrase( pago.getCardnumber(), font1 );
	    	    		 tabla1.addCell( phrase1 );
	    	    		 phrase1 = new Phrase( pago.getExpmonth(), font1 );
	    	    		 tabla1.addCell( phrase1 );
	    	    		 phrase1 = new Phrase( pago.getExpyear(), font1 );
	    	    		 tabla1.addCell( phrase1 );
	    	    		 phrase1 = new Phrase( pago.getCvv(), font1 );
	    	    		 tabla1.addCell( phrase1 );
	    	    		 document.add( tabla1 );	
	    		 
		 fos.flush();
		 document.close();
		 } catch ( IOException e ) {
		 e.printStackTrace();
		 } catch ( DocumentException e ){
		 e.printStackTrace();
		 }
   }
	
	public void documentShowHTML( PagoDTO pago,HttpServletResponse response ){
		try{
			 response.setContentType( "application/html" );
			 response.addHeader( "Content-Disposition","attachment;filename=PagoCliente.html" );
			 OutputStream fos = response.getOutputStream();
			 Document document = new Document( PageSize.LETTER.rotate() );
			 HtmlWriter writer = HtmlWriter.getInstance( document, fos);
			 document.addTitle( "Detalles del cliente" );
			 document.addAuthor( "Golden Warriors" );
			 document.addCreationDate();
			 document.addSubject( "Clientes en HTML" );
			 document.addCreator( "iText" );
			 document.open();
			 
			 Font font = FontFactory.getFont( FontFactory.COURIER, 18,Font.BOLD,new Color( 0, 0, 128 ) );
			 Phrase phrase = new Phrase( "\n\nVerde\n", font );
			 Table tabla = new Table( 8 );
	   		 tabla.setBorderWidth( 6 );
	   		 tabla.setBorderColor( new Color( 0, 0, 255 ) );
	   		 tabla.setBackgroundColor( new Color( 226, 222, 222 ) );
	   		 tabla.setPadding( 5 );
	   		 tabla.setSpacing( 5 );
	   		 Cell celda = new Cell( "Datos Cliente" );
	   		 celda.setHeader( true );
	   		 celda.setColspan( 8 );
	   		 celda.setBorderColor( new Color( 0, 192, 0 ) );
	   		 tabla.addCell( celda );
	   		 document.add( tabla );
	   		 tabla = new Table( 6 );
	   		 tabla.setBorderWidth( 3 );
	   		 tabla.setBorderColor( new Color( 0, 0, 255 ) );
	   		 tabla.setBackgroundColor( new Color( 226, 222, 222 ) );
	   		 tabla.setPadding( 6 );
	   		 tabla.setSpacing( 6 );
	   		 font = FontFactory.getFont( FontFactory.COURIER, 8, Font.BOLD, new Color( 64, 64, 255 ) );
	   		 phrase = new Phrase( "Nombre", font );
	   		 tabla.addCell( phrase );
	   		 phrase = new Phrase( "email", font );
	   		 tabla.addCell( phrase );
	   		 phrase = new Phrase( "Direccion", font );
	   		 tabla.addCell( phrase );
	   		 phrase = new Phrase( "Ciudad", font );
	   		 tabla.addCell( phrase );
	   		 phrase = new Phrase( "Estado", font );
	   		 tabla.addCell( phrase );
	   		 phrase = new Phrase( "Codigo Postal", font );
	  		 tabla.addCell( phrase );
	   		 document.add( tabla );
	   		 tabla = new Table( 6 );
	   		 font = FontFactory.getFont( FontFactory.COURIER, 8, Font.BOLD,new Color( 0, 128, 0 ) );
	   		    	 phrase = new Phrase( pago.getFirstname(), font );
	   			     tabla.addCell( phrase );
		    		 phrase = new Phrase( pago.getEmail(), font );
		    		 tabla.addCell( phrase );
		    		 phrase = new Phrase( pago.getAddress(), font );
		    		 tabla.addCell( phrase );
		    		 phrase = new Phrase( pago.getCity(), font );
		    		 tabla.addCell( phrase );
		    		 phrase = new Phrase( pago.getState(), font );
		    		 tabla.addCell( phrase );
		    		 phrase = new Phrase( pago.getZip(), font );
		    		 tabla.addCell( phrase );
		    		 document.add( tabla );	 
		    		 
		    		 
		    		 Font font1 = FontFactory.getFont( FontFactory.COURIER, 18,Font.BOLD,new Color( 0, 0, 128 ) );
		    		 Phrase phrase1 = new Phrase( "\n\nVerde\n", font1 );
		    		 
		    		 Table tabla1 = new Table( 8 );
		       		 tabla1.setBorderWidth( 6 );
		       		 tabla1.setBorderColor( new Color( 0, 0, 255 ) );
		       		 tabla1.setBackgroundColor( new Color( 226, 222, 222 ) );
		       		 tabla1.setPadding( 5 );
		       		 tabla1.setSpacing( 5 );
		       		 Cell celda1 = new Cell( "Datos Tarjeta" );
		       		 celda1.setHeader( true );
		       		 celda1.setColspan( 8 );
		       		 celda1.setBorderColor( new Color( 0, 192, 0 ) );
		       		 tabla1.addCell( celda1 );
		       		 document.add( tabla1 );
		       		 tabla1 = new Table( 6 );
		       		 tabla1.setBorderWidth( 3 );
		       		 tabla1.setBorderColor( new Color( 0, 0, 255 ) );
		       		 tabla1.setBackgroundColor( new Color( 226, 222, 222 ) );
		       		 tabla1.setPadding( 6 );
		       		 tabla1.setSpacing( 6 );
		       		 font1 = FontFactory.getFont( FontFactory.COURIER, 8, Font.BOLD, new Color( 64, 64, 255 ) );
		       		 phrase1 = new Phrase( "Titular de la Tarjeta", font1 );
		       		 tabla1.addCell( phrase1 );
		       		 phrase1 = new Phrase( "Numero de Tarjeta", font1 );
		       		 tabla1.addCell( phrase1 );
		       		 phrase1 = new Phrase( "Exp Mes", font1 );
		       		 tabla1.addCell( phrase1 );
		       		 phrase1 = new Phrase( "Exp Año", font1 );
		       		 tabla1.addCell( phrase1 );
		       		 phrase1 = new Phrase( "CVV", font1 );
		       		 tabla1.addCell( phrase1 );
		       		 document.add( tabla1 );
		       		 tabla1 = new Table( 6 );
		       		 font1 = FontFactory.getFont( FontFactory.COURIER, 8, Font.BOLD,new Color( 0, 128, 0 ) );
		       		    	 phrase1 = new Phrase( pago.getCardname(), font1 );
		       			     tabla1.addCell( phrase1 );
		    	    		 phrase1 = new Phrase( pago.getCardnumber(), font1 );
		    	    		 tabla1.addCell( phrase1 );
		    	    		 phrase1 = new Phrase( pago.getExpmonth(), font1 );
		    	    		 tabla1.addCell( phrase1 );
		    	    		 phrase1 = new Phrase( pago.getExpyear(), font1 );
		    	    		 tabla1.addCell( phrase1 );
		    	    		 phrase1 = new Phrase( pago.getCvv(), font1 );
		    	    		 tabla1.addCell( phrase1 );
		    	    		 document.add( tabla1 );

		 fos.flush();
		 document.close();
		 } catch ( IOException e ) {
		 e.printStackTrace();
		 } catch ( DocumentException e ){
		 e.printStackTrace();
		 }
	}
	
	private void GenerarXLS(HttpServletRequest request ,HttpServletResponse response ) throws IOException {
		String Nombre = request.getParameter("firstname");
		String email = request.getParameter("email");
		String Direccion = request.getParameter("address");
		String Ciudad = request.getParameter("city");
		String Estado = request.getParameter("state");
		String Codigo = request.getParameter("zip");
		
		String TarjetaNombre = request.getParameter("cardname");
		String TarjetaNumero = request.getParameter("cardnumber");
		String ExpMes = request.getParameter("expmonth");
		String ExpYear = request.getParameter("expyear");
		String CVV = request.getParameter("cvv");
		
		PagoDTO pago = new PagoDTO();
		pago.setFirstname(Nombre);
		pago.setEmail(email);
		pago.setAddress(Direccion);
		pago.setCity(Ciudad);
		pago.setState(Estado);
		pago.setZip(Codigo);
		pago.setCardname(TarjetaNombre);
		pago.setCardnumber(TarjetaNumero);
		pago.setExpmonth(ExpMes);
		pago.setExpyear(ExpYear);
		pago.setCvv(CVV);
		Map<String, PagoDTO> beans = new HashMap<String, PagoDTO>();
		beans.put( "pago", pago );
		xlsShow( beans, response);
	}
	
	public void xlsShow( Map<String,PagoDTO> beans, HttpServletResponse response)
			throws IOException {
		
		 ServletContext context = getServletContext();
		 InputStream istream = context
		 .getResourceAsStream( "/WEB-INF/templates/PlantillaCliente.xls" );
		 XLSTransformer transformer = new XLSTransformer();
		 HSSFWorkbook workbook = transformer.transformXLS( istream, beans );
		 response.setContentType( "application/msexcel" );
		 response.addHeader( "Content-Disposition",
		 "attachment;filename=PagoCliente.xls" );
		 OutputStream os = response.getOutputStream();
		 workbook.write( os );
		 os.flush();
	}
}
