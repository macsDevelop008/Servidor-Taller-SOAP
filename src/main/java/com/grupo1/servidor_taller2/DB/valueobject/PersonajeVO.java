/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.DB.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author migue
 */
public class PersonajeVO implements Serializable
{
    private final static String nombreTabla = "personaje";
    
    private String id;
    private String nombre;
    private double fuerza;
    private double mana;
    private double energia;
    private String id_especie;
    private String id_jugador;
    private double estadoRegistro;
    private Date fechaModificacion;

    
    public PersonajeVO(String id, String nombre, double fuerza, double mana, double energia, String id_especie, String id_jugador, double estadoRegistro, Date fechaModificacion) {
        this.id = id;
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.mana = mana;
        this.energia = energia;
        this.id_especie = id_especie;
        this.id_jugador = id_jugador;
        this.estadoRegistro = estadoRegistro;
        this.fechaModificacion = fechaModificacion;
    }

    public PersonajeVO(String id) 
    {
        this.id = id;
    }

    public PersonajeVO(String id_jugador, Date fechaModificacion) 
    {
        this.id_jugador = id_jugador;
        this.fechaModificacion = fechaModificacion;
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

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public String getId_especie() {
        return id_especie;
    }

    public void setId_especie(String id_especie) {
        this.id_especie = id_especie;
    }

    public String getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(String id_jugador) {
        this.id_jugador = id_jugador;
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
        return "Personaje{" + "id=" + id + ", nombre=" + nombre + ", fuerza=" + fuerza + ", mana=" + mana + ", energia=" + energia + ", id_especie=" + id_especie + ", id_jugador=" + id_jugador + ", estadoRegistro=" + estadoRegistro + ", fechaModificacion=" + fechaModificacion + '}';
    }

    public String nameTable() {
        return nombreTabla;
    }
    
    
    
}
