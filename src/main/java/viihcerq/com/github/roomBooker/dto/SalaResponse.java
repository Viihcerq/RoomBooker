package viihcerq.com.github.roomBooker.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import viihcerq.com.github.roomBooker.dto.usuario.UsuarioResponse;
import viihcerq.com.github.roomBooker.model.Reserva;
import viihcerq.com.github.roomBooker.model.Sala;
import viihcerq.com.github.roomBooker.model.Usuario;
import viihcerq.com.github.roomBooker.model.enuns.StatusSala;

import java.util.ArrayList;
import java.util.List;

public class SalaResponse {

    private  Long id;
    private String nome;
    private int capacidade;
    private StatusSala statusSala;
    private boolean tv;
    private boolean projetor;
    private boolean quadroBranco;
    private List<Reserva> reservas = new ArrayList<>();

    public SalaResponse toDto(Sala sala) {
        this.setId(sala.getId());
        this.setNome(sala.getNome());
        this.setCapacidade(sala.getCapacidade());
        this.setStatusSala(sala.getStatusSala());
        this.setTv(sala.isTv());
        this.setProjetor(sala.isProjetor());
        this.setReservas(sala.getReservas());
        this.setReservas(sala.getReservas());
        return this;
    }

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
}
