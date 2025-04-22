package com.main.medula.toolkit;

import java.util.Random;

public class Aleatorizador {

    public static final Random gerador = new Random();

    public static String aleatorizar(int size) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i<=size; i++)
        {
            builder.append((char) ('f' + Math.abs(gerador.nextInt() % 26)));
        }

        return builder.toString();
    }

}
