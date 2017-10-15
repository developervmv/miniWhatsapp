/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author usuario
 */

public class Mail { //200.87.228.58
    final String miCorreo = "grupo08sa";
	final String miContraseña = "grupo08grupo08";
	final String servidorSMTP ="mail.ficct.uagrm.edu.bo";// "virtual.fcet.uagrm.edu.bo";
	final String puertoEnvio = "25";
	final String dominio ="@mail.ficct.uagrm.edu.bo"; //"@virtual.fcet.uagrm.edu.bo";
	String mailReceptor = null;
	String asunto = null;
	String cuerpo = null;
	List<Integer> ListMessageId;

	public Mail() {
		ListMessageId = new ArrayList<>();
	}

	public void SendMail(String mailReceptor, String asunto, String cuerpo) {
		this.mailReceptor = mailReceptor;
		this.asunto = asunto;
		this.cuerpo = cuerpo;

		Properties props = new Properties();
		props.put("mail.smtp.user", miCorreo);
		props.put("mail.smtp.password", miContraseña);
		props.put("mail.smtp.host", servidorSMTP);
		props.put("mail.smtp.port", puertoEnvio);
		// props.put("mail.smtp.starttls.enable", "true");
		// props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.socketFactory.port", puertoEnvio);
		// props.put("mail.smtp.socketFactory.class",
		// "javax.net.ssl.SSLSocketFactory");
		// props.put("mail.smtp.socketFactory.fallback", "false");

		// SecurityManager security = System.getSecurityManager();

		try {
			Authenticator auth = new autentificadorSMTP();
			Session session = Session.getInstance(props, auth);
			// session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(cuerpo);
			msg.setSubject(asunto);
			msg.setFrom(new InternetAddress(miCorreo + dominio));
			msg.addRecipient(RecipientType.TO, new InternetAddress(mailReceptor));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}

	}

	private class autentificadorSMTP extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(miCorreo, miContraseña);
		}
	}
public void ReadMail() {

		try {
			Properties properties = new Properties();

			properties.setProperty("mail.pop3.host", servidorSMTP);
			properties.setProperty("mail.pop3.user", miCorreo);
			properties.setProperty("mail.pop3.port", "110");
			properties.setProperty("mail.pop3.password", miContraseña);

			Session session = Session.getDefaultInstance(properties);
			Store store = session.getStore("pop3");
			store.connect(servidorSMTP, miCorreo, miContraseña);
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_WRITE);
			Message[] messages = inbox.getMessages();
			System.out.println("Cantidad de correos: " + messages.length);
			for (Message message : messages) {
				boolean isMine = false;
				for (Address address : message.getFrom()) {
					System.out.println(address.toString());
					if (address.toString().equals(miCorreo + dominio)) {
						isMine = true;
					}
				}
				if ((!message.isSet(Flag.SEEN) || !message.isSet(Flag.ANSWERED)) && !isMine
						&& !ListMessageId.contains(message.getMessageNumber())) {

					System.out.println("/***************************************/");
					System.out.println("MessageNumber: " + message.getMessageNumber());
					System.out.println("SENT DATE:" + message.getSentDate());
					System.out.println("SUBJECT:" + message.getSubject());
					if (message.isMimeType("multipart/*")) {
						Object msgContent = message.getContent();
						if (msgContent instanceof Multipart) {

							Multipart multipart = (Multipart) msgContent;
							System.out.println("CONTENT: ");

							BodyPart bodyPart = multipart.getBodyPart(0);
							System.out.println(bodyPart.getContent());

							Analizar(message.getSubject(), bodyPart.getContent().toString(),
									message.getFrom()[0].toString());
                                              //  System.out.println("Mensaje:" + message.getFrom()[0].toString());
						}
					} else if (message.isMimeType("text/plain")) {
						System.out.println("CONTENT: " + message.getContent());

						Analizar(message.getSubject(), message.getContent().toString(),
								message.getFrom()[0].toString());
                                                
                                                //  System.out.println("Mensaje:" + message.getFrom()[0].toString());
						
					}
					ListMessageId.add(message.getMessageNumber());
					message.setFlag(Flag.SEEN, true);
					message.setFlag(Flag.ANSWERED, true);
				}
			}
			if (store != null) {
				store.close();
			}
//			if (inbox != null) {
//				inbox.close(true);
//			}

		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

	public void Analizar(String sAsunto, String sMensaje, String sCorreo) {
         //   if(!(sAsunto==null||sMensaje==null||sAsunto.compareTo("")==0||sMensaje.compareTo("")==0)){
		String[] split = sAsunto.split(" ");

		try {
			switch (split[0]) {
			/*case Utils.Almacen:
				Almacen almacen = new Almacen();
				almacen.Analizar(sAsunto, sMensaje, sCorreo);
				break;*/
			case Utils.estadistica:
				estadistica cliente = new estadistica();
				cliente.Analizar(sAsunto, sMensaje, sCorreo);
				break;
			case Utils.Reporte:
				reportes egresoAlmacen = new reportes();
				egresoAlmacen.Analizar(sAsunto, sMensaje, sCorreo);
				break;
			case Utils.Buzon:
				buzon ingresoAlmacen = new buzon();
				ingresoAlmacen.Analizar(sAsunto, sMensaje, sCorreo);
                                SendMail(sCorreo, "Peticion de Envio Exitoso", "Exitoso");
				break;
			case Utils.Contacto:
				contactos mantenimiento = new contactos();
				mantenimiento.Analizar(sAsunto, sMensaje, sCorreo);
                                SendMail(sCorreo, "Peticion de Envio Exitoso", "Exitoso");
				break;
			case Utils.Enviar:
				enviar en = new enviar();
				en.Analizar(sAsunto, sMensaje, sCorreo);
                                 SendMail(sCorreo, "Peticion de Envio Exitoso", "Exitoso");
				break;
			case Utils.Usuario:
				Usuario usuario = new Usuario();
				usuario.Analizar(sAsunto, sMensaje, sCorreo);
                                SendMail(sCorreo, "Peticion de Usuario Exitoso", "Exitoso");
				break;
                        case Utils.Imagenes:
				
                                SendMailHTML(sCorreo, "Ejemplos con Imagenes",Utils.Ejemplo_Imagenes);
                                
				break;
			default:
				SendMailHTML(sCorreo, "Correo de Ayuda", Utils.MenuAyuda);
				break;
			}
		} catch (Exception ex) {
                    System.out.println(ex);
			SendMailHTML(sCorreo, "Correo de Ayuda", Utils.MenuAyuda);
		}
           /* }else
            {
                System.out.println("Un Maldito null");
            }*/
	}
        
        
        	public void SendMailHTML(String mailReceptor, String asunto, String cuerpo) {
		this.mailReceptor = mailReceptor;
		this.asunto = asunto;
		this.cuerpo = cuerpo;

		Properties props = new Properties();
		props.put("mail.smtp.user", miCorreo);
		props.put("mail.smtp.password", miContraseña);
		props.put("mail.smtp.host", servidorSMTP);
		props.put("mail.smtp.port", puertoEnvio);
		// props.put("mail.smtp.starttls.enable", "true");
		// props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.socketFactory.port", puertoEnvio);
		// props.put("mail.smtp.socketFactory.class",
		// "javax.net.ssl.SSLSocketFactory");
		// props.put("mail.smtp.socketFactory.fallback", "false");

		// SecurityManager security = System.getSecurityManager();

		try {
			Authenticator auth = new autentificadorSMTP();
			Session session = Session.getInstance(props, auth);
			// session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
                        msg.setContent(cuerpo, "text/html; charset=utf-8");
			//msg.setText(cuerpo);
			msg.setSubject(asunto);
			msg.setFrom(new InternetAddress(miCorreo + dominio));
			msg.addRecipient(RecipientType.TO, new InternetAddress(mailReceptor));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}

	}
        
        
        public void ReadMailInicio() {

		try {
			Properties properties = new Properties();

			properties.setProperty("mail.pop3.host", servidorSMTP);
			properties.setProperty("mail.pop3.user", miCorreo);
			properties.setProperty("mail.pop3.port", "110");
			properties.setProperty("mail.pop3.password", miContraseña);

			Session session = Session.getDefaultInstance(properties);
			Store store = session.getStore("pop3");
			store.connect(servidorSMTP, miCorreo, miContraseña);
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_WRITE);
			Message[] messages = inbox.getMessages();
			System.out.println("Cantidad de correos: " + messages.length);
			for (Message message : messages) {
				boolean isMine = false;
				for (Address address : message.getFrom()) {
					System.out.println(address.toString());
					if (address.toString().equals(miCorreo + dominio)) {
						isMine = true;
					}
				}
				if ((!message.isSet(Flag.SEEN) || !message.isSet(Flag.ANSWERED)) && !isMine
						&& !ListMessageId.contains(message.getMessageNumber())) {

					//System.out.println("/***************************************/");
					//System.out.println("MessageNumber: " + message.getMessageNumber());
					//System.out.println("SENT DATE:" + message.getSentDate());
					//System.out.println("SUBJECT:" + message.getSubject());
					if (message.isMimeType("multipart/*")) {
						Object msgContent = message.getContent();
						if (msgContent instanceof Multipart) {

							Multipart multipart = (Multipart) msgContent;
							//System.out.println("CONTENT: ");

							BodyPart bodyPart = multipart.getBodyPart(0);
							//System.out.println(bodyPart.getContent());

							//Analizar(message.getSubject(), bodyPart.getContent().toString(),
							//		message.getFrom()[0].toString());
                                              //  System.out.println("Mensaje:" + message.getFrom()[0].toString());
						}
					} else if (message.isMimeType("text/plain")) {
						//System.out.println("CONTENT: " + message.getContent());

						//Analizar(message.getSubject(), message.getContent().toString(),
						//		message.getFrom()[0].toString());
                                                
                                                //  System.out.println("Mensaje:" + message.getFrom()[0].toString());
						
					}
					ListMessageId.add(message.getMessageNumber());
					message.setFlag(Flag.SEEN, true);
					message.setFlag(Flag.ANSWERED, true);
				}
			}
			if (store != null) {
				store.close();
			}
//			if (inbox != null) {
//				inbox.close(true);
//			}

		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}
}
