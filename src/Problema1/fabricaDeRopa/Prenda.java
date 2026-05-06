package Problema1.fabricaDeRopa;
import Problema1.excepciones.ExcepcionDeCostoFueraDeLimite;
import Problema1.excepciones.ExcepcionDeGeneroInvalido;
import Problema1.excepciones.ExcepcionDeTemporadaInvalida;

import java.util.Objects;
import java.util.Comparator;

public class Prenda implements Comparable<Prenda> {
    private String modelo;
    private String tela;
    private float costoProduccion;
    private String genero;
    private String temporada;
    private float costoMaximo;

    public Prenda(String modelo, String tela, float costoProduccion, String genero, String temporada, float costoMaximo)
            throws ExcepcionDeGeneroInvalido, ExcepcionDeTemporadaInvalida, ExcepcionDeCostoFueraDeLimite {

        if(!genero.equals("Masculino") && !genero.equals("Femenino") && !genero.equals("Mixto"))
            throw new ExcepcionDeGeneroInvalido("Género inválido: " + genero);

        if(!temporada.equals("Primavera") && !temporada.equals("Verano")
                && !temporada.equals("Otoño") && !temporada.equals("Invierno"))
            throw new ExcepcionDeTemporadaInvalida("Temporada inválida: " + temporada);

        if(costoProduccion > costoMaximo)
            throw new ExcepcionDeCostoFueraDeLimite("El costo supera el límite de " + costoMaximo);

        this.costoMaximo = costoMaximo;
        this.modelo = modelo;
        this.tela = tela;
        this.costoProduccion = costoProduccion;
        this.genero = genero;
        this.temporada = temporada;
    }
    public String getModelo() {return modelo;}
    public String getTela() {return tela;}
    public float getCostoProduccion() {return costoProduccion;}
    public String getGenero() {return genero;}
    public String getTemporada() {return temporada;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prenda prenda = (Prenda) o;
        return Float.compare(costoProduccion, prenda.costoProduccion) == 0 &&
                Objects.equals(modelo, prenda.modelo) &&
                Objects.equals(tela, prenda.tela) &&
                Objects.equals(genero, prenda.genero) &&
                Objects.equals(temporada, prenda.temporada);
    }
    @Override
    public int hashCode() {
        int result = Objects.hashCode(modelo);
        result = 31 * result + Objects.hashCode(tela);
        result = 31 * result + Float.hashCode(costoProduccion);
        result = 31 * result + Objects.hashCode(genero);
        result = 31 * result + Objects.hashCode(temporada);
        return result;
    }

    @Override
    public int compareTo(Prenda otra) {
        int r=0;
        if((r = this.modelo.compareTo(otra.modelo))!=0)
            return r;
        if ((r = this.tela.compareTo(otra.tela))!=0)
            return r;
        if((r = Float.compare(this.costoProduccion, otra.costoProduccion))!=0)
            return r;
        if((r = this.genero.compareTo(otra.genero))!=0)
            return r;
        return this.temporada.compareTo(otra.temporada);
    }
    public static class ComparadorPrendaPorCosto implements Comparator<Prenda> {
        @Override
        public int compare(Prenda a, Prenda b) {
            return Float.compare(a.getCostoProduccion(), b.getCostoProduccion());
        }
    }
    public static class ComparadorPrendaTela implements Comparator<Prenda> {
        @Override
        public int compare(Prenda a, Prenda b){
            return a.getTela().compareTo(b.getTela());
        }
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "modelo='" + modelo +
                ", tela='" + tela +
                ", costoProduccion=" + costoProduccion +
                ", genero='" + genero +
                ", temporada='" + temporada +
                '}';
    }
}
