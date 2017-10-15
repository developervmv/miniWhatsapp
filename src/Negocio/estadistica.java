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
public class estadistica {
     Mail mail;
    
    
    
    
    	public estadistica() {
		//dcontactos = new Datos.contactos();
		mail = new Mail();
	}
        
    public void Analizar(String Opcion, String mensaje, String sCorreo) throws Exception {
        
        //	String[] lista = mensaje.split(",");
		switch (Opcion) {
		case Utils.estadistica_generar:
			//this.Guardar(new entidades.contactos(mensaje));
                      String men=  "<h1>Estadistica</h1><img src=\"http://jpgraph.net/features/src/new_pie1.php\" border=\"0\" alt=\"new_pie1.php\" align=\"left\">";
                         mail.SendMailHTML(sCorreo, "Lista de Bandeja de Entrada", men);
                         
			break;
		
		default:
			throw new Exception("Error no se reconoce la opcion que se envio");
		
                }
	}
    
    
    
}
