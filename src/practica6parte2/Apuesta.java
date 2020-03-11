/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6parte2;

/**
 *
 * @author juang
 */
public class Apuesta {
    private static int numApuestaGlobal=0;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int numApuesta;

    public Apuesta() {
        this.setNumApuesta(numApuestaGlobal++);
    }

    public Apuesta(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.numApuesta = numApuesta;
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNumApuesta(numApuestaGlobal++);
    }
    
    
    public static int getNumApuestaGlobal() {
        return numApuestaGlobal;
    }

    public static void setNumApuestaGlobal(int numApuestaGlobal) {
        Apuesta.numApuestaGlobal = numApuestaGlobal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getNumApuesta() {
        return numApuesta;
    }

    public void setNumApuesta(int numApuesta) {
        this.numApuesta = numApuesta;
    }
    
    
    
}
