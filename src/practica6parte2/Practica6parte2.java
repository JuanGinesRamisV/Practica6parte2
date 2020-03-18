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
public class Practica6parte2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimulacionLoteria simulacion = new SimulacionLoteria();

        boolean salir = false;
        Scanner lector = new Scanner(System.in);
        int opcion;
       
        
        while (salir == false) {
            SimulacionLoteria.mostrarMenu();
            System.out.println("Introduce una opción: ");
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    Primitiva primitiva = new Primitiva();

                    try {
                        primitiva.solicitarDatos();
                    } catch (ExcepcionSolicitarDatos ex) {
                        System.out.println("No se ha podido realizar la op"
                                + "eración con exito introduce los nombres y apellidos "
                                + "en mayuscula la proxima vex");
                        break;
                    }

                    primitiva.crearApuestaPrimitiva();
                    simulacion.getListaPrimitivas().add(primitiva);
                    break;
                case 2:
                    Quiniela quiniela = new Quiniela();

                    try {
                        quiniela.solicitarDatos();
                    } catch (ExcepcionSolicitarDatos ex) {
                        System.out.println("No se ha podido realizar la op"
                                + "eración con exito introduce los nombres y apellidos "
                                + "en mayuscula la proxima vex");
                        break;
                    }

                    quiniela.crearApuestaQuiniela();
                    simulacion.getListaQuinielas().add(quiniela);
                    quiniela.mostrarApuesta();
                    break;
                case 3:
                    simulacion.realizarSimulacion();
                    break;
                case 4:
                    salir = true;
                    break;

            }
        }

    }
}
