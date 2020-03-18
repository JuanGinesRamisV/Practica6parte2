/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6parte2;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public abstract class Apuesta {

    private static int numApuestaGlobal = 0;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int numApuesta;

    public Apuesta() {
    }

    public Apuesta(String nombre, String apellido1, String apellido2) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNumApuesta(numApuestaGlobal++);
    }

    public Apuesta(Apuesta aux) {
        this.setNombre(aux.getNombre());
        this.setApellido1(aux.getApellido1());
        this.setApellido2(aux.getApellido2());
        this.setNumApuesta(aux.getNumApuesta());
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

    public void mostrarApuesta() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Primer apellido: " + this.getApellido1());
        System.out.println("Segundo apellido: " + this.getApellido2());
        System.out.println("Numero de apuesta: " + this.getNumApuesta());
    }

    public void solicitarDatos() throws ExcepcionSolicitarDatos {
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Introduce el nombre: ");
        String nombre = lector.nextLine();
        if (comprobarMayusculas(nombre) == false) {
            throw new ExcepcionSolicitarDatos();
        }
        System.out.println("Introducel el primer apellido: ");
        String apellido1 = lector.next();
        if (comprobarMayusculas(apellido1) == false) {
            throw new ExcepcionSolicitarDatos();
        }
        System.out.println("Introduce el segundo apellido: ");
        String apellido2 = lector.next();
        if (comprobarMayusculas(apellido2) == false) {
            throw new ExcepcionSolicitarDatos();
        }
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
    }

    public static boolean comprobarMayusculas(String aux) {
        char[] charArray = aux.toCharArray();
        int i = 0;
        boolean salir = false;
        boolean resultado = true;

        while (salir == false && i < charArray.length) {
            if (!Character.isUpperCase(charArray[i])) {
                resultado = false;
                salir = true;
            } else {
                i++;
            }
        }
        return resultado;
    }
}
