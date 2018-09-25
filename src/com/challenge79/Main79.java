package com.challenge79;

import com.util.Reader;

/**
 * A common security method used for online banking is to ask the user for three random characters from a passcode.
 * For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.
 * The text file, keylog.txt, contains fifty successful login attempts.
 * Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.
 */

public class Main79 {

    public static void main(String[] args) {


        String fileName = "/p079_keylog.txt";
        Reader reader = new Reader();

        Solver79 s = new Solver79();
        System.out.println("codes:");
        s.listCodes(reader.readResource(fileName));
        System.out.println("\nSolution:");
        s.solve(reader.readResource(fileName));
    }
}
