/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;

public class Moniteur extends Personne {

    public int numeroDiplome;
    public ArrayList<Embauche> MesEmbauches;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
        MesEmbauches= new ArrayList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur, ou null
     */
    public Club employeurActuel() {
        int k = MesEmbauches.size()-1;
        if (MesEmbauches.size()==0)
        {
            return null;
        }
        else if (MesEmbauches.get(k).estTerminee())
        {
            return null;
        }
        else 
        {
            return MesEmbauches.get(k).getEmployeur();
        }
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
        Embauche e = new Embauche(debutNouvelle, this, employeur);
        MesEmbauches.add(e);
    }

    public ArrayList<Embauche> emplois() {
        return MesEmbauches;
    }
}
