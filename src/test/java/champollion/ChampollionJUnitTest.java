package champollion;

import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Salle salle;
        Intervention i1;
        Intervention i2;
        Date d1 = new Date();
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                salle = new Salle("B001",30);
                i1 = new Intervention(salle, uml, untel, d1, 2, TypeIntervention.TD);
                i2 = new Intervention(salle, java, untel, d1, 6, TypeIntervention.TD);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testAjouteIntervention(){
            untel.ajouteIntervention(i1);
            untel.ajouteIntervention(i2);
            assertEquals(8, untel.heuresPlanifiees(), "L'enseignant doit avoir 8 heures planifiées");
        }
        
        @Test 
        public void testSousService(){
            untel.ajouteIntervention(i1);
            untel.ajouteEnseignement(uml, 0, 5, 0);
            //System.out.println("Heures prévues :" + untel.heuresPrevues());
            //System.out.println("Heures planifiées :" + untel.heuresPlanifiees());
            assertTrue(untel.enSousService());
        }
	
}
