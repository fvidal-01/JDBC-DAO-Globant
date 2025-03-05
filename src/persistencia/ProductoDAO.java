package persistencia;

public class ProductoDAO extends DAO{
    public void eliminarProductoPorCodigo(int idProducto) throws Exception{
        try {
            String sql = "DELETE FROM Producto WHERE id_producto = " + idProducto + "";
            insertarModificarEliminarDataBase(sql);
            System.out.println("El producto fue eliminado correctamente.");
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
}
