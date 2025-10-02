package viihcerq.com.github.roomBooker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import viihcerq.com.github.roomBooker.dto.reserva.ReservaCreateDTO;
import viihcerq.com.github.roomBooker.dto.reserva.ReservaDTO;
import viihcerq.com.github.roomBooker.dto.reserva.ReservaUpdateDTO;
import viihcerq.com.github.roomBooker.model.Reserva;
import viihcerq.com.github.roomBooker.model.enuns.StatusReserva;
import viihcerq.com.github.roomBooker.repository.ReservaRepository;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;
    @Autowired
    private UsuarioService usuarioService;

    public Reserva createReserva(ReservaCreateDTO dto){
        if (!dto.getSala().estaDisponivel(dto.getDia(), dto.getHoraInicio(), duracao())){
            throw new IllegalArgumentException("Sala indisponivel");
        }
        Reserva reserva = new Reserva();
        repository.save(reserva);
        return reserva;
    }

    public Optional<Reserva> atualizarReserva(Long id, ReservaUpdateDTO dto){
        return repository.findById(id)
                .map(r -> repository.save(dto.toEntity()));
    }

    public List<Reserva> listaReservas(Long usuarioId){
        if (usuarioService.isAdmistrador(usuarioId)){
            return repository.findAll();
        }
        return null;
    }

    public Optional<Reserva> listaReservaPorId(Long id){
        return repository.findById(id);
    }

    public void deleteReserva(Long id, Long usuarioId){
        if (usuarioService.isAdmistrador(usuarioId)){
            repository.deleteById(id);
        }
    }

    public boolean cancelarReserva(Long id, ReservaDTO reserva){
        Optional<Reserva> reservasOpt = repository.findById(id);
        if (reservasOpt.isPresent() && reserva.getStatus() == StatusReserva.ATIVA){
            reserva.setStatus(StatusReserva.CANCELADA);
            return true;
        }
        return false;
    }

    public long duracao() {
        Reserva reserva = new Reserva();
        Duration duration;
        if (reserva.getHoraFim().isAfter(reserva.getHoraInicio())) {
            duration = Duration.between(reserva.getHoraInicio(), reserva.getHoraFim());
        } else {
            duration = Duration.between(reserva.getHoraInicio(), reserva.getHoraFim().plusHours(24));
        }
        return duration.toHours();
    }


}
