package viihcerq.com.github.roomBooker.model;




import jakarta.persistence.*;
import viihcerq.com.github.roomBooker.model.enuns.StatusSala;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String nome;
    private int capacidade;
    @Enumerated(EnumType.STRING)
    private StatusSala statusSala;
    private boolean tv;
    private boolean projetor;
    private boolean quadroBranco;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public StatusSala getStatusSala() {
        return statusSala;
    }

    public void setStatusSala(StatusSala statusSala) {
        this.statusSala = statusSala;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isProjetor() {
        return projetor;
    }

    public void setProjetor(boolean projetor) {
        this.projetor = projetor;
    }

    public boolean isQuadroBranco() {
        return quadroBranco;
    }

    public void setQuadroBranco(boolean quadroBranco) {
        this.quadroBranco = quadroBranco;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean estaDisponivel(LocalDate dia, LocalTime horaInicio, long duracaoHoras) {
        for (Reserva reserva : reservas) {
            if (reserva.getDia().equals(dia) &&
                    reserva.getHoraInicio().isBefore(horaInicio.plusHours(duracaoHoras)) &&
                    reserva.getHoraFim().isAfter(horaInicio)) {
                return false;
            }
        }
        return true;
    }




}
