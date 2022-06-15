package JavaTesting.CollectionTesting;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SimpleCollectionTest {
    private List<String> diesSetmana;

    @Test
    public void firstCollectionTest(){
        String [] nombres={"zero","un","dos","tres"};
        List<String> numerals = new ArrayList<>();
        for (String s: nombres) {
            numerals.add(s);
        }
        numerals.add("quatre");
        assertTrue(numerals.size()==5);
        List<String> llistaNumeros = Arrays.asList(nombres);

        assertTrue(llistaNumeros.size()==4);
        }
        @Test
    public void diesSetmana(){
        List<String> diesSetmana= new ArrayList<>();
        List<String> diesFeiners= new ArrayList<>();
        List<String> diesCapDeSetmana= new ArrayList<>();
        List<String> diesSenars = new ArrayList<>();
        List<String> diesFeinersSenars = new ArrayList<>();
        List<String> calculDies = new ArrayList<>();

        initDiesFeiners(diesFeiners);
        assertTrue(diesFeiners.size()==5);
        assertEquals(0,diesSetmana.size());
        assertFalse(diesCapDeSetmana.containsAll(diesFeiners));

        diesSetmana.addAll(diesFeiners);

        assertEquals(5,diesSetmana.size());
        assertTrue(diesSetmana.containsAll(diesFeiners));

        diesCapDeSetmana.add("dissabte");
        diesCapDeSetmana.add("diumentge");

        diesSetmana.addAll(diesCapDeSetmana);

        assertEquals(7,diesSetmana.size());
        assertTrue(diesSetmana.containsAll(diesCapDeSetmana));


        diesSenars.addAll(diesSetmana);

        assertTrue(diesSenars.contains("dimarts"));

        diesSenars.remove(1);

        assertFalse(diesSenars.contains("dimarts"));

        diesSenars.remove("dijous");

        assertFalse(diesSenars.contains("dijous"));

        diesFeinersSenars.addAll(diesSenars);

        diesFeinersSenars.removeAll(diesCapDeSetmana);

        assertEquals(3,diesFeinersSenars.size());

        assertFalse(diesFeinersSenars.contains("dissabte"));

        calculDies.addAll(diesSetmana);

        assertTrue(calculDies.containsAll(diesFeiners));
        assertTrue(calculDies.containsAll(diesCapDeSetmana));

        calculDies.clear();

        assertTrue(calculDies.isEmpty());

        calculDies.addAll(diesSetmana);

        calculDies.removeAll(diesCapDeSetmana);

        assertEquals(5, calculDies.size());
        }
        @Test
        public void provesAmbMapsTest(){
            Map<String,String> map = new HashMap<>();
            map.put("fons","negre");
            map.put("menus","blau");
            map.put("dialeg","verd");

            assertEquals(map.size(),3);

            assertTrue(map.containsKey("menus"));
            assertTrue(map.containsValue("negre"));

            map.remove("dialeg");

            assertEquals(map.size(),2);

            map.remove("clauInexistent");

            assertEquals(map.size(),2);

            assertEquals(map.get("fons"),"negre");

        }
        public void initDiesFeiners(List<String> dies){
        dies.add("dilluns");
        dies.add("dimarts");
        dies.add("dimecres");
        dies.add("dijous");
        dies.add("divenres");

        }

        @Test
    public void provesSetTest(){
        Set<String> dies =new HashSet<>();

        dies.add("dilluns");
        dies.add("dilluns");
        dies.add("dilluns");

        assertEquals(dies.size(),1);

        }
}
