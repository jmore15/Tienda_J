package com.TiendaJ_2023.dao;

import com.TiendaJ_2023.domain.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
}
