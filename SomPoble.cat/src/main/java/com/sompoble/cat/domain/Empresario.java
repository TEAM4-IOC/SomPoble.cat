
package com.sompoble.cat.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESARIO")
public class Empresario extends Persona{
    
    private String nombreNegocio;
    
    @OneToMany(mappedBy="empre")
    private List<Reserva>listaReservas;
    
    @OneToOne
    private Usuario unUsuario;
    
    @OneToOne
    private Horario unHorario;
    
    private String direccion;
    
    private String sector;
    
    private String CIF_NIF;
    
    private String horario;
    
    @OneToMany
    private List servicios;

    public Empresario() {
    }

    public Empresario(String nombreNegocio, String direccion, String sector, String CIF_NIF, String dni, String nombre, String apellidos, String email, String telefono) {
        super(dni, nombre, apellidos, email, telefono);
        this.nombreNegocio = nombreNegocio;
        this.direccion = direccion;
        this.sector = sector;
        this.CIF_NIF = CIF_NIF;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCIF_NIF() {
        return CIF_NIF;
    }

    public void setCIF_NIF(String CIF_NIF) {
        this.CIF_NIF = CIF_NIF;
    }

    
}