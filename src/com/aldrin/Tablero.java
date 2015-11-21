package com.aldrin;

/**
 * Created by aldrin on 20/11/15.
 */
public class Tablero {
    private Ficha[][] fichas = new Ficha[3][3]; //Tablero
    public Punto ultimoM; //ultimo movimiento
    private Ficha.Tipos ultimoF;//tipo de ultimo movimiento
    private int movimientos; //cantidad de movimientos

    public Tablero(){
        int i, j;
        //Iniciar fichas
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                fichas[i][j] = new Ficha();
            }
        }
        movimientos = 0;
    }

    public void imprimir(){
        int i, j;

        System.out.println(" 1  2  3");

        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print("|"+fichas[i][j].Caracter()+"|");
            }
            System.out.print((i+1)+"\n");
        }
    }

    public boolean revisar(){
        int i;
        //Revisa la columna del ultimo movimiento
        for(i = 0; i < 3; i++){
            if(fichaEn(new Punto(ultimoM.getX(), i)).getTipo() != ultimoF)
                break;
            if(i == 2){
                return true;
            }
        }

        //revisa la fila
        for(i = 0; i < 3; i++){
            if(fichaEn(new Punto(i, ultimoM.getY())).getTipo() != ultimoF)
                break;
            if(i == 2){
                return true;
            }
        }

        //diagonal principal
        if(ultimoM.getX() == ultimoM.getY()){
            for(i = 0; i < 3; i++){
                if(fichaEn(new Punto(i, i)).getTipo() != ultimoF)
                    break;
                if(i == 2){
                    return true;
                }
            }
        }

        //diagonal secundaria
        for(i = 0; i < 3; i++){
            if(fichaEn(new Punto(i, 2-i)).getTipo() != ultimoF)
                break;
            if(i == 2){
                return true;
            }
        }

        //si se llega a 8 movimientos es un empate
        if(movimientos == 8){
            return true;
        }

        //Sigue sin ganador
        return false;
    }

    public Ficha fichaEn(Punto p){
        return fichas[p.getX()][p.getY()];
    }

    public boolean movimiento(Punto p, Jugador j){
        if(fichaEn(p).getTipo() == Ficha.Tipos.VACIO){
            ultimoM = p;
            ultimoF = j.getTipo();
            movimientos++;
            fichaEn(p).setTipo(j.getTipo());
            return true;
        }else {
            return false;
        }
    }
}
