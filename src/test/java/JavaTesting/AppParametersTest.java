package JavaTesting;

import JavaTesting.Resources.AppParameters;
import org.junit.Assert;
import org.junit.Test;

public class AppParametersTest {
    public static final String DOMAIN_EXPECTED ="127.0.0.1";

    public static final String PORT_EXPECTED = "80";
    public static final String URL_EXPECTED= "https://"+DOMAIN_EXPECTED+":"+PORT_EXPECTED;
    @Test
    public void domainURLCorrect(){
        Assert.assertEquals("Retorna la prat FQDN",DOMAIN_EXPECTED, AppParameters.DOMAIN);
    }
    @Test
    public void correctPORT(){
        Assert.assertEquals("retorna el port correcte",PORT_EXPECTED,AppParameters.PORT);
    }
    @Test
    public void correctURL(){
        Assert.assertEquals("retorna la url de forma correcta",URL_EXPECTED,AppParameters.deployedURL());
    }
    @Test
    public void singletonCorrectness(){
        AppParameters inst1 =AppParameters.getInstance();

        AppParameters inst2 =AppParameters.getInstance();

        Assert.assertTrue("Comprovacio unicitat instancia del singleton",(inst1==inst2));
    }

}
