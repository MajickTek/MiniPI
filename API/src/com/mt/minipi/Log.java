package com.mt.minipi;

public class Log {
	public static boolean debug=false;
	
	public static void debug(String s) {
        if (debug) {
            System.out.println(s);
        }
    }

    public static void info(String s) {
        System.out.println(s);
    }

    public static void error(String s) {
        System.err.println(s);
    }
}
