/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmail;
import Datos.datos;
import Negocio.Mail;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario
 */
public class GMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      /*  datos x=new datos();
        x.connectDatabase();*/
       
        Mail mail= new Mail();
        System.out.println("Servidor Corriendo");
        mail.ReadMailInicio();
        
        while (true) {
             mail.ReadMail();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GMail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
