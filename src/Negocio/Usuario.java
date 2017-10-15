/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Usuario {
    Datos.Usuario dUsuario;
    Mail mail;
    	public Usuario() {
		dUsuario = new Datos.Usuario();
		mail = new Mail();
	}
        
    public boolean Guardar(entidades.Usuario eUsuario) throws ClassNotFoundException, SQLException {
                 dUsuario.nombre=eUsuario.getNombre();
                dUsuario.usuario=eUsuario.getUsuario();
                dUsuario.contra=eUsuario.getContra();
                 dUsuario.idtipo=eUsuario.idtipo;
		return dUsuario.Guardar();
	}
    
    
	public List<Datos.Usuario> Listar() throws ClassNotFoundException, SQLException {
		List<Datos.Usuario> eListUsuario = new ArrayList<Datos.Usuario>();
		List<Object> listAux = new ArrayList<>();

		listAux = dUsuario.Listar();

		if (listAux != null) {
			for (Object oAux : listAux) {
				eListUsuario.add((Datos.Usuario) oAux);
			}
		}

		return eListUsuario;
	}
    public void Analizar(String Opcion, String mensaje, String sCorreo) throws Exception {
		switch (Opcion) {
		case Utils.Usuario_Crear:
			this.Guardar(new entidades.Usuario(mensaje));
			break;
		case Utils.Usuario_Actualizar:
			this.Actualizar(mensaje);
			break;
		case Utils.Usuario_Eliminar:
			this.Eliminar(mensaje);
			break;
		/*case Utils.Usuario_Ver:
			proyecto.tecno.entidades.Usuario eUsuario = this.Obtener(Long.parseLong(mensaje));
			mail.SendMail(sCorreo, Utils.Almacen_Ver, ObjectToString(eUsuario));
			break;*/
		case Utils.Usuario_Listar:
			List<Datos.Usuario> eListUsuario = this.Listar();
			mail.SendMail(sCorreo, "Lista Usuario", ListObjectToString(eListUsuario));
			break;
		default:
			throw new Exception("Error no se reconoce la opcion que se envio");
		
                }
	}
    private String ListObjectToString(List<Datos.Usuario> eListUsuario) {
		String result = "";

		for (Datos.Usuario eUsuario : eListUsuario) {
			result = result + ObjectToString(eUsuario) + "\n";
		}
		return result;
	}
    private String ObjectToString(Datos.Usuario eUsuario) {
		String result = "";

		result = result + eUsuario.nombre+ ", ";
		result = result + eUsuario.usuario;

		return result;
	}
    
    
    
    
    public boolean Eliminar(String mensaje) throws ClassNotFoundException, SQLException{
                   String consula= "delete from usuariomen where correo=?";
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(consula);
		InsertAgregarParametrosElimiar(preparedStatement,mensaje);
		return preparedStatement.executeUpdate() > 0;
	}
    
    
    
     protected void InsertAgregarParametrosElimiar(PreparedStatement preparedStatement,String mensaje) throws SQLException {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         mensaje=  mensaje.replace("\r\n", "");    	
         String[] lista = mensaje.split(",");   
             preparedStatement.setString(1,lista[0]);
                //primero su nombre despues su contra y luego su correo
    
    }

     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean Actualizar(String mensaje) throws ClassNotFoundException, SQLException{
             mensaje=  mensaje.replace("\r\n", "");
                   String consula= "update usuariomen set nombre=? , contra=? where correo=?";
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(consula);
		InsertAgregarParametros(preparedStatement,mensaje);
		return preparedStatement.executeUpdate() > 0;
	}
    
    
    
     protected void InsertAgregarParametros(PreparedStatement preparedStatement,String mensaje) throws SQLException {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             	String[] lista = mensaje.split(",");   
             preparedStatement.setString(1,lista[0]);
		preparedStatement.setString(2, lista[1]);
		preparedStatement.setString(3,lista[2]);
                //primero su nombre despues su contra y luego su correo
    
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
        
}
