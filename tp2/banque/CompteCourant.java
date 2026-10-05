package tp2.banque;

// Question 6 : Compte Courant (autorise un découvert)
public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String titulaire, double soldeInitial, double decouvertAutorise) {
        super(titulaire, soldeInitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) {
        // Le nouveau solde (solde - montant) doit être supérieur ou égal à l'inverse du découvert (-decouvertAutorise)
        if (solde - montant >= -decouvertAutorise) {
            solde -= montant;
        } else {
            System.out.println("Plafond de découvert dépassé");
        }
    }
}