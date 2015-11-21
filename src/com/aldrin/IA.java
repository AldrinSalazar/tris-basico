package com.aldrin;

import java.util.Random;

/**
 * Created by aldrin on 14/08/15.
 */
public class IA implements Jugador {
    Random r;
    Jugador.Tipos tipo;
    Ficha.Tipos tficha;
    Tablero tActual;

    public IA(){
        r = new Random();
        tipo = Tipos.COMPUTADORA;
        tficha = Ficha.Tipos.CRUZ;
    }

    public IA(Ficha.Tipos t){
        r = new Random();
        tipo = Tipos.COMPUTADORA;
        tficha = t;
    }

    @Override
    public void movimiento() { //Algoritmo de inteligencia: todo al azar hasta encontrar un espacio vacio
        Punto p = new Punto(0, 0);

        while(tActual.fichaEn(p).getTipo() != Ficha.Tipos.VACIO){
            p.setX(r.nextInt(3));
            p.setY(r.nextInt(3));
        }

        tActual.movimiento(p, this);
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
