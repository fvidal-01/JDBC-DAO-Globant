package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;

public class ClienteDAO extends DAO{
    public void guardarCliente(Cliente cliente) throws Exception{
        try {
            if(cliente == null){
                throw new Exception("El cliente no puede ser nulo.");
            }

            String sql = "INSERT INTO Cliente (id_cliente,codigo_cliente,nombre_cliente,nombre_contacto,"
            + "apellido_contacto,telefono,fax,ciudad,region,pais,codigo_postal,id_empleado,limite_credito) VALUES (" +

            cliente.getIdCliente() + ", " +
            cliente.getCodigoCliente() + ", " +
            "'" + cliente.getNombreCliente() + "', " + 
            "'" + cliente.getNombreContacto() + "', " +
            "'" + cliente.getApellidoContacto() + "', " +
            "'" + cliente.getTelefono() + "', " +
            "'" + cliente.getFax() + "', " +
            "'" + cliente.getCiudad() + "', " +
            "'" + cliente.getRegion() + "', " +
            "'" + cliente.getPais() + "', " +
            "'" + cliente.getCodigoPostal() + "', " +
            cliente.getIdEmpleado() + ", " +
            cliente.getLimiteCredito() + ");";

            insertarModificarEliminarDataBase(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public List<Cliente> listarTodosLosClientes() throws Exception{
        try{
            String sql = "SELECT id_cliente, nombre_contacto, apellido_contacto FROM cliente";

            consultarDataBase(sql);
            Cliente cliente = null;
            List<Cliente> clientes = new ArrayList<>();

            while (resultSet.next()) {
                cliente = new Cliente();

                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
                cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));

                clientes.add(cliente);
            }

            desconectarBase();
            return clientes;
        }
        catch (Exception e){
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public String buscarClientePorCodigo(int codigo) throws Exception{
        try {
            String sql = "SELECT * FROM Cliente WHERE codigo_cliente = " + codigo + "";
            consultarDataBase(sql);
            
            Cliente c = null;

            while (resultSet.next()) {
                c = new Cliente();

                c.setIdCliente(resultSet.getInt("id_cliente"));
                c.setCodigoCliente(resultSet.getInt("codigo_cliente"));
                c.setNombreCliente(resultSet.getString("nombre_cliente"));
                c.setNombreContacto(resultSet.getString("nombre_contacto"));
                c.setApellidoContacto(resultSet.getString("apellido_contacto"));
                c.setTelefono(resultSet.getString("telefono"));
                c.setFax(resultSet.getString("fax"));
                c.setCiudad(resultSet.getString("ciudad"));
                c.setRegion(resultSet.getString("region"));
                c.setPais(resultSet.getString("pais"));
                c.setCodigoPostal(resultSet.getString("codigo_postal"));
                c.setIdEmpleado(resultSet.getInt("id_empleado"));
                c.setLimiteCredito(resultSet.getInt("limite_credito"));
            }

            desconectarBase();
            return c.toString();
                      
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }
}
