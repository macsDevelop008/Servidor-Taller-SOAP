/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.ws;

import com.grupo1.servidor_taller2.DB.businessobject.JugadorBO;
import com.grupo1.servidor_taller2.DB.valueobject.JugadorVO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author migue
 */
@WebService(serviceName = "JugadorWebService")
public class JugadorWebService 
{

    @WebMethod(operationName = "insertarJugador")
    public boolean insertJ(@WebParam(name = "JugadorVO") JugadorVO jugador)
    {
        JugadorBO a = new JugadorBO();
        
        return a.insert(jugador);
    }
    
    @WebMethod(operationName = "actualizarJugador")
    public boolean updateJ(@WebParam(name = "JugadorVO") JugadorVO jugador)
    {
        JugadorBO a = new JugadorBO();
        
        return a.update(jugador);
    }
    
    @WebMethod(operationName = "eliminarJugador")
    public boolean deleteJ(@WebParam(name = "JugadorVO") JugadorVO jugador)
    {
        JugadorBO a = new JugadorBO();
        
        return a.delete(jugador);
    }
    
    @WebMethod(operationName = "buscarporIdJugador")
    public JugadorVO findByIdJ(@WebParam(name = "JugadorVO") JugadorVO jugador)
    {
        JugadorBO a = new JugadorBO();
        
        return a.findById(jugador);
    }
    
    @WebMethod(operationName = "listarJugadores")
    public ArrayList<JugadorVO> listJ(@WebParam(name = "Vacio") JugadorVO jugador)
    {
        JugadorBO a = new JugadorBO();
        
        return a.list();
    }
}
