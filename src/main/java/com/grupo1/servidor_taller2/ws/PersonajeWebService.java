/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.ws;

import com.grupo1.servidor_taller2.DB.businessobject.PersonajeBO;
import com.grupo1.servidor_taller2.DB.valueobject.PersonajeVO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author migue
 */
@WebService(serviceName = "PersonajeWebService")
public class PersonajeWebService 
{

@WebMethod(operationName = "insertarPersonaje")
    public boolean insertP(@WebParam(name = "PersonajeVO") PersonajeVO personaje)
    {
        PersonajeBO a = new PersonajeBO();
        
        return a.insert(personaje);
    }
    
    @WebMethod(operationName = "actualizarPersonaje")
    public boolean updateP(@WebParam(name = "PersonajeVO") PersonajeVO personaje)
    {
        PersonajeBO a = new PersonajeBO();
        
        return a.update(personaje);
    }
    
    @WebMethod(operationName = "eliminarPersonaje")
    public boolean deleteP(@WebParam(name = "PersonajeVO") String id)
    {
        PersonajeBO a = new PersonajeBO();
        PersonajeVO personaje = new PersonajeVO();
        personaje.setId(id);
        return a.delete(personaje);
    }
    
    @WebMethod(operationName = "buscarporIdPersonaje")
    public PersonajeVO findByIdP(@WebParam(name = "PersonajeVO") String id)
    {
        PersonajeBO a = new PersonajeBO();
        PersonajeVO personaje = new PersonajeVO();
        personaje.setId(id);
        return a.findById(personaje);
    }
    
    @WebMethod(operationName = "listarPersonaje")
    public ArrayList<PersonajeVO> listP()
    {
        PersonajeBO a = new PersonajeBO();
        
        return a.list();
    }
}
