package com.sompoble.cat.domain;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "HORARIO")
public class Horario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_HORARIO")
    private Long idHorario;
    
    @Column(name = "HORARIO_INICIO", nullable = false)
    @NotNull
    private LocalTime  horarioInicio;
    
    @Column(name = "HORARIO_FIN", nullable = false)
    @NotNull
    private LocalTime  horarioFin;
    
    @ManyToOne
    @JoinColumn(name="ID_EMPRESA", referencedColumnName = "ID_EMPRESA", nullable = false)
    @NotNull
    private Empresa empresa;
    
    public Horario() {
    }

    // Constructor con parámetros
    public Horario(LocalTime horarioInicio, LocalTime horarioFin, Empresa empresa) {
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.empresa = empresa;
    }

    // Getters y Setters
    public Long getIdHorario() {
        return idHorario;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(LocalTime horarioFin) {
        this.horarioFin = horarioFin;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
