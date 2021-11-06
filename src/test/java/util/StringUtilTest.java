package util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeatStringOne() {

        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeatStringMultipleTimes() {

        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeatStringZeroTimes() {

        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes() {

        StringUtil.repeat("hola", -1);
    }

    @Test
    public void testStringIsNotEmpty() {
        Assert.assertFalse(StringUtil.isEmpty("Felipe"));
    }

    @Test
    public void emptyQuoteIsStringEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void nullIsStringEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void stringSpacesIsStringEmpty() {
        Assert.assertTrue(StringUtil.isEmpty("  "));
    }


}