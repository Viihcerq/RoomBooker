package viihcerq.com.github.roomBooker.dto.reserva;

import viihcerq.com.github.roomBooker.model.Reserva;
import viihcerq.com.github.roomBooker.model.Sala;
import viihcerq.com.github.roomBooker.model.Usuario;
import viihcerq.com.github.roomBooker.model.enuns.StatusReserva;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {

    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Sala sala;
    private int qtaPessoas;
    private Usuario usuario;
    private StatusReserva status;

    public Reserva toEntity(){
        Reserva reserva = new Reserva();
        reserva.setDia(this.dia);
        reserva.setHoraInicio(this.horaInicio);
        reserva.setHoraFim(this.horaFim);
        reserva.setSala(this.sala);
        reserva.setQtaPessoas(this.qtaPessoas);
        reserva.setUsuario(this.usuario);
        reserva.setStatus(this.status);
        return reserva;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getQtaPessoas() {
        return qtaPessoas;
    }

    public void setQtaPessoas(int qtaPessoas) {
        this.qtaPessoas = qtaPessoas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }
}
