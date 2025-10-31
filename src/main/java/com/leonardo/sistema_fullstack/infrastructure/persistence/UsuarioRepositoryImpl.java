package com.leonardo.sistema_fullstack.infrastructure.persistence;


import com.leonardo.sistema_fullstack.domain.model.Usuario;
import com.leonardo.sistema_fullstack.domain.ports.UsuarioRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final SpringDataUsuarioRepository springDataUsuarioRepository;

    @Autowired
    public UsuarioRepositoryImpl(SpringDataUsuarioRepository springDataUsuarioRepository) {
        this.springDataUsuarioRepository = springDataUsuarioRepository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return springDataUsuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return springDataUsuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return springDataUsuarioRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuario> buscarPorNome(String nome) {
        return springDataUsuarioRepository.findByNome(nome);
    }

    @Override
    public List<Usuario> listarTodos() {
        return springDataUsuarioRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        springDataUsuarioRepository.deleteById(id);
    }

    @Override
    public void deletarPorEmail(String email) {
        springDataUsuarioRepository.deleteByEmail(email);
    }
}

