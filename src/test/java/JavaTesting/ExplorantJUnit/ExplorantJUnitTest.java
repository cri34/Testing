package JavaTesting.ExplorantJUnit;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ExplorantJUnitTest {
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test (expected = IllegalArgumentException.class)
    public void testjantIllegalArgumentException(){
        throw  new IllegalArgumentException();
    }
    @Test
    public void illegalParametersTest(){
        expected.expect(IllegalArgumentException.class);

        throw  new IllegalArgumentException();
    }

    @Test
    public void missatgeExcepcioTest(){
        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("the");
        throw new IllegalArgumentException("the exception");
    }
    @BeforeClass
    public static void executaUnCopPerClasseAbansDeQualsevolTest(){
        System.out.println("Abans d'execurar qualsevol test, un cop per classe");
    }
    @AfterClass
    public static void executaUnCopPerClasseDespresDeQualsevolTest(){
        System.out.println("Després d'execurar qualsevol test, un cop per classe");
    }
    @Before
    public void executaAbansDeCadaTest(){
        System.out.println("Abans d'executar qualsevol test, per a cada test");
    }

    @After
    public void executaDespresDeCadaTest(){
        System.out.println("Despres d'executar qualsevol test, per a cada test");
    }
    @Test
    public void assercionsDeJUnit(){
        assertEquals(5,2+3);

        assertFalse("fals es fals", false);
        assertFalse(3>5);
        assertTrue(5>3);

        int [] finsA10 = {1,2,3,4,5,6,7,8,9,10};
        int [] primers10  = {2,1,3,4,5,6,7,8,9,10};
        Arrays.sort(primers10);

        assertArrayEquals(finsA10,primers10);
        assertNotNull("un String buit no es null", "");
        assertNotNull( "");

        assertNotSame("un String buit no es null", "",null);
        assertNotSame( "",null);

        assertNull("Nomes null es considerat null", null);

        Object obj =null;
        assertSame(obj, null);
    }

    @Test
    public void assertThatAmbHamcrest(){
        assertThat("testetjant que 4+5 son 9 ",4+5, is(9));

        assertThat("fals es fals", false,equalTo(false));

        assertThat(false, is(false));

        assertThat("true es true", true,equalTo(true));

        assertThat(true, is(true));

        assertThat("un string buit no es null" , is(not(nullValue())));

        assertThat("Aixo es un text", containsString("un"));

        assertThat("Aixo es un text", endsWith("xt"));

        assertThat("Aixo es un text", startsWith("Ai"));
    }

}
