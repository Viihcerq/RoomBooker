package viihcerq.com.github.roomBooker.dto.reserva;

import viihcerq.com.github.roomBooker.model.Reserva;
import viihcerq.com.github.roomBooker.model.Sala;
import viihcerq.com.github.roomBooker.model.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaUpdateDTO {
    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Sala sala;
    private int qtaPessoas;

    public Reserva toEntity() {
        Reserva reserva = new Reserva();
        reserva.setDia(this.dia);
        reserva.setHoraInicio(this.horaInicio);
        reserva.setHoraFim(this.horaFim);
        reserva.setSala(this.sala);
        reserva.setQtaPessoas(this.qtaPessoas);
        return reserva;
    }
}
