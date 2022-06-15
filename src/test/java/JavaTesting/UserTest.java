package JavaTesting;
import DomainEntities.User;
import org.junit.Test;

import static  org.junit.Assert.*;
public class UserTest {
    @Test
    public void contructUserTest(){
        User usuari = new User("Tomeu","secret");
        assertTrue(usuari!=null);
        assertEquals(usuari.getName(),"Tomeu");

        assertTrue(usuari.verifyPassword("secret"));
    }
}
