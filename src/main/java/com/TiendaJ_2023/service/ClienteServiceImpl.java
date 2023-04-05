package com.TiendaJ_2023.service;

import com.TiendaJ_2023.dao.ClienteDao;
import com.TiendaJ_2023.dao.CreditoDao;
import com.TiendaJ_2023.domain.Cliente;
import com.TiendaJ_2023.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao ClienteDao;

    @Autowired
    CreditoDao creditoDao;

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
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);

        cliente.setCredito(credito);
        ClienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        ClienteDao.deleteById(cliente.getIdCliente());
    }

 

    @Override
    public List<Cliente> getClientePorNombre(String nombre) {
        return ClienteDao.findByNombre(nombre);
    }

    @Override
    public List<Cliente> getClientePorTelefono(String telefono) {
         return ClienteDao.findByNombre(telefono);
    }

    @Override
    public List<Cliente> getClientePorNombreApellidosTelefono(String nombre, String apellidos, String telefono) {
       return ClienteDao.findByNombreOrApellidosOrTelefono(nombre, apellidos, telefono); 
    }

}
