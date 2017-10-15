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
import java.util.List;

/**
 *
 * @author usuario
 */
public class buzon {
      Mail mail;
    
    
    
    
    	public buzon() {
		//dcontactos = new Datos.contactos();
		mail = new Mail();
	}
        
    public void Analizar(String Opcion, String mensaje, String sCorreo) throws Exception {
        
        	String[] lista = mensaje.split(",");
		switch (Opcion) {
		case Utils.Buzon_Entrada:
			//this.Guardar(new entidades.contactos(mensaje));
                      String men=  obtenerlista(lista[0],1);
                         mail.SendMailHTML(sCorreo, "Lista de Bandeja de Entrada", men);
                         
			break;
		case Utils.Buzon_Spam:
			  String menxy= obtenerlista(lista[0],3);
                        mail.SendMail(sCorreo, "Lista de Bandeja de Spam", menxy);
                        
			break;
		/*case Utils.Usuario_Eliminar:
			this.Eliminar(Long.parseLong(mensaje));
			break;*/
		case Utils.Buzon_Borrador:
			  String menxyx= obtenerlista(lista[0],4);
                        mail.SendMail(sCorreo, "Lista de Bandeja de Borrador", menxyx);
			break;
		case Utils.Buzon_Salida:
			//List<Datos.contactos> eListUsuario = this.Listar(mensaje);
			//mail.SendMail(sCorreo, "Lista de Contactos", ListObjectToString(eListUsuario));
                        String menx= obtenerlista(lista[0],2);
                        mail.SendMail(sCorreo, "Lista de Bandeja de Salida", menx);
                        
                        
			break;
		default:
			throw new Exception("Error no se reconoce la opcion que se envio");
		
                }
	}
    
    
    
        public String obtenerlista(String correo,int l) throws ClassNotFoundException, SQLException{
              correo=  correo.replace("\r\n", "");
            Object object = null;
            String cad="";
             int iddato=0;
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement("select * from mensaje where iduser=? and idtipomen=?");
		
                int k=obteneridcorreo(correo);
                
                
                obtenerparlista(preparedStatement,k,l);
		
		ResultSet resultSet = preparedStatement.executeQuery();
                
          
                
		 cad+="<table border=\"1\">"+
                         "    <tr>\n" +
"      <td>Correo</td>\n" +
"      <td>asunto</td>\n" +
"      <td>mensaje</td>\n" +
"    </tr>\n" ;
		while(resultSet.next()){
                   
                    
                    cad+="<tr>";
		    cad+="<td>"+resultSet.getString("correo")+"</td>";
                    cad+="<td>"+resultSet.getString("asunto")+"</td>";
                     cad+="<td>"+resultSet.getString("mensaje")+"</td>";
                    cad+="</tr>";
		}
                
                
                cad+="</table>";
		return cad;
        }
    
      protected void obtenerparlista(PreparedStatement preparedStatement,int idu,int idtm) throws SQLException {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 preparedStatement.setInt(1, idu);
                 preparedStatement.setInt(2, idtm);
                 
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
