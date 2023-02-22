package com.TiendaJ_2023.service;

import com.TiendaJ_2023.dao.ClienteDao;
import com.TiendaJ_2023.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao ClienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) ClienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return ClienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        ClienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        ClienteDao.deleteById(cliente.getIdCliente());
    }

}
