package viihcerq.com.github.roomBooker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viihcerq.com.github.roomBooker.dto.SalaCreateDTO;
import viihcerq.com.github.roomBooker.dto.SalaResponse;
import viihcerq.com.github.roomBooker.dto.SalaUpdateDTO;
import viihcerq.com.github.roomBooker.service.SalaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room")
public class SalaController {

    @Autowired
    private SalaService service;

    @PostMapping("/{idUsuario}")
    public ResponseEntity<SalaResponse> create(@RequestBody SalaCreateDTO salaCreateDTO, @PathVariable Long idUsuario){
        return ResponseEntity.status(201).body(new SalaResponse().toDto(service.createSala(salaCreateDTO, idUsuario)));
    }

    @PutMapping("/{idSala}/{idUsuario}")
    public ResponseEntity<SalaResponse> update(@PathVariable Long id, @RequestBody SalaUpdateDTO salaUpdateDTO, @PathVariable Long idUsuario){
        return service.atualizarSala(id, salaUpdateDTO,idUsuario)
                .map(s -> new SalaResponse().toDto(s))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<SalaResponse>> getAll(){
        List<SalaResponse> responses = service.listaSalas().stream().map(s -> new SalaResponse().toDto(s)).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{idSala}/{idUsuario}")
    public ResponseEntity<SalaResponse> getById(@PathVariable Long id, @PathVariable Long idUsuario){
        return service.listaReservaPorId(id, idUsuario)
                .map(s -> new SalaResponse().toDto(s))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idSala}/{idUsuario}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable Long idUsuario){
        boolean result = service.deleteSala(id, idUsuario);
        if (result){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
