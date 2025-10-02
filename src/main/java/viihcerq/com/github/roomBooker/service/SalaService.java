package viihcerq.com.github.roomBooker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import viihcerq.com.github.roomBooker.dto.SalaUpdateDTO;
import viihcerq.com.github.roomBooker.model.Sala;
import viihcerq.com.github.roomBooker.dto.SalaCreateDTO;
import viihcerq.com.github.roomBooker.repository.SalaRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SalaService {

    @Autowired
    private SalaRepository repository;

    @Autowired
    private UsuarioService usuarioService;


    public Sala createSala(SalaCreateDTO dto, Long usuarioId){
        if (usuarioService.isAdmistrador(usuarioId)){
            return repository.save(dto.toEntity());
        }
        return null;
    }

    public Optional<Sala> atualizarSala(Long id, SalaUpdateDTO dto, Long usuarioId){
        if (usuarioService.isAdmistrador(usuarioId)){
            return repository.findById(id)
                    .map(s -> repository.save(dto.toEntity()));
        }
        return Optional.empty();

    }

    public List<Sala> listaSalas(){
        return repository.findAll();
    }

    public Optional<Sala> listaReservaPorId(Long id, Long usuarioId){
        if (usuarioService.isAdmistrador(usuarioId)){
            return repository.findById(id);
        }
       return Optional.empty();
    }

    public boolean deleteSala(Long id, Long usuarioId) {
        if (usuarioService.isAdmistrador(usuarioId)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
