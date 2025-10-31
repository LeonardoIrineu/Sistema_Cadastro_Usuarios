package com.leonardo.sistema_fullstack.infrastructure.persistence;

import com.leonardo.sistema_fullstack.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataUsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByNome(String nome);

    void deleteByEmail(String email);

}
