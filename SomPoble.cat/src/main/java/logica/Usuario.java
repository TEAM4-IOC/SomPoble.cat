
package logica;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
    
    @Id
    private int id_usuario;
    private String nombreUsuario;
    private String contraseña;
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombreUsuario, String contraseña, String tipoUsuario) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
