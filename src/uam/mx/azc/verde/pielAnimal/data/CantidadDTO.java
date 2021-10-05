/**
 * 
 */
package uam.mx.azc.verde.pielAnimal.data;

import java.io.Serializable;

/**
 * @author rleon
 *
 */
public class CantidadDTO implements Serializable {
	String _id;
	String _url;
	String _nombre;
	double _precio;
	int _cantidad;
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
   * @return the cantidad
   */
  public int getCantidad()
  {
    return _cantidad;
  }
  /**
   * @param cantidad the cantidad to set
   */
  public void setCantidad( int cantidad )
  {
    _cantidad = cantidad;
  }
	
}