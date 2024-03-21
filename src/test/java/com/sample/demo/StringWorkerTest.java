package com.sample.demo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringWorkerTest {

    //private instance
    private StringWorker stringWorkder = StringWorker.getInstance();


    //Exception case test
    @Test(expected = IllegalFormatStringException.class)
    public void shouldThrowExeception () throws IllegalFormatStringException {
        stringWorkder.replace("  ");
    }

    @Test(expected = IllegalFormatStringException.class)
    public void shouldThrowExeception1 () throws IllegalFormatStringException {
        stringWorkder.replace(null);
    }

    @Test(expected = IllegalFormatStringException.class)
    public void shouldThrowExeception2 () throws IllegalFormatStringException {
        stringWorkder.remove("adddddd$");
    }

    //replace case test

    //nothing to be replaced
    @Test
    public void replaceShouldSuccess () throws IllegalFormatStringException {
        String src = "aabbccdd";
        String dest = stringWorkder.replace(src);
        Assert.assertEquals(src, dest);
    }

    //replace from rear
    @Test
    public void replaceeShouldSuccess1 () throws IllegalFormatStringException {
        String src = "caabbccddd"; // caabbccc -> caabbb -> caaa -> c
        String dest = stringWorkder.replace(src);
        Assert.assertEquals("c", dest);
    }

    ////replace from head
    @Test
    public void replaceShouldSuccess2 () throws IllegalFormatStringException {
        String src = "cccbbdddf"; //bbbdddf ->adddf->acf
        String dest = stringWorkder.replace(src);
        Assert.assertEquals("acf", dest);
    }


    //replace from middle
    @Test
    public void replaceShouldSuccess3 () throws IllegalFormatStringException {
        String src = "cccbbeddabcdeeedd"; //bbbeddabcdeeedd ->  aeddabcdeeedd -> aeddabcdddd -> aeddabcc
        String dest = stringWorkder.replace(src);
        Assert.assertEquals("aeddabcc", dest);
    }

    @Test
    public void replaceShouldSuccess4() throws IllegalFormatStringException {
        //abcccbad -> abbbad ->aaad -> d
        Assert.assertEquals("d", stringWorkder.replace("abcccbad"));
    }

    //remove case test
    @Test
    public void removeShouldSuccess () throws IllegalFormatStringException {
        String src = "aabbccdd"; //aabbccdd
        String dest = stringWorkder.remove(src);
        Assert.assertEquals(src, dest);
    }

    @Test
    public void removeShouldSuccess1 () throws IllegalFormatStringException {
        String src = "caabbccddd"; //caabbcc
        String dest = stringWorkder.remove(src);
        Assert.assertEquals("caabbcc", dest);
    }

    @Test
    public void removeShouldSuccess2 () throws IllegalFormatStringException {
        String src = "cccbbdddf"; //cccbbdddf -> bbdddf -> bbf
        String dest = stringWorkder.remove(src);
        Assert.assertEquals("bbf", dest);
    }


    @Test
    public void removeShouldSuccess3 () throws IllegalFormatStringException {
        String src = "cccbbeddabcdeeedd"; // cccbbeddabcdeeedd -> bbeddabcdeeedd -> bbeddabcddd -> bbeddabc
        String dest = stringWorkder.remove(src);
        Assert.assertEquals("bbeddabc", dest);
    }

    @Test
    public void removeShouldSuccess4 () throws IllegalFormatStringException {
        //aabcccbbad -> aabbbad -> aaad -> d
        String dest = stringWorkder.remove("aabcccbbad");
        Assert.assertEquals("d", dest);
    }

    @Test
    public void removeShouldSuccess5 () throws IllegalFormatStringException {
        String dest = stringWorkder.remove("abcdd");
        Assert.assertEquals("abcdd", dest);
    }
}
