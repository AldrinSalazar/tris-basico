package com.aldrin;

/**
 * Created by aldrin on 14/08/15.
 */
public interface Jugador {
    enum Tipos {COMPUTADORA, HUMANO}  //Implementar humano vs humano y pc vs pc
    void movimiento();
    void turno(Tablero t);
    Ficha.Tipos getTipo();
}
