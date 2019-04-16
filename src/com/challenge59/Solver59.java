package com.challenge59;


/**
 * Created by gabor on 2019.04.15..
 */
public class Solver59 {

    static String[] commonWords = {"the","and","that","have","with"};

    public void solve(String code) {

        for(int a = 97; a <=122; a++){
            for(int b = 97; b <=122; b++) {
                for(int c = 97; c <=122; c++){
                    StringBuilder sb = new StringBuilder("");
                    String pwd = sb.append((char) a).append((char) b).append((char) c).toString();
                    String decoded = dechyper(code, pwd);

                   if (isEnglish(decoded)) {
                        System.out.printf("pwd = %s; text = %s\n", pwd, decoded);
                        System.out.println("Solution = " + sumOfAsciiValues(decoded));
                    }

                }
            }
        }

    }

    int sumOfAsciiValues(String text) {
        int sum = 0;
        for (char c : text.toCharArray()) {
            sum += (int) c;
        }
        return sum;
    }

    boolean isEnglish(String text) {
        int counter = 0;
        for (String commonWord : commonWords) {
            if (text.contains(commonWord)) {
                counter++;
            }
        }

        return counter > 3 ? true : false;
    }

     String dechyper(String code,  String password) {
         int p = 0;
         char[] psw = password.toCharArray();
         StringBuilder sb = new StringBuilder("");

         for (String c : code.split(",")) {
             int ascii = (Integer.parseInt(c)) ^ ((int) psw[p++]) ;
             if (p == psw.length) p = 0;
             sb.append((char) ascii);
         }

         return sb.toString();

    }

    String chyper(String text, String password) {

        int p = 0;
        char[] psw = password.toCharArray();
        StringBuilder sb = new StringBuilder("");

        for (Character c : text.toCharArray()) {
            int code = ((int) c) ^ ((int) psw[p++]) ;
            if (p == psw.length) p = 0;
            sb.append(code).append(",");
        }

        return sb.toString();
    }

}
