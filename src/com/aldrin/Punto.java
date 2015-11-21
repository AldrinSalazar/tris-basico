package com.aldrin;

/**
 * Created by aldrin on 20/11/15.
 */
public class Punto {
    int x;
    int y;

    public Punto(int _x, int _y){
        x = _x;
        y = _y;
    }

    public Punto(){
        x = -1;
        y = -1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
