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
public class contactos {
     public String nombrecontac;
 public String correocontac;
 //public int iduser;
public String correo;
 
 public contactos(String cadena){
    	String[] lista = cadena.split(",");
    	
    	this.setNombrecontac(lista[0]);
    	this.setCorreocontac(lista[1]);
       this.correo=lista[2];
       /*  try{
            
            String x=lista[2];
          x=  x.replace("\r\n", "");
           // String ao=String.valueOf(cadena.charAt(cadena.length()-2))+String.valueOf(cadena.charAt(cadena.length()-1));
        this.setIduser(Integer.valueOf(x));
        }catch(Exception e)
                {
                    System.err.println(e);
                }*/
    	
    }

    public void setNombrecontac(String nombrecontac) {
        this.nombrecontac = nombrecontac;
    }

    public void setCorreocontac(String correocontac) {
        this.correocontac = correocontac;
    }

  /*  public void setIduser(int iduser) {
        this.iduser = iduser;
    }*/

    public String getNombrecontac() {
        return nombrecontac;
    }

    public String getCorreocontac() {
        return correocontac;
    }

/*    public int getIduser() {
        return iduser;
    }*/
}
