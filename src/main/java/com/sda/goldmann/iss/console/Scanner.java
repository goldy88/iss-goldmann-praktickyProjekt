package com.sda.goldmann.iss.console;

public class Scanner {


    public int loadUserInput(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String s = scanner.nextLine();


        return Integer.parseInt(s);
    }


}
