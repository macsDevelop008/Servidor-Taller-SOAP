/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.DB.businessobject;
import com.grupo1.servidor_taller2.DB.Conection.ConnectionOracle;
import static com.grupo1.servidor_taller2.DB.Conection.ConnectionOracle.getInstance;
import com.grupo1.servidor_taller2.DB.valueobject.PersonajeVO;
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
public class PersonajeBO 
{
    public final static String NOMBRE_TABLA_SQL = "personaje";
    
    public boolean insert(PersonajeVO personajeVO) 
    {
        boolean result = false;
        
        String id = personajeVO.getId();
        String nombre = personajeVO.getNombre();
        Double fuerza = personajeVO.getFuerza();
        Double mana = personajeVO.getMana();
        Double energia = personajeVO.getEnergia();
        String idEspecie = personajeVO.getId_especie();
        String idJugador = personajeVO.getId_jugador();
        double estadoRegistro = personajeVO.getEstadoRegistro();
        Date fechaModificacion = personajeVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "INSERT INTO "+ NOMBRE_TABLA_SQL + 
                " VALUES("+id+","+"'"+nombre+"'"+","+
                fuerza+","+mana+","+energia+","+
                idEspecie+","+idJugador+","+estadoRegistro+","
                +"TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY'))";
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;
    }
    
    public boolean update(PersonajeVO personajeVO) 
    {
        boolean result = false;
        
        String id = personajeVO.getId();
        String nombre = personajeVO.getNombre();
        Double fuerza = personajeVO.getFuerza();
        Double mana = personajeVO.getMana();
        Double energia = personajeVO.getEnergia();
        String idEspecie = personajeVO.getId_especie();
        String idJugador = personajeVO.getId_jugador();
        double estadoRegistro = personajeVO.getEstadoRegistro();
        Date fechaModificacion = personajeVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "UPDATE " + NOMBRE_TABLA_SQL + " SET nombre='"+
                nombre+"'"+","+"fuerza="+fuerza+","+
                "mana="+mana+","+"energia="+energia+","+
                "id_especie='"+idEspecie+"'"+","+
                "id_jugador='"+idJugador+"'"+","+"estado_registro="+estadoRegistro+","+
                "fecha_modificacion="+"TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY')"+
                "WHERE id="+"'"+id+"'";
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;
    }
    
    public boolean delete(PersonajeVO personajeVO) 
    {
        boolean result = false;
        
        String id = personajeVO.getId();
        
        String sql = "DELETE FROM "+ NOMBRE_TABLA_SQL +" WHERE id ="+ "'"+id+"'";
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;
    }
    
    public ArrayList<PersonajeVO> list() 
    {
        ArrayList<PersonajeVO> result = new ArrayList<PersonajeVO>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL;
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = descomposeResultSet(conectionOracle.executeQueryStatement(sql));
        
        return result;
    }
    
    public PersonajeVO findById(PersonajeVO personajeVO) 
    {
        ArrayList<PersonajeVO> result = new ArrayList<PersonajeVO>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL + " WHERE id ="+ "'"+personajeVO.getId()+"'";
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance("miguel","123","xe");
        result = descomposeResultSet(conectionOracle.executeQueryStatement(sql));
        
        return result.get(0);
    }
    
    private ArrayList<PersonajeVO> descomposeResultSet(ResultSet resultSet)
    {
        ArrayList<PersonajeVO> result = new ArrayList<PersonajeVO>();
        
        String id;
        String nombre;
        Double fuerza;
        Double mana;
        Double energia;
        String idEspecie;
        String idJugador;        
        String estadoRegistro;
        Date fechaModificacion;
        
        try 
        {
            while(resultSet.next())
            {
                id = resultSet.getString(1);
                nombre = resultSet.getString(2);
                fuerza = resultSet.getDouble(3);
                mana = resultSet.getDouble(4);
                energia = resultSet.getDouble(5);
                idEspecie = resultSet.getString(6);
                idJugador = resultSet.getString(7);                
                estadoRegistro = resultSet.getString(8);
                fechaModificacion = resultSet.getDate(9);               
                
                result.add(new PersonajeVO(
                        id, 
                        nombre,
                        fuerza,
                        mana,
                        energia,
                        idEspecie,
                        idJugador,
                        Double.parseDouble(estadoRegistro), 
                        fechaModificacion));
            }
        } 
        catch (SQLException ex)
        {
            System.out.println("Error en descomposeResultSet: " + ex);
        }  
        return result;
    }
}
