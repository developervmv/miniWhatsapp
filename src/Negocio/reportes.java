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
public class reportes {
      Mail mail;
    
    
    
    
    	public reportes() {
		//dcontactos = new Datos.contactos();
		mail = new Mail();
	}
        
    public void Analizar(String Opcion, String mensaje, String sCorreo) throws Exception {
        
        	String[] lista = mensaje.split(",");
		switch (Opcion) {
		case Utils.Reporte_Generar:
			//this.Guardar(new entidades.contactos(mensaje));
                      String men= GenerarReporte();
                         mail.SendMailHTML(sCorreo, "Lista de Bandeja de Entrada", men);
                         
			break;
		/*case Utils.Usuario_Eliminar:
			this.Eliminar(Long.parseLong(mensaje));
			break;
		case Utils.Usuario_Ver:
			proyecto.tecno.entidades.Usuario eUsuario = this.Obtener(Long.parseLong(mensaje));
			mail.SendMail(sCorreo, Utils.Almacen_Ver, ObjectToString(eUsuario));
			break;*/
		
		default:
			throw new Exception("Error no se reconoce la opcion que se envio");
		
                }
	}
    
        public String GenerarReporte() throws ClassNotFoundException, SQLException
        {
            String cad="";
             cad+= obtenerlista(2,"Bandeja de Entrada General");
              cad+= obtenerlista(1,"Bandeja de Salida General");
               cad+= obtenerlista(3,"Bandeja de Spam General");
               cad+= obtenerlista(4,"Bandeja de Borrador General");
             return cad;
           
        }
    
        public String obtenerlista(int l,String titulo) throws ClassNotFoundException, SQLException{
             // correo=  correo.replace("\r\n", "");
            Object object = null;
            String cad="";
             int iddato=0;
		PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement("select * from mensaje where idtipomen=?");
               
                obtenerparlista(preparedStatement,l);
		ResultSet resultSet = preparedStatement.executeQuery();
                cad+="<h1> "+titulo+" </h1>";
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
    
      protected void obtenerparlista(PreparedStatement preparedStatement,int idtm) throws SQLException {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
                 preparedStatement.setInt(1, idtm);
                 
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
