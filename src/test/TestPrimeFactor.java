package test;

import com.util.PrimeFactor;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by gabor on 2018.02.24..
 */
public class TestPrimeFactor {

    @Test
    public void testFactor() {
        PrimeFactor p = new PrimeFactor(1000);

        List<Integer> factors = p.factor(644);
        assertEquals("size",4, factors.size());
        assertEquals("1.",2, factors.get(0).longValue());
        assertEquals("2.",2, factors.get(1).longValue());
        assertEquals("3.",7, factors.get(2).longValue());
        assertEquals("4.",23, factors.get(3).longValue());
    }

    @Test
    public void testDistinctFactor() {
        PrimeFactor p = new PrimeFactor(30);

        Set<Integer> factors = p.distinctFactor(644);
        assertEquals("size",3, factors.size());
        assertEquals("1.",true, factors.contains(23));
        assertEquals("2.",true, factors.contains(7));
        assertEquals("3.",true, factors.contains(2));
    }
}
