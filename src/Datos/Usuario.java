/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Usuario extends PantallaAyuda{
  
    public String nombre;
    public String usuario;
    public String contra;
    public int idtipo;
  //  Conexion c= new Conexion();
    
    /*public String InsertarUsuario()
    {
        c.connectDatabase();
        
    }*/

    @Override
    protected String TableName() {
    return "usuariomen"  ;
    }

    @Override
    protected String InsertParameter1() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "nombre,contra,correo,idtipo" ;
    }

    @Override
    protected String InsertParameter2() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return "?,?,?,?";
    }

    @Override
    protected void InsertAgregarParametros(PreparedStatement preparedStatement) throws SQLException {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                preparedStatement.setString(1, this.nombre);
		preparedStatement.setString(2, this.usuario);
		preparedStatement.setString(3,this.contra);
                preparedStatement.setInt(4,this.idtipo);
    
    }

    @Override
    protected String UpdateParameter1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String UpdateParameter2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void UpdateAgregarParametros(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String DeleteParameter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void DeleteAgregarParametros(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String ObtenerParameter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void ObtenerAgregarParametros(PreparedStatement preparedStatement) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 // preparedStatement.set(0, this.usuario);
    }

    @Override
    protected Object ConvertTo(ResultSet resultSet) throws SQLException {
    Usuario eUsuario = new Usuario();
		
		eUsuario.nombre=resultSet.getString("nombre");
		eUsuario.usuario=resultSet.getString("correo");
		//eUsuario.contra="";
                
		
		return eUsuario;  
    }
    
    
}
