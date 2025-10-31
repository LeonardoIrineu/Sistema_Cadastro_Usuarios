package com.leonardo.sistema_fullstack.application.service;

import com.leonardo.sistema_fullstack.domain.model.Usuario;
import com.leonardo.sistema_fullstack.domain.ports.UsuarioRepository;
import com.leonardo.sistema_fullstack.dto.request.UsuarioRequestDTO;
import com.leonardo.sistema_fullstack.dto.response.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO dto) {
        Optional<Usuario> existente = usuarioRepository.buscarPorEmail(dto.getEmail());
        if (existente.isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }

        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha());
        Usuario salvo = usuarioRepository.salvar(usuario);

        return new UsuarioResponseDTO(salvo.getId(), salvo.getNome(), salvo.getEmail());
    }

    public UsuarioResponseDTO buscarPorId(Long id){
        Usuario usuario = usuarioRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado no sistema!"));
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    public UsuarioResponseDTO buscarPorNome(String nome){
        Usuario usuario = usuarioRepository.buscarPorNome(nome)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado no sistema!"));
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    public List<UsuarioResponseDTO> listarTodos(){
        return usuarioRepository.listarTodos()
                .stream()
                .map(u -> new UsuarioResponseDTO(u.getId(), u.getNome(), u.getEmail()))
                .collect(Collectors.toList());
    }

    public void deletarPorId(Long id){
        usuarioRepository.deletarPorId(id);
    }

    public void deletarPorEmail(String email){
        usuarioRepository.deletarPorEmail(email);
    }


}
