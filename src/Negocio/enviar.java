/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class enviar {
    Datos.enviar denviar;
     Mail mail;
     public enviar()
     {
         denviar= new Datos.enviar();
         mail= new Mail();
     }
     
      public boolean Guardar(entidades.enviar eenviar) throws ClassNotFoundException, SQLException {
               //  dUsuario.nombre=eUsuario.getNombre();
               // dUsuario.usuario=eUsuario.getUsuario();
               // dUsuario.contra=eUsuario.getContra();
		//return dUsuario.Guardar();
                
                denviar.asunto=eenviar.getAsunto();
                denviar.codestino=eenviar.getCodestino();
              //  denviar.fecha=eenviar.getFecha();
              //  denviar.iduser=eenviar.getIduser();
                denviar.mensaje=eenviar.getMensaje();
                denviar.correo=eenviar.correo;
                return denviar.Guardarenvio(denviar.correo, denviar.codestino);
                    
	}
      
        public void Analizar(String Opcion, String mensaje, String sCorreo) throws Exception {
		switch (Opcion) {
		case Utils.Enviar_enviarcorreo:
			this.Guardar(new entidades.enviar(mensaje));
                        
                        mail.SendMail(denviar.codestino, denviar.asunto, denviar.mensaje);
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
		case Utils.Enviar_Lista:
			List<Datos.enviar> eListUsuario = this.Listar(mensaje);
			mail.SendMail(sCorreo, "Mis Mensajes Enviados", ListObjectToString(eListUsuario));
			break;
		default:
			throw new Exception("Error no se reconoce la opcion que se envio");
		}
                
	}
        
        
        public List<Datos.enviar> Listar(String x) throws ClassNotFoundException, SQLException {
		List<Datos.enviar> eListUsuario = new ArrayList<Datos.enviar>();
		List<Object> listAux = new ArrayList<>();
                
                denviar.GuardarId(x);
		listAux = denviar.ListarParametro();

		if (listAux != null) {
			for (Object oAux : listAux) {
				eListUsuario.add((Datos.enviar) oAux);
			}
		}

		return eListUsuario;
	}
         private String ListObjectToString(List<Datos.enviar> elistenviar) {
		String result = "";

		for (Datos.enviar eUsuario : elistenviar) {
			result = result + ObjectToString(eUsuario) + "\n";
		}
		return result;
	}
    private String ObjectToString(Datos.enviar eenviar) {
		String result = "";

		result = result + eenviar.codestino+ ", ";
                result = result + eenviar.asunto+ ", ";
		result = result + eenviar.mensaje;

		return result;
	}
}
