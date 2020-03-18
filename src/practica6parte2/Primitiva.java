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
public class Primitiva extends Apuesta {

    private final static int numerosPrimitiva = 6;//para usar en la clase SimulacionLoteria
    private int listaNum[] = new int[numerosPrimitiva];
    private int aciertos = 0;

    public Primitiva() {
    }

    public static int getNumerosPrimitiva() {
        return numerosPrimitiva;
    }

    public int[] getListaNum() {
        return listaNum;
    }

    public void setListaNum(int[] listaNum) {
        this.listaNum = listaNum;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    @Override
    public void mostrarApuesta() {
        super.mostrarApuesta();
        System.out.println("Numeros de la apuesta: ");
        for (int i = 0; i < this.getListaNum().length; i++) {
            System.out.print(this.getListaNum()[i] + " ");
        }
        System.out.println("numero de aciertos: " + this.getAciertos());
    }

    @Override
    public void solicitarDatos() throws ExcepcionSolicitarDatos {
        super.solicitarDatos();
    }

    public void crearApuestaPrimitiva() {
        Scanner lector = new Scanner(System.in);
        int[] numeros = new int[this.getListaNum().length];
        int aux;
        boolean salir;

        for (int i = 0; i < numeros.length; i++) {
            salir = false;
            aux=i+1;
            System.out.println("Introduce el numero por el que quieres apostar"
                    + "en la posición " + aux);
            while (salir == false) {
                aux = lector.nextInt();
                if (aux >= 1 && aux <= 49) {
                    numeros[i] = aux;
                    salir = true;
                } else {
                    System.out.println("introduce un numero entre 1 y 49 ambos incluidos");
                }
            }
        }
        this.setListaNum(numeros.clone());
    }
}
