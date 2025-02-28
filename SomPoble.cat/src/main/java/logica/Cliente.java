
package logica;


public class Cliente extends Persona {
    
    private int id_cliente;

    public Cliente() {
        
    }

    public Cliente(int id_cliente, String nombre, String apellidos, String email, String contraseña, String teléfono) {
        super(nombre, apellidos, email, contraseña, teléfono);
        this.id_cliente = id_cliente;
        
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

  

}

