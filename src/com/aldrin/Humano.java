package com.aldrin;

/**
 * Created by aldrin on 14/08/15.
 */
public class Humano implements Jugador{
    Jugador.Tipos tipo; //Tipo de jugador
    Ficha.Tipos tficha; //Tipo de ficha a usar
    Tablero tActual; //Estado del tablero al turno

    public Humano(){
        tipo = Jugador.Tipos.HUMANO;
        tficha = Ficha.Tipos.CIRCULO;
    }

    public Humano(Ficha.Tipos t){
        tipo = Jugador.Tipos.HUMANO;
        tficha = t;
    }

    @Override
    public void movimiento() {
        if(!tActual.movimiento(Control.getMovimiento(), this)){
            System.out.println("Movimiento invalido.");
            movimiento();
        }
    }

    @Override
    public void turno(Tablero t) {
        tActual = t;
        movimiento();
    }

    @Override
    public Ficha.Tipos getTipo() {
        return tficha;
    }
}
