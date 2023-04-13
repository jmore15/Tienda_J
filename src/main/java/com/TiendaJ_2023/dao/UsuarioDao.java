package com.TiendaJ_2023.dao;

import com.TiendaJ_2023.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
