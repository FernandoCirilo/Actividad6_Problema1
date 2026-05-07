package Problema1.coleccion;

import Problema1.fabricaDeRopa.Lote;
import Problema1.fabricaDeRopa.Prenda;
import java.util.ArrayList;

public class Fabrica {
    private String nombre;
    private ArrayList<Prenda> prendas;
    private ArrayList<Lote> lotes;

    public Fabrica(String nombre) {
        this.nombre = nombre;
        this.prendas = new ArrayList<>();
        this.lotes = new ArrayList<>();
    }

    public void agregaPrenda(Prenda prenda) {
        this.prendas.add(prenda);
    }

    public void agregaLote(Lote lote) {
        this.lotes.add(lote);
    }

    public int cantidadDePrendas() { return prendas.size(); }
    public int cantidadDeLotes()   { return lotes.size();   }

    public void mostrarPrendas(){
        System.out.println("--- Prendas en la fabrica ---");
        for (int i = 0; i < prendas.size(); i++)
            System.out.println(prendas.get(i));
    }

    public void mostrarLotes(){
        System.out.println("--- Lotes en la fabrica---");
        for(int i=0; i < lotes.size(); i++)
            System.out.println(lotes.get(i));
    }

}
