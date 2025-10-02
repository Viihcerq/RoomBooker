package viihcerq.com.github.roomBooker.dto;

import viihcerq.com.github.roomBooker.model.Sala;
import viihcerq.com.github.roomBooker.model.Usuario;
import viihcerq.com.github.roomBooker.model.enuns.StatusSala;

public class SalaCreateDTO {
    private String nome;
    private int capacidade;
    private StatusSala statusSala;
    private boolean tv;
    private boolean projetor;
    private boolean quadroBranco;

    public Sala toEntity(){
        Sala sala = new Sala();
        sala.setNome(this.nome);
        sala.setCapacidade(this.capacidade);
        sala.setStatusSala(this.statusSala);
        sala.setTv(this.tv);
        sala.setProjetor(this.projetor);
        sala.setQuadroBranco(this.quadroBranco);
        return sala;
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
}
