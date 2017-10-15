/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Conexion;
import Datos.PantallaAyuda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class contactos {
     Datos.contactos dcontactos;
    Mail mail;
    
    
    
    
    	public contactos() {
		dcontactos = new Datos.contactos();
		mail = new Mail();
	}
        
    public boolean Guardar(entidades.contactos eUsuario) throws ClassNotFoundException, SQLException {
                 dcontactos.nombrecontac=eUsuario.getNombrecontac();
                dcontactos.correocontac=eUsuario.getCorreocontac();
                 dcontactos.correo=eUsuario.correo;
             //   dcontactos.iduser=eUsuario.getIduser();
		return dcontactos.GuardarContacto(dcontactos.correo);
	}
    
    
	
    public void Analizar(String Opcion, String mensaje, String sCorreo) throws Exception {
		switch (Opcion) {
		case Utils.Contacto_Crear:
			this.Guardar(new entidades.contactos(mensaje));
			break;
		/*case Utils.Usuario_Actualizar:
			this.Actualizar(new proyecto.tecno.entidades.Usuario(mensaje));
			break;
		case Utils.Usuario_Eliminar:
			this.Eliminar(Long.parseLong(mensaje));
			break;
		case Utils.Usuario_Ver:
			proyecto.tecno.entidades.Usuario eUsuario = this.Obtener(Long.parseLong(mensaje));
			mail.SendMail(sCorreo, Utils.Almacen_Ver, ObjectToString(eUsuario));
			break;*/
		case Utils.Contacto_Lista:
                      String[] nm = mensaje.split(",");
			List<Datos.contactos> eListUsuario = this.Listar(nm[0]);
                      
			mail.SendMail(sCorreo, "Lista de Contactos", ListObjectToString(eListUsuario));
			break;
		default:
			throw new Exception("Error no se reconoce la opcion que se envio");
		
                }
	}
    
           
        public List<Datos.contactos> Listar(String x) throws ClassNotFoundException, SQLException {
		List<Datos.contactos> eListUsuario = new ArrayList<Datos.contactos>();
		List<Object> listAux = new ArrayList<>();
                x=String.valueOf(obteneridcorreo(x));
                dcontactos.GuardarId(x);
		listAux = dcontactos.ListarParametro();

		if (listAux != null) {
			for (Object oAux : listAux) {
				eListUsuario.add((Datos.contactos) oAux);
			}
		}

		return eListUsuario;
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
        
        
        
    private String ListObjectToString(List<Datos.contactos> eListUsuario) {
		String result = "";

		for (Datos.contactos eUsuario : eListUsuario) {
			result = result + ObjectToString(eUsuario) + "\n";
		}
		return result;
	}
    private String ObjectToString(Datos.contactos eUsuario) {
		String result = "";

		result = result + eUsuario.nombrecontac+ ", ";
		result = result + eUsuario.correocontac;

		return result;
	}
}
