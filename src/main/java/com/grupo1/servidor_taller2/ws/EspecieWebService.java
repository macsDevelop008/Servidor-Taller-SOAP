/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.ws;

import com.grupo1.servidor_taller2.DB.businessobject.EspecieBO;
import com.grupo1.servidor_taller2.DB.valueobject.EspecieVO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author migue
 */
@WebService(serviceName = "EspecieWebService")
public class EspecieWebService {

    @WebMethod(operationName = "insertarEspecie")
    public boolean insertE(@WebParam(name = "EspecieVO") EspecieVO especie)
    {
        EspecieBO a = new EspecieBO();
        
        return a.insert(especie);
    }
    
    @WebMethod(operationName = "actualizarEspecie")
    public boolean updateE(@WebParam(name = "EspecieVO") EspecieVO especie)
    {
        EspecieBO a = new EspecieBO();
        
        return a.update(especie);
    }
    
    @WebMethod(operationName = "eliminarEspecie")
    public boolean deleteE(@WebParam(name = "EspecieVO") EspecieVO especie)
    {
        EspecieBO a = new EspecieBO();
        
        return a.delete(especie);
    }
    
    @WebMethod(operationName = "buscarporIdEspecie")
    public EspecieVO findByIdE(@WebParam(name = "EspecieVO") EspecieVO especie)
    {
        EspecieBO a = new EspecieBO();
        
        return a.findById(especie);
    }
    
    @WebMethod(operationName = "listarEspecies")
    public ArrayList<EspecieVO> listE(@WebParam(name = "Vacio") EspecieVO especie)
    {
        EspecieBO a = new EspecieBO();
        
        return a.list();
    }
}
