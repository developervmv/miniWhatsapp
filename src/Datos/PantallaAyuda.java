/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public abstract class PantallaAyuda {
    
    protected abstract String TableName();
	protected abstract String InsertParameter1();
	protected abstract String InsertParameter2();
	protected abstract void InsertAgregarParametros(PreparedStatement preparedStatement) throws SQLException;
	
	private String InsertSQL() {
		return "insert into " + TableName() + " (" + InsertParameter1() + ") values (" + InsertParameter2() + ");";
	}
	
	public boolean Guardar() throws ClassNotFoundException, SQLException{
                   String consula= InsertSQL();
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(consula);
		InsertAgregarParametros(preparedStatement);
		return preparedStatement.executeUpdate() > 0;
	}
        
        
        
        
	protected abstract String UpdateParameter1();
	protected abstract String UpdateParameter2();
	protected abstract void  UpdateAgregarParametros(PreparedStatement preparedStatement) throws SQLException;
	
	private String UpdateSQL(){
		
		return "update " + TableName() +" set " + UpdateParameter1() + " where " + UpdateParameter2();
	}
	
	public boolean Actualizar() throws ClassNotFoundException, SQLException{

		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(UpdateSQL());
		UpdateAgregarParametros(preparedStatement);
		return preparedStatement.executeUpdate() > 0;
	}
	
	protected abstract String DeleteParameter();
	protected abstract void DeleteAgregarParametros(PreparedStatement preparedStatement) throws SQLException;
	
	private String DeleteSQL(){
		
		return "delete from " + TableName() + " where " + DeleteParameter();
	}
	
	public boolean Eliminar() throws ClassNotFoundException, SQLException{

		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(DeleteSQL());
		DeleteAgregarParametros(preparedStatement);
		return preparedStatement.executeUpdate() > 0;
	}
	
        
	protected abstract String ObtenerParameter();
	protected abstract void ObtenerAgregarParametros(PreparedStatement preparedStatement) throws SQLException;
	
	private String ObtenerSQL(){
		
		return "select * from " + TableName() + " where " + ObtenerParameter(); 
	}
	protected abstract Object ConvertTo(ResultSet resultSet) throws SQLException;
	
	public Object Obtener() throws ClassNotFoundException, SQLException{
		Object object = null;
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(ObtenerSQL());
		ObtenerAgregarParametros(preparedStatement);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			object = ConvertTo(resultSet);
		}
		
		return object;
	}
	
        
        
        
        
        
        
        
        
        public boolean GuardarContacto(String correoowerx) throws ClassNotFoundException, SQLException{
              String consulax= InsertSQL();
		PreparedStatement preparedStatementx = Conexion.getInstance().getConnection().prepareStatement(consulax);
		int correoower=obteneridcorreo(correoowerx);
               // int correou=obteneridcorreo(correouser);
                GlobalAyuda.iduser=correoower;
                InsertAgregarParametros(preparedStatementx);
                
		return preparedStatementx.executeUpdate() > 0;
	}
        
        
        
        
        
        
        
        
        
	public boolean Guardarenvio(String correoowerx,String correouser) throws ClassNotFoundException, SQLException{
                   String consula= InsertSQL();
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(consula);
		//int correoower=obteneridcorreo(correoowerx);
                int correou=obteneridcorreo(correouser);
                GlobalAyuda.iduser=correou;
                GlobalAyuda.correo=correoowerx;
                GlobalAyuda.x=1;
                InsertAgregarParametros(preparedStatement);
                if(GlobalAyuda.iduser!=0)
                {
                 preparedStatement.executeUpdate();
                }
                
                  String consulax= InsertSQL();
		PreparedStatement preparedStatementx = Conexion.getInstance().getConnection().prepareStatement(consulax);
		int correoower=obteneridcorreo(correoowerx);
               // int correou=obteneridcorreo(correouser);
                GlobalAyuda.iduser=correoower;
                GlobalAyuda.correo=correouser;
                GlobalAyuda.x=2;
                InsertAgregarParametros(preparedStatementx);
                
		return preparedStatementx.executeUpdate() > 0;
	}
        
        
        
        
        
        
        
        public int obteneridcorreo(String correo) throws ClassNotFoundException, SQLException{
              correo=  correo.replace("\r\n", "");
            Object object = null;
             int iddato=0;
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement("select * from usuariomen where correo=?");
		obtenerpar(preparedStatement,correo);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
		     iddato=resultSet.getInt("iduser");
                  
		}
                
                
                
		return iddato;
        }
        
          protected void obtenerpar(PreparedStatement preparedStatement,String cor) throws SQLException {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 preparedStatement.setString(1, cor);
               }
        
        
        
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
	private String ListarSQL(){
		return "select * from " + TableName();
	}
	
	public List<Object> Listar() throws ClassNotFoundException, SQLException{
		List<Object> listObject = new ArrayList<>();
                String dona= ListarSQL();
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(dona);
		//ObtenerAgregarParametros(preparedStatement);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			listObject.add(ConvertTo(resultSet));
		}
		
		return listObject;
	}
        public List<Object> ListarParametro() throws ClassNotFoundException, SQLException{
		List<Object> listObject = new ArrayList<>();
                String dona= ObtenerSQL();
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(dona);
		ObtenerAgregarParametros(preparedStatement);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			listObject.add(ConvertTo(resultSet));
		}
		
		return listObject;
	}
}
