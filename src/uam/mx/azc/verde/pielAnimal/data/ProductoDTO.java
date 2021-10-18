/**
 * 
 */
package uam.mx.azc.verde.pielAnimal.data;

import java.io.Serializable;

/**
 * @author rleon
 *
 */
public class ProductoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String _id;
	String _nombre;
	double _precio;
	String _url;
  /**
   * @return the id
   */
  public String getId()
  {
    return _id;
  }
  /**
   * @param id the id to set
   */
  public void setId( String id )
  {
    _id = id;
  }
  /**
   * @return the nombre
   */
  public String getNombre()
  {
    return _nombre;
  }
  /**
   * @param nombre the nombre to set
   */
  public void setNombre( String nombre )
  {
    _nombre = nombre;
  }
  /**
   * @return the precio
   */
  public double getPrecio()
  {
    return _precio;
  }
  /**
   * @param precio the precio to set
   */
  public void setPrecio( double precio )
  {
    _precio = precio;
  }
  /**
   * @return the url
   */
  public String getUrl()
  {
    return _url;
  }
  /**
   * @param url the url to set
   */
  public void setUrl( String url )
  {
    _url = url;
  }
	
  
	
}