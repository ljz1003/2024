package com.sample.demo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringWorkerTest {

    //private instance
    private StringWorker stringWorkder = new StringWorker();


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
        stringWorkder.replaceConsecutiveString("adddddd$");
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
        String src = "caabbccddd"; // caabbccc -> caabbb -> caaa -> c
        String dest = stringWorkder.replaceConsecutiveString(src);
        Assert.assertEquals("c", dest);
    }

    ////replace from head
    @Test
    public void replaceShouldSuccess2 () {
        String src = "cccbbdddf"; //bbbdddf ->adddf->acf
        String dest = stringWorkder.replaceConsecutiveString(src);
        Assert.assertEquals("acf", dest);
    }


    //replace from middle
    @Test
    public void replaceShouldSuccess3 () {
        String src = "cccbbeddabcdeeedd"; //bbbeddabcdeeedd ->  aeddabcdeeedd -> aeddabcdddd -> aeddabcc
        String dest = stringWorkder.replaceConsecutiveString(src);
        Assert.assertEquals("aeddabcc", dest);
    }

    @Test
    public void replaceShouldSuccess4() {
        //abcccbad -> abbbad ->aaad -> d
        Assert.assertEquals("d", stringWorkder.replaceConsecutiveString("abcccbad"));
    }

    //remove case test
    @Test
    public void removeShouldSuccess () {
        String src = "aabbccdd"; //aabbccdd
        String dest = stringWorkder.removeConsecutiveString3(src);
        Assert.assertEquals(src, dest);
    }

    @Test
    public void removeShouldSuccess1 () {
        String src = "caabbccddd"; //caabbcc
        String dest = stringWorkder.removeConsecutiveString3(src);
        Assert.assertEquals("caabbcc", dest);
    }

    @Test
    public void removeShouldSuccess2 () {
        String src = "cccbbdddf"; //cccbbdddf -> bbdddf -> bbf
        String dest = stringWorkder.removeConsecutiveString3(src);
        Assert.assertEquals("bbf", dest);
    }


    @Test
    public void removeShouldSuccess3 () {
        String src = "cccbbeddabcdeeedd"; // cccbbeddabcdeeedd -> bbeddabcdeeedd -> bbeddabcddd -> bbeddabc
        String dest = stringWorkder.removeConsecutiveString3(src);
        Assert.assertEquals("bbeddabc", dest);
    }

    @Test
    public void removeShouldSuccess4 () {
        //aabcccbbad -> aabbbad -> aaad -> d
        String dest = stringWorkder.removeConsecutiveString3("aabcccbbad");
        Assert.assertEquals("d", dest);
    }

    @Test
    public void removeShouldSuccess5 () {
        String dest = stringWorkder.removeConsecutiveString3("abcdd");
        Assert.assertEquals("abcdd", dest);
    }
}
