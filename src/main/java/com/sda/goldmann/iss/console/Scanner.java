package com.sda.goldmann.iss.console;

public class Scanner {

    public int loadUserInput() {
        var scanner = new java.util.Scanner(System.in);
        String s = scanner.nextLine();
        // TODO: implement it using ENUM
        // TODO: Implement try catch mechanism - return default value

        return Integer.parseInt(s);
    }

}
