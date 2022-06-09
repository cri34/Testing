package JavaTesting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegerStudyTest {
    @Test
    public void integerStudy(){
        Integer vuit = new Integer(8);
        Integer vint = new Integer("20");
        Integer tretze = 13;
        int esperat = 13;
        int minim= -2147483648;

        assertEquals("13==13" , esperat, tretze.intValue());
        assertEquals("20==20", 20,vint.intValue());
        assertEquals("minim int es -2147483648",minim,Integer.MIN_VALUE);
    }
    @Test
    public void integerComparationStudy(){
        Integer vuit = new Integer(8);
        Integer eight = new Integer("8");

        assertEquals("vuit == 8" , 8 ,vuit.intValue());
        assertEquals("eight == 8" , 8 ,eight.intValue());

        // assertTrue(vuit == eight);
        assertTrue(vuit.equals(eight));
    }
    @Test
    public void binaryStudy(){
        Integer dos = new Integer(2);

        String tipusPersones ="hi ha "+Integer.toBinaryString(dos)+" de persones";
        assertEquals(tipusPersones , 2, dos.intValue());
    }
}
