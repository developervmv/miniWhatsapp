/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author usuario
 */
public class enviar {
        String codestino;
        String mensaje;
      //  String fecha;
        String asunto;
      //  Integer iduser;
       public  String correo;
    public enviar(String cadena){
    	String[] lista = cadena.split(",");
    	
    	this.setCodestino(lista[0]);
    	this.setMensaje(lista[1]);
    	
        this.setAsunto(lista[2]);
        this.correo=lista[3];
      /*  try{
            
            String x=lista[3];
          x=  x.replace("\r\n", "");
           // String ao=String.valueOf(cadena.charAt(cadena.length()-2))+String.valueOf(cadena.charAt(cadena.length()-1));
        this.setIduser(Integer.valueOf(x));
        }catch(Exception e)
                {
                    System.err.println(e);
                }*/
       // this.setFecha(lista[4]);
    	
    }
    public String getCodestino() {
        return codestino;
    }

    public String getMensaje() {
        return mensaje;
    }

   /* public String getFecha() {
        return fecha;
    }*/

    public String getAsunto() {
        return asunto;
    }

   /* public Integer getIduser() {
        return iduser;
    }*/

    public void setCodestino(String codestino) {
        this.codestino = codestino;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

  /*  public void setFecha(String fecha) {
        this.fecha = fecha;
    }
*/
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

   /* public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }*/
}
