/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.ws;

import com.grupo1.servidor_taller2.DB.businessobject.JugadorBO;
import com.grupo1.servidor_taller2.DB.valueobject.JugadorVO;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println(jugador);
        
        return a.update(jugador);
    }
    
    @WebMethod(operationName = "eliminarJugador")
    public boolean deleteJ(@WebParam(name = "JugadorVO") String id)
    {
        JugadorBO a = new JugadorBO();
        JugadorVO jugador = new JugadorVO();
        jugador.setId(id);
        return a.delete(jugador);
    }
    
    @WebMethod(operationName = "buscarporIdJugador")
    public JugadorVO findByIdJ(@WebParam(name = "JugadorVO") String id)
    {
        JugadorBO a = new JugadorBO();
        System.out.println(a.findById(id));
        return a.findById(id);
    }
    
    @WebMethod(operationName = "listarJugadores")
    public List<JugadorVO> listJ()
    {
        JugadorBO a = new JugadorBO();
        
        return a.list();
    }
    
     @WebMethod(operationName = "sumar")
    public int suma(@WebParam(name = "Vacio") int num)
    {
        
        return 1 + num;
    }
}
