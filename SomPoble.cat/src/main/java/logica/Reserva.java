
package logica;

import java.util.Date;
import logica.Cliente;
import logica.Servicio;

public class Reserva {
    
    private int id_reserva;
    private Date fecha_reserva;
    private String hora;
    private String estado;

    public Reserva() {
    }

    public Reserva(int id_reserva, Date fecha_reserva, String hora, String estado) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.hora = hora;
        this.estado = estado;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
