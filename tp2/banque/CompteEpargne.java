package tp2.banque;

// Question 5 : Compte Épargne (génère des intérêts)
public class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(String titulaire, double soldeInitial, double tauxInteret) {
        super(titulaire, soldeInitial); // Appel à CompteBancaire
        this.tauxInteret = tauxInteret;
    }

    public void verserInterets() {
        double interets = solde * (tauxInteret / 100);
        deposer(interets); // On réutilise la méthode existante
    }
}