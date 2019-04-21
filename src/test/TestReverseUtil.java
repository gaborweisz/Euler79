package test;

import com.util.ReverseUtil;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by gabor on 2019.04.21..
 */
public class TestReverseUtil {

    @Test
    public void testReverse() {
        assertEquals("abc", ReverseUtil.reverse("cba"));
    }

    @Test
    public void testReverseInt() {
        assertEquals(new BigDecimal("123"), ReverseUtil.reverse(new BigDecimal("321")));
    }

    @Test
    public void testIsPalindrom() {
        assertEquals(true, ReverseUtil.isPalindrom("abcdcba"));
        assertEquals(false , ReverseUtil.isPalindrom("abcd"));
    }

    @Test
    public void testIsPalindromInt() {
        assertEquals(true, ReverseUtil.isPalindrom(new BigDecimal("121")));
        assertEquals(false , ReverseUtil.isPalindrom(new BigDecimal("123")));
    }
}
