package tp2.banque;

// Question 4 : Le Compte Bancaire de base
public class CompteBancaire {
    protected String titulaire;
    protected double solde;

    public CompteBancaire(String titulaire, double solde) {
        this.titulaire = titulaire;
        this.solde = solde;
    }

    public void deposer(double montant) {
        if(montant > 0) {
            solde += montant;
        }
    }

    public void retirer(double montant) {
        if (solde >= montant) {
            solde -= montant;
        } else {
            System.out.println("Fonds insuffisants");
        }
    }

    public String afficherSolde() {
        return "Titulaire : " + titulaire + " | Solde : " + solde;
    }
}