import persistencia.ClienteDAO;
import entidades.Cliente;

public class App {
    public static void main(String[] args) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cli = new Cliente();
        cli.setIdCliente(44);
        cli.setCodigoCliente(44);
        cli.setNombreCliente("Carlos"); 
        cli.setNombreContacto("Pedro");
        cli.setApellidoContacto("Pedrosa");
        cli.setTelefono("123456789");
        cli.setFax("1245");
        cli.setCiudad("Los Angeles");
        cli.setRegion("California");
        cli.setPais("Estados Unidos"); 
        cli.setCodigoPostal("314");
        cli.setIdEmpleado(1);
        cli.setLimiteCredito(154);
        

        clienteDAO.guardarCliente(cli);
        clienteDAO.listarTodosLosClientes();
    }
}
