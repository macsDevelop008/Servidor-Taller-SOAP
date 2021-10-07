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
public class JugadorVO implements Serializable
{
    private final static String nombreTabla = "jugador";
    
    private String id;
    private String cuenta;
    private String contraseña;
    private String apodo;
    private String email;
    private double estadoRegistro;
    private Date fechaModificacion;

    public JugadorVO(String id, String cuenta, String contraseña, String apodo, String email, double estadoRegistro, Date fechaModificacion) {
        this.id = id;
        this.cuenta = cuenta;
        this.contraseña = contraseña;
        this.apodo = apodo;
        this.email = email;
        this.estadoRegistro = estadoRegistro;
        this.fechaModificacion = fechaModificacion;
    }

    public JugadorVO(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public String toString() {
        return "Jugador{" + "id=" + id + ", cuenta=" + cuenta + ", contrase\u00f1a=" + contraseña + ", apodo=" + apodo + ", email=" + email + ", estadoRegistro=" + estadoRegistro + ", fechaModificacion=" + fechaModificacion + '}';
    }


    public String nameTable()
    {
        return nombreTabla;
    }
    
    
}
