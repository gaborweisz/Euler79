package com.challenge59;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gabor on 2019.04.16..
 */
public class Solver59Test {

    @Test
    public void testDechyper() {
        Solver59 solver59 = new Solver59();
        String text = "Two beer or not two beer, that is the question";

        //a-97
        //z-122

        String encoded = solver59.chyper(text, "pig");
        System.out.println(encoded);
        assertEquals(text, solver59.dechyper (encoded, "pig"));
    }
}
