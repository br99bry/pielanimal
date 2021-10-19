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
	int _id;
	int _idProducto;
	int _idOrden;
	int _cantidad;
  /**
   * @return the id
   */
  public int getId()
  {
    return _id;
  }
  /**
   * @param id the id to set
   */
  public void setId( int id )
  {
    _id = id;
  }
  /**
   * @return the idProducto
   */
  public int getIdProducto()
  {
    return _idProducto;
  }
  /**
   * @param idProducto the idProducto to set
   */
  public void setIdProducto( int idProducto )
  {
    _idProducto = idProducto;
  }
  /**
   * @return the idOrden
   */
  public int getIdOrden()
  {
    return _idOrden;
  }
  /**
   * @param idOrden the idOrden to set
   */
  public void setIdOrden( int idOrden )
  {
    _idOrden = idOrden;
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
  public void setCantidad( )
  {
    _cantidad = 1;
  }
  
	
}