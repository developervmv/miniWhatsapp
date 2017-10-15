/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class enviar extends PantallaAyuda{
    
    public int id;
     public   String codestino;
       public String mensaje;
       public String fecha;
       public String asunto;
    //  public Integer iduser;
       public String correo;
    @Override
    protected String TableName() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return "mensaje";
    }

    @Override
    protected String InsertParameter1() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return "correo,mensaje,asunto,fecha,iduser,idtipomen" ;
    }

    @Override
    protected String InsertParameter2() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "?,?,?,?,?,?";
    }

    @Override
    protected void InsertAgregarParametros(PreparedStatement preparedStatement) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             
                preparedStatement.setString(1, GlobalAyuda.correo);
		preparedStatement.setString(2, this.mensaje);
                preparedStatement.setString(3, this.asunto);
                preparedStatement.setDate(4, Date.valueOf("2017-01-10"));
                preparedStatement.setInt(5, GlobalAyuda.iduser);
                   preparedStatement.setInt(6, GlobalAyuda.x);
	//	preparedStatement.setInt(4, this.iduser);
            //    preparedStatement.setString(5, "'10/02/2016'");
		
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
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             return "iduser = ?";
    }

    @Override
    protected void ObtenerAgregarParametros(PreparedStatement preparedStatement) throws SQLException {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      preparedStatement.setInt(1, this.id);
    }

    @Override
    protected Object ConvertTo(ResultSet resultSet) throws SQLException {
       enviar eenviar = new enviar();
		
		eenviar.codestino=resultSet.getString("codestino");
		eenviar.mensaje=resultSet.getString("mensaje");
		eenviar.asunto=resultSet.getString("asunto");
		
		return eenviar;    
    }
    
    public void GuardarId(String x)
    {
         x=  x.replace("\r\n", "");
         id=Integer.valueOf(x);
    }
    
}
