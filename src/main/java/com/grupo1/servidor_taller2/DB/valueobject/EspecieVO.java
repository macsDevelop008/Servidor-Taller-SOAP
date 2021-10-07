/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.DB.valueobject;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author migue
 */
public class EspecieVO implements Serializable
{
    private final static String nombreTabla = "especie"; 
    
    private String id;
    private String nombre;
    private double estadoRegistro;
    private Date fechaModificacion;

    public EspecieVO(String id, String nombre, double estadoRegistro, Date fechaModificacion)
    {
        this.id = id;
        this.nombre = nombre;
        this.estadoRegistro = estadoRegistro;
        this.fechaModificacion = fechaModificacion;
    }
    
    public EspecieVO(String id)
    {
        this.id = id;
    }
    
    public EspecieVO()
    {
        
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(double estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() 
    {
        return "Especie{" + "id=" + id + ", nombre=" + nombre + ", estadoRegistro=" + estadoRegistro + ", fechaModificacion=" + fechaModificacion + '}';
    }


    public String nameTable() 
    {
        return nombreTabla;
    }
    
    
    
}
