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
public class Usuario {
  
    
        public String nombre;
    public String usuario;
    public String contra;
    public int idtipo;
public Usuario(String cadena){
    	String[] lista = cadena.split(",");
    	
    	this.setNombre(lista[0]);
    	this.setUsuario(lista[1]);
    	this.setContra(lista[2]);
          try{
            
            String x=lista[3];
          x=  x.replace("\r\n", "");
           // String ao=String.valueOf(cadena.charAt(cadena.length()-2))+String.valueOf(cadena.charAt(cadena.length()-1));
       this.idtipo=Integer.valueOf(x);
        }catch(Exception e)
                {
                    System.err.println(e);
                }
        
    	
    }
  

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
  

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }
}
