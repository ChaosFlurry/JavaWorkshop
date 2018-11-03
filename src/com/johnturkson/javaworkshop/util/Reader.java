package com.johnturkson.javaworkshop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String previous = null;
    
    public static String getInput() throws IOException {
        String input = reader.readLine().stripTrailing();
        previous = input;
        return input;
    }
    
    public static boolean hasPrevious() {
        return previous != null;
    }
    
    public static String getPrevious() {
        return previous;
    }
    
    public static void clearPrevious() {
        previous = null;
    }
}
