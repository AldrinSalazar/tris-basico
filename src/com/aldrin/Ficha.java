package com.aldrin;

/**
 * Created by aldrin on 14/08/15.
 */
public class Ficha {
    public enum Tipos {CRUZ, CIRCULO, VACIO}
    private Tipos tipo;

    public Ficha(Ficha.Tipos t){
        tipo = t;
    }

    public void setTipo(Ficha.Tipos t){
        tipo = t;
    }
    public Tipos getTipo(){ return tipo;}

    public Ficha(){
        tipo = Tipos.VACIO;
    }

    public char Caracter(){
        switch (tipo){
            case CIRCULO:
                return 'O';
            case  CRUZ:
                return 'X';
            case VACIO:
                return ' ';
            default:
                return 'E'; //error
        }
    }
}
