/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6parte2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juang
 */
public class SimulacionLoteria {

    private ArrayList<Primitiva> listaPrimitivas = new ArrayList<Primitiva>();
    private ArrayList<Quiniela> listaQuinielas = new ArrayList<Quiniela>();
    private int[] primitivaResultado = new int[6];
    private ArrayList<String> quinielaResultado = new ArrayList<String>();
    private int[] estadisticasPrimitiva;
    private int[] estadisticasQuiniela;

    public SimulacionLoteria() {
    }

    public int[] getEstadisticasPrimitiva() {
        return estadisticasPrimitiva;
    }

    public void setEstadisticasPrimitiva(int[] estadisticasPrimitiva) {
        this.estadisticasPrimitiva = estadisticasPrimitiva;
    }

    public int[] getEstadisticasQuiniela() {
        return estadisticasQuiniela;
    }

    public void setEstadisticasQuiniela(int[] estadisticasQuiniela) {
        this.estadisticasQuiniela = estadisticasQuiniela;
    }

    public int[] getPrimitivaResultado() {
        return primitivaResultado;
    }

    public void setPrimitivaResultado(int[] primitivaResultado) {
        this.primitivaResultado = primitivaResultado;
    }

    public ArrayList<String> getQuinielaResultado() {
        return quinielaResultado;
    }

    public void setQuinielaResultado(ArrayList<String> quinielaResultado) {
        this.quinielaResultado = quinielaResultado;
    }

    public ArrayList<Primitiva> getListaPrimitivas() {
        return listaPrimitivas;
    }

    public void setListaPrimitivas(ArrayList<Primitiva> listaPrimitivas) {
        this.listaPrimitivas = listaPrimitivas;
    }

    public ArrayList<Quiniela> getListaQuinielas() {
        return listaQuinielas;
    }

    public void setListaQuinielas(ArrayList<Quiniela> listaQuinielas) {
        this.listaQuinielas = listaQuinielas;
    }

    public static void mostrarMenu() {
        System.out.println("1) crear apuesta Primitiva");
        System.out.println("2) crear apuesta Quiniela");
        System.out.println("3) realizar simulación");
        System.out.println("4) salir");
    }

    public void realizarSimulacion() {
        Scanner lector = new Scanner(System.in);
        int i = 0;
        boolean salir = false;
        int[] primitivaGanadora = new int[6];
        ArrayList<String> quinielaGanadora = new ArrayList<String>();
        int[] estadisticasPrimitiva= new int[Primitiva.getNumerosPrimitiva()];
        int[] estadisticasQuiniela = new int[Quiniela.getNumerosQuiniela()];
        
        System.out.println("Introduce el numero de simulaciones a realizar");
        int numSimulaciones = lector.nextInt();
        while (salir == false && i < numSimulaciones) {
            primitivaGanadora = this.generarPrimitiva().clone();
            quinielaGanadora = new ArrayList<String>(this.generarQuiniela());
            for (int j = 0; j < this.getListaPrimitivas().size(); j++) {
                estadisticasPrimitiva[this.compararPrimitiva(this.getListaPrimitivas().get(j).getListaNum(), primitivaGanadora)]++;
            }
            
            
            for(int j=0;j<this.getListaQuinielas().size();j++){
                estadisticasQuiniela[this.compararQuiniela(this.getListaQuinielas().get(j).getApuestas(), quinielaGanadora)]++;
            }
            i++;
        }

        System.out.println("--------");
        System.out.println("---------");
        this.estadisticasSimulacion(estadisticasQuiniela,estadisticasPrimitiva);
    }

    public int[] generarPrimitiva() {
        //genero las primitivas
        int[] aux = new int[this.getPrimitivaResultado().length];
        for (int i = 0; i < this.getPrimitivaResultado().length; i++) {
            aux[i] = (int) Math.floor(Math.random() * 50);
        }
        return aux;
    }

    public int compararPrimitiva(int[] apuesta, int[] primitivaCorrecta) {
        int resultado = 0;
        int i = 0;

        for (i = 0; i < apuesta.length; i++) {
            if (apuesta[i] == primitivaCorrecta[i]) {
                resultado++;
            }
        }
        return resultado;
    }
    
    public ArrayList<String> generarQuiniela(){
        //genero las quinielas
        //math random 0 equivale a 1, 1 equivale a 2 y 3 equivale a x
        ArrayList<String> aux = new ArrayList<String>();
        int i;
        for(i=0;i<15;i++){
            int resultado=(int)Math.floor(Math.random()*3);
            if(resultado==0){
                aux.add("1");
            }else if(resultado==1){
                aux.add("2");
            }else if(resultado==2){
                aux.add("x");
            }
        }
        return aux;
    }
    
    public int compararQuiniela(ArrayList<String> quiniela,ArrayList<String> quinielaGanadora){
        int resultado=0;
        
        for(int i=0;i<quiniela.size();i++){
            if(quiniela.get(i).equals(quinielaGanadora.get(i))){
                resultado++;
            }
        }
        return resultado;
    }
    
    public void estadisticasSimulacion(int[] estadisticasQuiniela,int[] estadisticasPrimitiva){
        System.out.println("Quinielas: ");
        System.out.println("------------");
        for(int i=0;i<estadisticasQuiniela.length;i++){
            int aux=i+1;
            System.out.println("Hay "+estadisticasQuiniela[i]+" quinielas con "+
                    aux +" aciertos");
        }
        
        System.out.println("");
        System.out.println("Primitivas: ");
        System.out.println("-------------");
        for(int i=0; i<estadisticasPrimitiva.length;i++){
            int aux=i+1;
            System.out.println("Hay "+estadisticasPrimitiva[i]+" primitivas con"+
                    aux +" aciertos");
        }
        System.out.println("");
    }
}
