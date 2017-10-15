/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author usuario
 */
public class Utils {
    
	public static final String Usuario_Crear = "Usuario Crear";
	public static final String Usuario_Actualizar = "Usuario Actualizar";
	public static final String Usuario_Eliminar = "Usuario Eliminar";
	public static final String Usuario_Ver = "Usuario Ver";
	public static final String Usuario_Listar = "Usuario Listar";
	public static final String MenuAyuda = "<h1>***********Menu de Ayuda************</h1>"+ "\n"
			
			+ "<h2 style='color: #90caf9'>************Usuario*******************</h2>"+ "\n" 
			+ "<h3 style='color: #aed581'>1.- Usuario Crear </h3></br> "+ "\n" 
                        + "* Para Agregar un usuario Ejemplo Asunto:Usuario Crear Cuerpo:xy,1234,xy@dominio.com,2 donde esta enviando el nombre,contra,correo,2 si es normal y 1 si es Adm </br>"+ "\n" 
			+ "<h3 style='color: #aed581'>2.- Usuario Actualizar </h3></br>"+ "\n"
                        + "* Para Actualizar un usuario Ejemplo Asunto:Usuario Actualizar Cuerpo:xy,1234,xy@dominio.com donde esta enviando el nombre,contra,correo, se cambiara el nombre y contra de ese correo  </br>"+ "\n" 
			
			+ "<h3 style='color: #aed581'>3.- Usuario Eliminar </h3></br>"+ "\n" 
                        + "* Para Eliminar un usuario Ejemplo Asunto:Usuario Eliminar Cuerpo:xy@dominio.com  se eliminara la cuenta de ese correo  </br>"+ "\n" 
			
			+ "<h3 style='color: #aed581'>4.- Usuario Ver </h3></br>"+ "\n" 
			+ "<h3 style='color: #aed581'>5.- Usuario Listar </h3></br>" + "\n" 
                        + "* Te da toda la lista de usuarios Ejemplo Asunto: Usuario Listar </br>" + "\n" 
                        + "<h2 style='color: #90caf9'>************Mensaje*******************</h2>"+ "\n"
			+ "<h3 style='color: #aed581'>6.- Enviar Correo </h3></br>"+ "\n" 
                        + "* Puede enviar Correo Ejemplo Asunto: Enviar Correo Cuerpo=pjrances@gmail.com,hola rances,saludo,dota@dominio.com \n enviar Correo Destino, Mensaje, Asunto, Su Correo </br>"+ "\n" 
                        + "<h2 style='color: #90caf9'>************Ayuda*******************</h2>" + "\n"
                        + "<h3 style='color: #aed581'>7.- Imagenes Ejemplos </h3></br>"
                        + "<h2 style='color: #90caf9'>************Buzon*******************</h2>"+ "\n"
			+ "<h3 style='color: #aed581'>8.- Buzon Entrada </h3></br>"+ "\n" 
                        + "* Consultar Buzon de Entrada de un correo Ejemplo Asunto: Buzon Entrada Cuerpo: root@dominio.com </br>"+ "\n" 
			+ "<h3 style='color: #aed581'>9.- Buzon Salida </h3></br>"+ "\n"
                        + "* Consultar Buzon de Salida de un correo Ejemplo Asunto: Buzon Salida Cuerpo: root@dominio.com </br>"+ "\n" 
			+ "<h3 style='color: #aed581'>10.- Buzon Spam </h3></br>" + "\n"
                        + "* Consultar Spam de Entrada de un correo Ejemplo Asunto: Buzon Spam Cuerpo: root@dominio.com </br>"+ "\n" 
                        + "<h3 style='color: #aed581'>11.- Buzon Borradores </h3></br>" + "\n"
                         + "* Consultar Borradores de Entrada de un correo Ejemplo Asunto: Buzon Spam Cuerpo: root@dominio.com </br>"+ "\n" 
                        + "<h2 style='color: #90caf9'>************estadistica*******************</h2>"+ "\n"
			+ "<h3 style='color: #aed581'>12.- Estadistica Generar </h3> </br>"+ "\n"
                        + "*Consultar la Estadistica Ejemplo: Asunto Estadistica Generar </br>"+ "\n"
                        + "<h2 style='color: #90caf9'>************Reporte*******************</h2>"+ "\n"
			+ "<h3 style='color: #aed581'>13.- Reporte Generar </h3></br>"+ "\n"
                        + "* Generar Reporte Ejemplo Asunto: Reporte Generar </br>"+ "\n"
                        + "<h2 style='color: #90caf9'>************Contactos*******************</h2>"+ "\n"
			+ "<h3 style='color: #aed581'>14.- Contacto Crear </h3></br>"+ "\n"
                        + "*Crear un Contacto  Ejemplo Asunto: Contacto Crear  Cuerpo: marco,marco@hotmail.com,dota@dominio.com   \n donde enviar nombre de contacto, correo de contacto, y a quien pertenece el contacto </br>"+ "\n"
                        + "<h3 style='color: #aed581'>15.- Contacto Lista </h3></br>"+ "\n" 
                        + "* Para listar los contactos de un Correo Asunto: Contacto Lista Cuerpo: dota@dominio.com </br>"+ "\n" 
                ;
        
        
        public static final String Usuario = "Usuario";
        public static final String Enviar = "Enviar";
        
          public static final String Imagenes = "Imagenes";
        public static final String Enviar_enviarcorreo = "Enviar Correo";
         public static final String Enviar_Lista = "Enviar Lista";
         public static final String Ejemplo_Imagenes="<html>\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <title></title>\n" +
"    </head>\n" +
"    <body> <h1>Agregar Usuario</h1> </BR> <img src='http://devproyect.com/crearusuario.jpg'> </BR> "
                 + "<h1>Lista de Usuarios</h1> </BR> <img src='http://devproyect.com/usuarioListar.jpg'> </BR>"
                 + "<h1>Enviar Correo</h1> </BR> <img src='http://devproyect.com/EnviarCorreo.jpg'> </BR>"
                 + "<h1>Lista de Correos Enviados</h1> </BR> <img src='http://devproyect.com/ListaMensajesEnviados.jpg'> </BR>"
                 + "</body>\n" +
"</html>\n" +
"";
         
         
           public static final String Contacto = "Contacto";
         
        public static final String Contacto_Crear = "Contacto Crear";
	public static final String Contacto_Lista = "Contacto Lista";
        
        
         public static final String Buzon = "Buzon";
          public static final String Buzon_Entrada = "Buzon Entrada";
	  public static final String Buzon_Salida = "Buzon Salida";
          public static final String Buzon_Spam = "Buzon Spam";
           public static final String Buzon_Borrador = "Buzon Borradores";
          
           public static final String Reporte_Generar = "Reporte Generar";
           public static final String Reporte = "Reporte";
           
             public static final String estadistica = "Estadistica";
             public static final String estadistica_generar = "Estadistica Generar";
}
