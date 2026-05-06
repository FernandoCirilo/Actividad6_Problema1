package Problema1.main;

import Problema1.coleccion.Fabrica;
import Problema1.excepciones.ExcepcionDeCostoFueraDeLimite;
import Problema1.excepciones.ExcepcionDeGeneroInvalido;
import Problema1.excepciones.ExcepcionDeNumeroDePiezasInvalido;
import Problema1.excepciones.ExcepcionDeTemporadaInvalida;
import Problema1.fabricaDeRopa.Lote;
import Problema1.fabricaDeRopa.Prenda;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Fabrica fabrica = new Fabrica("Textiles del Sur");
        Prenda prenda1= null;
        Prenda prenda2= null;
        Prenda prenda3= null;
        Lote lote1=null;
        Lote lote2=null;
        Lote lote3=null;


        try {
            prenda1 = new Prenda("Casual", "Algodón", 101f, "Masculino", "Invierno", 200f);
            prenda2 = new Prenda("Sport",  "Poliéster", 80f, "Mixto",    "Verano",   200f);
            prenda3 = new Prenda("Casual", "Poliester", 100.0f, "Femenino", "Verano", 200f);
            lote1 = new Lote(1, 100, LocalDate.of(2026,11,5), prenda1);
            lote2 = new Lote(2,  200, LocalDate.of(2026,11,5), prenda2);
            lote3 = new Lote(1, 200, LocalDate.of(2026,11,5), prenda1);

            fabrica.agregaPrenda(prenda1); // si llega aquí, ya es válida
            fabrica.agregaPrenda(prenda2);
            fabrica.agregaPrenda(prenda3);
            fabrica.agregaLote(lote1);
            fabrica.agregaLote(lote2);
            fabrica.agregaLote(lote3);

           // System.out.println(p1);
        } catch (ExcepcionDeGeneroInvalido e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionDeTemporadaInvalida e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionDeCostoFueraDeLimite e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionDeNumeroDePiezasInvalido e) {
            System.err.println(e.getMessage());
        }
        int a;
        a = fabrica.cantidadDeLotes();
        System.out.println(a);
        int b;
        b = fabrica.cantidadDePrendas();
        System.out.println(b);


        System.out.println(prenda1);

        float precioVentaPieza = lote1.getCalcularPrecioVentaPieza();
        System.out.println("Precio de venta por la prenda1");
        System.out.println(precioVentaPieza);

        float costoProduccion = lote1.getCalcularCostoProduccionLote();
        System.out.println("Costo de produccion del lote1 que contiene la prenda1");
        System.out.println(costoProduccion);

        float gananciaVentaLote = lote1.getCalcularGananciaVentaLote();
        System.out.println("Ganancia de la venta del lote1");
        System.out.println(gananciaVentaLote);

        System.out.println();
        System.out.println(prenda1);

        float precioVentaPieza2 = lote2.getCalcularPrecioVentaPieza();
        System.out.println("Precio de venta por la prenda1");
        System.out.println(precioVentaPieza2);

        float costoProduccion2 = lote2.getCalcularCostoProduccionLote();
        System.out.println("Costo de produccion del lote1 que contiene la prenda1");
        System.out.println(costoProduccion2);

        float gananciaVentaLote2 = lote2.getCalcularGananciaVentaLote();
        System.out.println("Ganancia de la venta del lote2");
        System.out.println(gananciaVentaLote2);

        //Prenda
        System.out.println();
        System.out.println("Son iguales prenda1 y prenda2: "+prenda1.equals(prenda2));
        System.out.println("Son iguales prenda1 y prenda3: "+prenda1.equals(prenda3));
        System.out.println("Hash prenda1: " + prenda1.hashCode());
        System.out.println("Hash prenda2: " + prenda2.hashCode());
        System.out.println("Hash prenda3: " + prenda3.hashCode());
        System.out.println("Comparando prenda1 con prenda2 por modelo:");
        System.out.println(prenda1.compareTo(prenda2));
        System.out.println("Comparando prenda1 con prenda3 por modelo:");
        System.out.println(prenda1.compareTo(prenda3));
        System.out.println("Comparando por costo prenda1 y prenda3:");
        System.out.println(new Prenda.ComparadorPrendaPorCosto().compare(prenda1, prenda3));
        System.out.println("Comparando por tela prenda1 y prenda3:");
        System.out.println(new Prenda.ComparadorPrendaTela().compare(prenda1, prenda3));

        //Lote
        System.out.println();
        System.out.println("Son iguales Lote1 y Lote3: "+lote1.equals(lote3));
        System.out.println("Son iguales lote1 y lote2: "+lote1.equals(lote2));
        System.out.println("Hash lote1: " + lote1.hashCode());
        System.out.println("Hash lote2: " + lote2.hashCode());
        System.out.println("Hash lote3: " + lote3.hashCode());
        System.out.println("Comparando lote1 con lote2 por numero de lote:");
        System.out.println(lote1.compareTo(lote2));
        System.out.println("Comparando lote1 con lote3 por numero de lote:");
        System.out.println(lote1.equals(lote3));
        System.out.println("Comparando por numero de piezas lote1 y lote2:");
        System.out.println(new Lote.ComparadorPorPiezas().compare(lote1, lote2));
        System.out.println("Comparando por fecha lote1 y lote2:");
        System.out.println(new Lote.ComparadorPorFecha().compare(lote1, lote2));


    }
}