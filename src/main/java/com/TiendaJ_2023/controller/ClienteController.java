package com.TiendaJ_2023.controller;

import com.TiendaJ_2023.domain.Cliente;
import com.TiendaJ_2023.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {

        var clientes = clienteService.getClientes();
        //var clientes = clienteService.getClientePorNombre("Luis");
        //var clientes = clienteService.getClientesPorApellidosLike("A%");
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevocliente(Cliente cliente) {
        return "/cliente/modificar";
    }
    
    @GetMapping("/cliente/buscar")
    public String buscarcliente(Cliente cliente){
        return "redirect:/cliente/buscar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

}
