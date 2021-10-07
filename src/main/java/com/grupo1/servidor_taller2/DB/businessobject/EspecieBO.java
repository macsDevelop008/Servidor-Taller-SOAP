/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.DB.businessobject;

import com.grupo1.servidor_taller2.DB.Conection.ConnectionOracle;
import static com.grupo1.servidor_taller2.DB.Conection.ConnectionOracle.getInstance;
import com.grupo1.servidor_taller2.DB.valueobject.EspecieVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author migue
 */
public class EspecieBO 
{
    
    public final static String NOMBRE_TABLA_SQL = "especie";
    
    public boolean insert(EspecieVO especieVO) 
    {
        boolean result = false;

        String id = especieVO.getId();
        String nombre = especieVO.getNombre();
        double estadoRegistro = especieVO.getEstadoRegistro();
        Date fechaModificacion = especieVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "INSERT INTO " + NOMBRE_TABLA_SQL + " VALUES("+"'"+id+"'"+","+
                "'"+nombre+"'"+","+
                estadoRegistro+","+
                "TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY'))";
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;
    }
    
    public boolean update(EspecieVO especieVO) 
    {
        boolean result = false;
        
        String id = especieVO.getId();
        String nombre = especieVO.getNombre();
        double estadoRegistro = especieVO.getEstadoRegistro();
        Date fechaModificacion = especieVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "UPDATE " + NOMBRE_TABLA_SQL + " SET " + 
                        "nombre ="+"'"+nombre+"'"+","+ 
                        "estado_registro ="+ estadoRegistro +","+ 
                        "fecha_modificacion = TO_DATE("+"'"+strDateFormat+"'"+","+"'DD/MM/YYYY')"+ 
                        "WHERE id =" + "'"+id+"'";
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;
    }
    
    public boolean delete(EspecieVO especieVO) 
    {
        boolean result = false;
        
        String id = especieVO.getId();      
        
        String sql = "DELETE FROM "+ NOMBRE_TABLA_SQL +" WHERE id ="+ "'"+id+"'";
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;
    }
    
    public ArrayList<EspecieVO> list() 
    {
        ArrayList<EspecieVO> result = new ArrayList<EspecieVO>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL;
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = descomposeResultSet(conectionOracle.executeQueryStatement(sql));
        
        return result;
    }
    
    public EspecieVO findById(EspecieVO especieVO) 
    {
        ArrayList<EspecieVO> result = new ArrayList<EspecieVO>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL + " WHERE id ="+"'"+especieVO.getId()+"'";
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = descomposeResultSet(conectionOracle.executeQueryStatement(sql));
        
        return result.get(0);
    }
    
    private ArrayList<EspecieVO> descomposeResultSet(ResultSet resultSet)
    {
        ArrayList<EspecieVO> result = new ArrayList<EspecieVO>();
        
        String id;
        String nombre;
        String estadoRegistro;
        Date fechaModificacion;
        
        try 
        {
            while(resultSet.next())
            {
                //id = Integer.parseInt(resultSet.getString(1));
                id = resultSet.getString(1);
                nombre = resultSet.getString(2);
                estadoRegistro = resultSet.getString(3);
                fechaModificacion = resultSet.getDate(4);
                
                //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
                //Date date = dateFormat.parse(fechaModificacion);
                
                result.add(new EspecieVO(
                        id, 
                        nombre, 
                        Double.parseDouble(estadoRegistro), 
                        fechaModificacion));
            }
        } 
        catch(SQLException ex)
        {
            System.out.println("Error en descomposeResultSet: " + ex);
        }  
        return result;
    }
}
