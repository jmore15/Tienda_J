package com.TiendaJ_2023.service;

import ch.qos.logback.core.net.server.Client;
import com.TiendaJ_2023.domain.Cliente;
import java.util.List;

public interface ClienteService {

    public List<Cliente> getClientes();

    public Cliente getCliente(Cliente cliente);

    public void save(Cliente cliente);

    public void delete(Cliente cliente);

    public List<Cliente> getClientePorNombre(String nombre);

    public List<Cliente> getClientePorTelefono(String telefono);

    public List<Cliente> getClientePorNombreApellidosTelefono(String nombre, String apellidos, String telefono);

}
