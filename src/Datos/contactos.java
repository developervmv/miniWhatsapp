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
public class contactos extends PantallaAyuda{
 public String nombrecontac;
 public String correocontac;
 //public int iduser;
 public String correo;
 public int id;
    @Override
    protected String TableName() {
      return "contactomen"  ;   
    }

    @Override
    protected String InsertParameter1() {
      return "nombrecontac,correocontac,iduser" ;   
    }

    @Override
    protected String InsertParameter2() {
       return "?,?,?";
    }

    @Override
    protected void InsertAgregarParametros(PreparedStatement preparedStatement) throws SQLException {
         preparedStatement.setString(1, this.nombrecontac);
		preparedStatement.setString(2, this.correocontac);
		preparedStatement.setInt(3,GlobalAyuda.iduser);
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
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return "iduser = ?";
    }

    @Override
    protected void ObtenerAgregarParametros(PreparedStatement preparedStatement) throws SQLException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      preparedStatement.setInt(1, this.id);
    }

    @Override
    protected Object ConvertTo(ResultSet resultSet) throws SQLException {
       contactos econtactos = new contactos();
		
		econtactos.nombrecontac=resultSet.getString("nombrecontac");
		econtactos.correocontac=resultSet.getString("correocontac");
		//econtactos.iduser="";
		
		return econtactos;  
    }
       public void GuardarId(String x)
    {
         x=  x.replace("\r\n", "");
         id=Integer.valueOf(x);
    }
}
