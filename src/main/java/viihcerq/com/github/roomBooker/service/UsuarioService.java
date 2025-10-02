package viihcerq.com.github.roomBooker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import viihcerq.com.github.roomBooker.dto.usuario.UsuarioCreateDTO;
import viihcerq.com.github.roomBooker.dto.usuario.UsuarioUpdateDTO;
import viihcerq.com.github.roomBooker.model.Usuario;
import viihcerq.com.github.roomBooker.model.enuns.TipoUsuario;
import viihcerq.com.github.roomBooker.repository.UsuarioRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario create(UsuarioCreateDTO dto){
        return repository.save(dto.toEntity());
    }

    public Optional<Usuario> atualizarUsuario(Long id, UsuarioUpdateDTO dto){
        return repository.findById(id)
                .map(u -> repository.save(dto.toEntity()));
    }

    public List<Usuario> listarUsuarios(Long usuarioId){
        if (isAdmistrador(usuarioId)){
            return repository.findAll();
        }
        return Collections.emptyList();
    }

    public Optional<Usuario> listaUsuarioPorId(Long id){
        return repository.findById(id);
    }

    public boolean deletarUsuario(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean isAdmistrador(Long id){
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.map(u -> u.getTipoUsuario() == TipoUsuario.ADMINISTRADOR).orElse(false);
    }





}
