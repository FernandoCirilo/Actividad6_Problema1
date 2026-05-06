package Problema1.coleccion;

import Problema1.excepciones.ExcepcionDeCostoFueraDeLimite;
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


}
