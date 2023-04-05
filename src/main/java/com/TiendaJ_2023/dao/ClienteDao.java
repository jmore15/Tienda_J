package com.TiendaJ_2023.dao;

import com.TiendaJ_2023.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
    public List<Cliente> findByNombre(String nombre);
    
    public List<Cliente> findByTelefono(String telefono);
    
    public List<Cliente> findByNombreOrApellidosOrTelefono(String nombre, String apellidos, String telefono);
    
}
