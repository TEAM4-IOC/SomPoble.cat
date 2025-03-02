
package logica;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Persona {
    
    @OneToOne
    private Usuario unUsuario;
   

    public Cliente() {
        
    }

    public Cliente(String dni, String nombre, String apellidos, String email, String contraseña, String teléfono) {
        super(dni, nombre, apellidos, email, contraseña, teléfono);
    }


    
    }


