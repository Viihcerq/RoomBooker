package viihcerq.com.github.roomBooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viihcerq.com.github.roomBooker.dto.usuario.UsuarioCreateDTO;
import viihcerq.com.github.roomBooker.dto.usuario.UsuarioResponse;
import viihcerq.com.github.roomBooker.dto.usuario.UsuarioUpdateDTO;
import viihcerq.com.github.roomBooker.service.UsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return ResponseEntity.status(201).body(new UsuarioResponse().toDto(service.create(usuarioCreateDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long id, @RequestBody UsuarioUpdateDTO usuarioUpdateDTO){
        return service.atualizarUsuario(id, usuarioUpdateDTO)
                .map(u -> new UsuarioResponse().toDto(u))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{idAdmistrador}")
    public ResponseEntity<List<UsuarioResponse>> getAll(@PathVariable Long idAdmistrador){
        List<UsuarioResponse> responses = service.listarUsuarios(idAdmistrador).stream().map(u -> new UsuarioResponse().toDto(u)).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getById(@PathVariable Long id){
        return service.listaUsuarioPorId(id)
                .map(u -> new UsuarioResponse().toDto(u))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean result = service.deletarUsuario(id);
        if (result){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
