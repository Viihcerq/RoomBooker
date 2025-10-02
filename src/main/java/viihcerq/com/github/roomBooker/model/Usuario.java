package viihcerq.com.github.roomBooker.model;


import jakarta.persistence.*;
import viihcerq.com.github.roomBooker.model.enuns.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
