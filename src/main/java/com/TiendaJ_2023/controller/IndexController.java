package com.TiendaJ_2023.controller;

import com.TiendaJ_2023.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import com.TiendaJ_2023.dao.ClienteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao ClienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
//        log.info("ahora desde MVC");
//        model.addAttribute("Mensaje","hola desde el controler");
//        
//        
//        Cliente cliente = new Cliente("Jonathan", "Moreira Alemán", "jonmoreira@outlook.com", "88552288");
//        model.addAttribute("objetoCliente", cliente);
//        
//        Cliente cliente2 = new Cliente("Fran", "Salas Garcia", "fsalas@outlook.com", "89556228");
//        Cliente cliente3 = new Cliente("Susan", "Sanchez Paniagua", "fsalas@outlook.com", "89556228");
//        
//        List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3);

var clientes = ClienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }

}
