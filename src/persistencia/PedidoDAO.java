package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidades.Pedido;

public class PedidoDAO extends DAO{

    public List<Pedido> obtenerPedidos() throws Exception{
        try {
            String sql = "SELECT * FROM Pedido";
            List<Pedido> pedidos = new ArrayList<>();

            consultarDataBase(sql);

            while(resultSet.next()){
                Pedido pedido = new Pedido();

                pedido.setIdPedido(resultSet.getInt("id_pedido"));    
                pedido.setCodigoPedido(resultSet.getInt("codigo_pedido"));
                pedido.setFechaPedido(resultSet.getDate("fecha_pedido"));
                pedido.setFechaEsperada(resultSet.getDate("fecha_esperada"));
                pedido.setFechaEntrega(resultSet.getDate("fecha_entrega"));
                pedido.setEstado(resultSet.getString("estado"));
                pedido.setComentarios(resultSet.getString("comentarios"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));

                pedidos.add(pedido);
            }

            desconectarBase();
            return pedidos;
            
        } catch (Exception e) {
            throw e;
        }

    }

    public void guardarPedido(Pedido p) throws Exception{
        try {
            if(p == null){
                throw new Exception("El pedido no puede ser nulo.");
            }

            String sql = "INSERT INTO pedido (id_pedido,codigo_pedido,fecha_pedido,fecha_esperada,fecha_entrega,estado,comentarios,id_cliente VALUES (" +
            p.getIdPedido() + ", " +
            p.getCodigoPedido() + ", " +
            "'" + p.getFechaPedido() + "', " + 
            "'" + p.getFechaEsperada() + "', " +
            "'" + p.getFechaEntrega() + "', " +
            "'" + p.getEstado() + "', " +
            "'" + p.getComentarios() + "', " +
            p.getIdCliente() + ");";

            insertarModificarEliminarDataBase(sql);

        } catch (Exception e) {
            throw e;
        }
    }
}
