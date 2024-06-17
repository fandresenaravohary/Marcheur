import com.MARCHEUR.Carte;
import com.MARCHEUR.Lieu;
import com.MARCHEUR.Marcheur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarcheurTest {
    private Carte carte;
    private Lieu HEI;
    private Lieu Pullman;
    private Lieu Balancoire;
    private Lieu ESTI;
    private Lieu Autre;

    @BeforeEach
    public void setUp() {
        carte = new Carte();

        HEI = new Lieu("HEI");
        Pullman = new Lieu("Pullman");
        Balancoire = new Lieu("Balancoire");
        ESTI = new Lieu("ESTI");
        Autre = new Lieu("Autre");

        HEI.ajouterChemin(Pullman);
        Pullman.ajouterChemin(HEI);
        Pullman.ajouterChemin(Balancoire);
        Pullman.ajouterChemin(Autre);
        Balancoire.ajouterChemin(Pullman);
        Balancoire.ajouterChemin(ESTI);
        ESTI.ajouterChemin(Balancoire);

        carte.ajouterLieu(HEI);
        carte.ajouterLieu(Pullman);
        carte.ajouterLieu(Balancoire);
        carte.ajouterLieu(ESTI);
        carte.ajouterLieu(Autre);
    }

    @Test
    public void testMarcherVersESTI() {
        Marcheur marcheur = new Marcheur(HEI, ESTI, carte);
        List<Lieu> parcours = marcheur.marcherVers();

        assertTrue(parcours.get(0).equals(HEI));

        assertTrue(parcours.get(parcours.size() - 1).equals(ESTI));
        for (Lieu lieu : parcours) {
            System.out.println(lieu.getNom());
        }
    }
}
