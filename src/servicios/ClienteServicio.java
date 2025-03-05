package servicios;

import java.util.List;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClienteServicio {
    private ClienteDAO cd;
    
    public ClienteServicio() {
        this.cd = new ClienteDAO();
    }

    public Cliente crearNuevoCliente(int idCliente, int codigoCliente, String nombreCliente, String nombreContacto,
                                     String apellidoContacto, String telefono, String fax, String ciudad, String region, String pais,
                                     String codigoPostal, int idEmpleado, double limiteCredito) throws Exception {
        validar(nombreContacto, apellidoContacto);
        Cliente cliente = new Cliente(idCliente,codigoCliente,nombreCliente,nombreContacto,apellidoContacto,
                                      telefono,fax,ciudad,region,pais,codigoPostal,idEmpleado,limiteCredito);
        cd.guardarCliente(cliente);

        return cliente;
    }

    private void validar(String nombre, String apellido) throws Exception{
        if(nombre == null){
            throw new Exception("El nombre no puede ser vacío.");
        }
        if(apellido == null){
            throw new Exception("El apellido no puede ser vacío.");
        }
    }

    public List<Cliente> listarTodosLosClientes() throws Exception{
        return cd.listarTodosLosClientes();
    }

    public String buscarClientePorCodigo(int codigo) throws Exception{
        if(codigo > 0){
            return cd.buscarClientePorCodigo(codigo);
        }
        else {
            throw new Exception("Ingrese un código válido.");
        }
    }
}
