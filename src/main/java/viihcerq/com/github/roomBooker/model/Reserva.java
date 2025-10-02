package viihcerq.com.github.roomBooker.model;



import jakarta.persistence.*;
import viihcerq.com.github.roomBooker.model.enuns.StatusReserva;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;
    private int qtaPessoas;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    public Reserva(){}
    public Reserva(Long id, LocalDate dia, LocalTime horaInicio, LocalTime horaFim, Sala sala, int qtaPessoas, Usuario usuario, StatusReserva status) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.sala = sala;
        this.qtaPessoas = qtaPessoas;
        this.usuario = usuario;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
