package com.sample.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class StringWorkerTest {

    private StringWorkder stringWorkder = new StringWorkder();


    //Exception case test
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeception () {
        stringWorkder.replaceConsecutiveString("  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeception1 () {
        stringWorkder.replaceConsecutiveString(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeception2 () {
        stringWorkder.replaceConsecutiveString("add233@dddd");
    }

    //replace case test

    //nothing to be replaced
    @Test
    public void replaceShouldSuccess () {
        String src = "aabbccdd";
        String dest = stringWorkder.replaceConsecutiveString(src);
        Assert.assertEquals(src, dest);
    }

    //replace from rear
    @Test
    public void replaceeShouldSuccess1 () {
        String src = "caabbccddd";
        String dest = stringWorkder.replaceConsecutiveString(src);
        Assert.assertEquals("c", dest);
    }

    ////replace from head
    @Test
    public void replaceShouldSuccess2 () {
        String src = "cccbbdddf";
        String dest = stringWorkder.replaceConsecutiveString(src);
        Assert.assertEquals("acf", dest);
    }


    //replace from middle
    @Test
    public void replaceShouldSuccess3 () {
        //aeddabcdd
        String src = "cccbbeddabcdeeedd";
        String dest = stringWorkder.replaceConsecutiveString(src);
        Assert.assertEquals("aeddabcc", dest);
    }

    @Test
    public void replaceShouldSuccess4() {
        Assert.assertEquals("d", stringWorkder.replaceConsecutiveString("abcccbad"));
    }

    //remove case test
    @Test
    public void removeShouldSuccess () {
        String src = "aabbccdd";
        String dest = stringWorkder.removeConsecutiveString3(src);
        Assert.assertEquals(src, dest);
    }

    @Test
    public void removeShouldSuccess1 () {
        String src = "caabbccddd";
        String dest = stringWorkder.removeConsecutiveString3(src);
        Assert.assertEquals("caabbcc", dest);
    }

    @Test
    public void removeShouldSuccess2 () {
        String src = "cccbbdddf";
        String dest = stringWorkder.removeConsecutiveString3(src);
        Assert.assertEquals("bbf", dest);
    }


    @Test
    public void removeShouldSuccess3 () {
        //aeddabcdd
        String src = "cccbbeddabcdeeedd";
        String dest = stringWorkder.removeConsecutiveString3(src);
        Assert.assertEquals("bbeddabc", dest);
    }

    @Test
    public void removeShouldSuccess4 () {
        String dest = stringWorkder.removeConsecutiveString3("aabcccbbad");
        Assert.assertEquals("d", dest);
    }
}
