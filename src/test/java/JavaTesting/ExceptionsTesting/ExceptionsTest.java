package JavaTesting.ExceptionsTesting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionsTest {

    @Test(expected = NullPointerException.class)
    public void NullPointerTest(){
        Integer edat = null;

        String edatEnLletres = edat.toString();

        assertEquals(10,edatEnLletres);


    }

    @Test//(expected = NullPointerException.class)
    public void catchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres;

        try{
            edatEnLletres= edat.toString();

        }catch(NullPointerException npe){
            edat=18;
            edatEnLletres= edat.toString();

        }

        assertEquals("18",edatEnLletres);


    }
    @Test
    public void tryCatchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres="";
        String text="";

        try{
            edatEnLletres= edat.toString();

        }catch(NullPointerException npe){
            edat=18;
            edatEnLletres= edat.toString();

        }finally {
             text = "Edat == " + edatEnLletres;
        }

        assertEquals("Edat == 18",text);


    }
    @Test (expected = IllegalArgumentException.class)
    public void throwingIllegalArgumentExceptionTryCatchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres="";
        String text="";

        try{
            System.out.println("generam NullPointerException");
            edatEnLletres= edat.toString();

        }catch(NullPointerException npe){
            System.out.println("capturam la NullPointerException");
            System.out.println("lanzamos excepcion ");
            throw  new IllegalArgumentException("excepcion creada i lanzada ");

        }finally {
           System.out.println("codigo  cerrado");
        }
    }
    @Test (expected = NullPointerException.class)
    public void excepcioErronia(){
        Integer edat = null;
        String edatEnLletres="";
        String text;

        try{
            System.out.println("generam NullPointerException");
            edatEnLletres= edat.toString();
            throw  new IllegalArgumentException("excepcion creada i lanzada ");
        }catch(IllegalArgumentException iae){
            System.out.println("capturam la IllegalArgumentException");

        }finally {
            System.out.println("codigo  cerrado");
        }
    }
    @Test//(expected = NullPointerException.class)
    public void jugantAmbObjecteExcepcioTest(){
        Integer edat = null;
        String edatEnLletres;

        try{
            edatEnLletres= edat.toString();

        }catch(NullPointerException npe){
            edat=18;
            edatEnLletres= edat.toString();
            System.out.println("jugamos con objeto exception");

            System.out.println(npe.getMessage());
            System.out.println(npe.getStackTrace());
            npe.printStackTrace();

        }

        assertEquals("18",edatEnLletres);
    }
}
