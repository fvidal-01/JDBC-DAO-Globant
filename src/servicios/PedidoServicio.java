package servicios;

import java.util.Date;
import java.util.List;

import entidades.Pedido;
import persistencia.PedidoDAO;

public class PedidoServicio {
    private PedidoDAO pd;

    public PedidoServicio() {
        this.pd = new PedidoDAO();
    }

    public List<Pedido> obtenerPedidos() throws Exception{
        return pd.obtenerPedidos();
    }

    public Pedido guardarPedido(int idPedido, int codigoPedido, Date fechaPedido, Date fechaEsperada, Date fechaEntrega,
                                String estado, String comentarios, int idCliente) throws Exception{
        Pedido pedido = new Pedido(idPedido, codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado, comentarios, idCliente);
        pd.guardarPedido(pedido);

        return pedido;
    }
}
