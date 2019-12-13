package fr;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marie
 */
public class TestClub {
    public ArrayList<Plongee> PlongeeOrganisee;
    
    public Moniteur moniteur;
     
    public Club club;
    
    public Plongee plongee;
    
    public Site site;
    
    public Plongeur plongeur;
    
    public Licence licence;
    
    public Licence licence2;
    
    public Plongeur plongeur2;
    
    public Embauche embauche;
    
    public ArrayList<Embauche> MesEmbauches;

    @Before
    public void setUp() {
        moniteur = new Moniteur("0022", "DON", "Marie-Laure", "Castres", "1234", Calendar.getInstance(), 4);
        PlongeeOrganisee = new ArrayList<>();
        plongeur=new Plongeur("0011","FAUCHER","Jonathan","Castres","8910",Calendar.getInstance(),6,2);
        licence=new Licence(plongeur,"001",Calendar.getInstance(),2,club);
        club= new Club(moniteur, "H2O", "5678");
        site= new Site("Isis","Pisicne");
        plongee = new Plongee(site, moniteur, Calendar.getInstance(),0,0);

        plongeur.ajouteLicence(licence);
        plongee.ajouteParticipant(plongeur);
        
        embauche = new Embauche(Calendar.getInstance(),moniteur,club);
    }   
    
    @Test
    public void TestEstConformes(){
        assertEquals(true,plongee.estConforme());
        
      plongeur2=new Plongeur("0011","FAU","Jonh","Castres","8910",Calendar.getInstance(),6,2);
      Calendar k = Calendar.getInstance();
      k.add(Calendar.YEAR, -61);
      licence2=new Licence(plongeur2,"002",k,2,club);
      plongeur2.ajouteLicence(licence2);
      plongee.ajouteParticipant(plongeur2);
       
      assertEquals(false,plongee.estConforme());
        
        
    }
    
    @Test
    public void TestNouvelleEmbauche(){
        moniteur.nouvelleEmbauche(club, Calendar.getInstance());
        ArrayList<Embauche> essai = new ArrayList<>();
        assertEquals(1,moniteur.emplois().size());  
        assertEquals(club,moniteur.employeurActuel());
    }
    
    @Test
    public void TestEmployeurActuel(){
        ArrayList<Embauche> essai2 = new ArrayList<>();
        assertEquals(null,moniteur.employeurActuel());
        moniteur.nouvelleEmbauche(club,Calendar.getInstance());
        moniteur.emplois().get(0).terminer(Calendar.getInstance());
        assertEquals(null,moniteur.employeurActuel());
       
    }
    
    @Test
    public void TestPlongeeNonConformes(){
        plongeur2=new Plongeur("0011","FAU","Jonh","Castres","8910",Calendar.getInstance(),6,2);
      Calendar k = Calendar.getInstance();
      k.add(Calendar.YEAR, -61);
       licence2=new Licence(plongeur2,"002",k,2,club);
      plongeur2.ajouteLicence(licence2);
      plongee.ajouteParticipant(plongeur2);
      club.organisePlongee(plongee);
       assertTrue(club.plongeesNonConformes().contains(plongee));
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
