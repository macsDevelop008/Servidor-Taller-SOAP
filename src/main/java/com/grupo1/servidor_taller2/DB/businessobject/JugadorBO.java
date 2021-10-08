/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo1.servidor_taller2.DB.businessobject;
import com.grupo1.servidor_taller2.DB.Conection.ConnectionOracle;
import static com.grupo1.servidor_taller2.DB.Conection.ConnectionOracle.getInstance;
import com.grupo1.servidor_taller2.DB.valueobject.JugadorVO;
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
public class JugadorBO 
{
    public final static String NOMBRE_TABLA_SQL = "jugador";
    
    public boolean insert(JugadorVO jugadorVO) 
    {
        boolean result = false;
        
        String id = jugadorVO.getId();
        String cuenta = jugadorVO.getCuenta();
        String contraseña = jugadorVO.getContraseña();
        String apodo = jugadorVO.getApodo();
        String email = jugadorVO.getEmail();
        double estadoRegistro = jugadorVO.getEstadoRegistro();
        Date fechaModificacion = jugadorVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql = "INSERT INTO "+ NOMBRE_TABLA_SQL+ " VALUES("+ 
                id+","+"'"+cuenta+"'"+","+"'"+contraseña+"'"+
                ","+"'"+apodo+"'"+","+ "'"+email+"'"+","+ estadoRegistro+
                ","+ "TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY'))";
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance();
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;
    }
    
    public boolean update(JugadorVO jugadorVO) 
    {
        boolean result = false;
        
        String id = jugadorVO.getId();
        String cuenta = jugadorVO.getCuenta();
        String contraseña = jugadorVO.getContraseña();
        String apodo = jugadorVO.getApodo();
        String email = jugadorVO.getEmail();
        double estadoRegistro = jugadorVO.getEstadoRegistro();
        Date fechaModificacion = new Date();
                //jugadorVO.getFechaModificacion();
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDateFormat = dateFormat.format(fechaModificacion).trim();
        
        String sql ="UPDATE " + NOMBRE_TABLA_SQL + " SET cuenta = '"+ cuenta + "'" +
                ", contraseña =" + "'"+ contraseña +"'"+","+
                "apodo = '"+apodo+"'"+","+ "email = '"+email+"'"+","+ 
                "estado_registro ="+ estadoRegistro+","+
                "fecha_modificacion ="+ "TO_DATE('"+ strDateFormat +"'"+","+ "'DD/MM/YYYY')" +
                "WHERE id ="+ "'"+id+"'";
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance();
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;        
    }
    
    public boolean delete(JugadorVO jugadorVO) 
    {
        boolean result = false;
        
        String id = jugadorVO.getId();
        
        String sql = "DELETE FROM "+ NOMBRE_TABLA_SQL +" WHERE id ="+ "'"+id+"'";
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance();
        result = conectionOracle.executeUpdateStatement(sql);
        
        return result;
    }
    
    public ArrayList<JugadorVO> list() 
    {
        ArrayList<JugadorVO> result = new ArrayList<JugadorVO>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL;
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance();
        result = descomposeResultSet(conectionOracle.executeQueryStatement(sql));
        
        return result;
    }
    
    public JugadorVO findById(String id) 
    {
        ArrayList<JugadorVO> result = new ArrayList<JugadorVO>();
        
        String sql = "SELECT * FROM "+ NOMBRE_TABLA_SQL + " WHERE id ="+ "'"+id+"'";
        
        System.out.println(sql);
        ConnectionOracle conectionOracle = getInstance();
        result = descomposeResultSet(conectionOracle.executeQueryStatement(sql));
        
        return result.get(0);
    }
    
    private ArrayList<JugadorVO> descomposeResultSet(ResultSet resultSet)
    {
        ArrayList<JugadorVO> result = new ArrayList<JugadorVO>();
        
        String id;
        String cuenta;
        String contraseña;
        String apodo;
        String email;
        String estadoRegistro;
        Date fechaModificacion;
        
        try 
        {
            while(resultSet.next())
            {
                //id = Integer.parseInt(resultSet.getString(1));
                id = resultSet.getString(1);
                cuenta = resultSet.getString(2);
                contraseña = resultSet.getString(3);
                apodo = resultSet.getString(4);
                email = resultSet.getString(5);
                estadoRegistro = resultSet.getString(6);
                fechaModificacion = resultSet.getDate(7);               
                
                result.add(new JugadorVO(
                        id, 
                        cuenta,
                        contraseña,
                        apodo,
                        email,
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
