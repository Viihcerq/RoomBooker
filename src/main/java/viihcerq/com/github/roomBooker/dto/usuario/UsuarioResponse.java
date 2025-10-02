package viihcerq.com.github.roomBooker.dto.usuario;

import viihcerq.com.github.roomBooker.model.Reserva;
import viihcerq.com.github.roomBooker.model.Usuario;
import viihcerq.com.github.roomBooker.model.enuns.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioResponse {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private List<Reserva> reservas = new ArrayList<>();

    public UsuarioResponse toDto(Usuario usuario) {
        this.setId(usuario.getId());
        this.setNome(usuario.getNome());
        this.setEmail(usuario.getEmail());
        this.setSenha(usuario.getSenha());
        this.setTipoUsuario(usuario.getTipoUsuario());
        this.setReservas(usuario.getReservas());
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

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
