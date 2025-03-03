
package com.sompoble.cat.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Persona {
    
    
    @OneToOne
    private Usuario unUsuario;
    
    @OneToMany(mappedBy="CLIENTE_ID")
    private List<Reserva>listaReservas;
   

    public Cliente() {
        
    }

    public Cliente(String dni, String nombre, String apellidos, String email, String telefono) {
        super(dni, nombre, apellidos, email, telefono);
    }
}