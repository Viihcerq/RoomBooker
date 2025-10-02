package viihcerq.com.github.roomBooker.dto.usuario;

import viihcerq.com.github.roomBooker.model.Sala;
import viihcerq.com.github.roomBooker.model.Usuario;
import viihcerq.com.github.roomBooker.model.enuns.TipoUsuario;

public class UsuarioUpdateDTO {
    private String telefone;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;

    public Usuario toEntity(){
        Usuario usuario = new Usuario();
        usuario.setTelefone(this.telefone);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setTipoUsuario(this.tipoUsuario);
        return usuario;
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
}
