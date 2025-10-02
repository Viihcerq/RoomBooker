package viihcerq.com.github.roomBooker.dto.usuario;

import viihcerq.com.github.roomBooker.model.Usuario;
import viihcerq.com.github.roomBooker.model.enuns.TipoUsuario;

public class UsuarioCreateDTO {

    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private boolean ativo;
    private TipoUsuario tipoUsuario;

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setTelefone(this.telefone);
        usuario.setEmail(this.email);
        usuario.setTipoUsuario(this.tipoUsuario);
        return usuario;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
