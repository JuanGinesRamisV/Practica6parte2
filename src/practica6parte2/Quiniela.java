/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6parte2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juang
 */
public class Quiniela extends Apuesta {

    private ArrayList<String> apuestas = new ArrayList<String>();
    private final static int numerosQuiniela = 15;

    //constructor vacio
    public Quiniela() {
    }

    public static int getNumerosQuiniela() {
        return numerosQuiniela;
    }

    public ArrayList<String> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<String> apuestas) {
        this.apuestas = apuestas;
    }

    @Override
    public void solicitarDatos() throws ExcepcionSolicitarDatos {
        super.solicitarDatos();
    }

    public void crearApuestaQuiniela() {
        Scanner lector = new Scanner(System.in);
        String aux;
        boolean salir = false;
        for (int i = 0; i <= 14; i++) {
            int posicion=i+1;
            salir = false;
            while (salir == false) {
                System.out.println("introduce el valor de la posicion "+posicion);
                aux = lector.next();
                if (aux.equals("1") || aux.equals("x") || aux.equals("2")) {
                    this.getApuestas().add(aux);
                    salir = true;
                } else {
                    System.out.println("No se han introducido los datos"
                            + "como toca");
                }
            }
        }
    }

    @Override
    public void mostrarApuesta() {
        super.mostrarApuesta();
        for (int i = 0; i < this.getApuestas().size(); i++) {
            System.out.println(this.getApuestas().get(i));
        }
    }
}
