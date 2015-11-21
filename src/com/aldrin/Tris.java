package com.aldrin;

/**
 * Created by aldrin on 20/11/15.
 */
public class Tris {
    private final int JUGADOR1 = 0;
    private final int JUGADOR2 = 1;
    private int turno;
    private Jugador[] jugadores = new Jugador[2];
    private Tablero tablero;
    private boolean ganador;

    public Tris(){
        tablero = new Tablero();
        jugadores[JUGADOR1] = new Humano(Ficha.Tipos.CRUZ); //Humano vs Humano o IA vs IA
        jugadores[JUGADOR2] = new IA(Ficha.Tipos.CIRCULO); //Humano vs Humano o IA vs IA
        turno = JUGADOR1;
        ganador = false;
    }

    private void mostrar(){
        tablero.imprimir();
        System.out.println("Turno jugador: "+(turno+1));
    }

    private void entradas(){
        jugadores[turno].turno(tablero);
        turno = turno == JUGADOR1 ? JUGADOR2:JUGADOR1;
    }

    private void proceso(){
        if(tablero.revisar()){
            ganador = true;
        }
    }

    private void fin(){
        System.out.println("Juego terminado !");
        System.out.println("Ganador: "+tablero.fichaEn(tablero.ultimoM).Caracter()+"'s");
    }

    public void iniciar(){
        while(!ganador){
            mostrar();
            entradas();
            proceso();
        }
        mostrar();
        fin();
    }
}
