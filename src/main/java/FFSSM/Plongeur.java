package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Plongeur extends Personne {
    private int niveaux; 
    private List<Licence> mesLicences;
    
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome, int niveaux) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveaux = niveaux;
        mesLicences = new ArrayList<>();
    }

    public int getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(int niveaux) {
        this.niveaux = niveaux;
    }
     
    public void ajouteLicence(Licence licence){
        mesLicences.add(licence);
    }
    
    public Licence derniereLicence(){
        return mesLicences.get(mesLicences.size()-1);
    }
	
}
