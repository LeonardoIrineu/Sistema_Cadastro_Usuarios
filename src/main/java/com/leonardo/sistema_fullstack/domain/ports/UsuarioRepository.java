package com.leonardo.sistema_fullstack.domain.ports;

import com.leonardo.sistema_fullstack.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    Usuario salvar(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorEmail(String email);

    Optional<Usuario> buscarPorNome(String nome);

    List<Usuario> listarTodos();

    void deletarPorId(Long id);

    void deletarPorEmail(String email);
}
