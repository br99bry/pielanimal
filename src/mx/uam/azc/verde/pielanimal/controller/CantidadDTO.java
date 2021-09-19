/**
 * 
 */
package mx.uam.azc.verde.pielanimal.controller;

import java.io.Serializable;

/**
 * @author rleon
 *
 */
public class CantidadDTO implements Serializable {
	String _id;
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
