package com.challenge79;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gabor on 2017.06.08..
 */
public class Solver79 {

    public void solve(List<String> codes) {
        List<ArrayList<Integer>>  shortCodes = convertCodes(codes);

        for (Integer i = 100 ; i < 99999999; i++){
            ArrayList<Integer> longCode = cutCode(i.toString(), i.toString().length());

            if (!shortCodes.parallelStream().anyMatch(shortCode -> !testACode(shortCode, longCode))) {
                printCode(longCode);
                System.exit(0);
            }
        }
    }

    public void listCodes(List<String> codes) {
        for (String c : codes) {
            ArrayList<Integer>  code = cutCode(c, 3);
            printCode(code);
        }
    }

    private boolean testACode(ArrayList<Integer> shortCode, ArrayList<Integer> longCode) {
        int pos1 = longCode.indexOf(shortCode.get(0));
        int pos2 = longCode.indexOf(shortCode.get(1));
        int pos3 = longCode.indexOf(shortCode.get(2));

        return pos1 >= 0 && pos2 > pos1 && pos3 > pos2;
    }

    private  List<ArrayList<Integer>> convertCodes(List<String> codes) {
        return codes.stream().map(code -> cutCode(code,3)).collect(Collectors.toList());
    }

    private void printCode(ArrayList<Integer>  code) {
        System.out.println("");
        code.forEach(System.out::print);
    }

    private ArrayList<Integer> cutCode(String code, Integer len) {
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < len ; i++) {
            digits.add(i,  Character.getNumericValue(code.charAt(i)));
        }

        return digits;
    }

}
