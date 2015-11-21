package com.aldrin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aldrin on 14/08/15.
 */
public class Control {
    public static Punto getMovimiento(){
        System.out.print(">");
        int x, y;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String entrada = br.readLine();

            if(entrada.length() == 3 && entrada.charAt(1) == ' ') {
                y = Integer.parseInt("" + entrada.charAt(0)) - 1;
                x = Integer.parseInt("" + entrada.charAt(2)) - 1;

                if (x <= 2 && x >= 0 && y <= 2 && y >= 0) {
                    return new Punto(x, y);
                }else{
                    System.out.println("Posicion fuera de rango.");
                    return getMovimiento();
                }

            } else {
                System.out.println("Error de formato.");
                System.out.println("Formato admitido: 'X Y'.");
                return getMovimiento();
            }
        }catch(IOException io){
            System.out.println("Error de entrada.");
            return getMovimiento();
        }
    }
}
