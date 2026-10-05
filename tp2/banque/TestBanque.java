package tp2.banque;

public class TestBanque 
{
    public static void main(String[] args)
    {
        System.out.println("\n\n=== PARTIE 2 : COMPTES BANCAIRES ===");
        
        CompteBancaire compteClassique = new CompteBancaire("Alice", 1000);
        CompteEpargne compteEpargne = new CompteEpargne("Bob", 2000, 5.0); // Taux de 5%
        CompteCourant compteCourant = new CompteCourant("Charlie", 500, 200); // Découvert de 200 autorisé

        // Test compte classique (retrait impossible)
        System.out.println("--- Test Compte Bancaire Classique ---");
        System.out.println(compteClassique.afficherSolde());
        compteClassique.retirer(1500); // Doit afficher "Fonds insuffisants"
        
        // Test compte épargne (génération d'intérêts)
        System.out.println("\n--- Test Compte Épargne ---");
        System.out.println(compteEpargne.afficherSolde());
        compteEpargne.verserInterets(); // 5% de 2000 = 100
        System.out.println("Après versement des intérêts (attendu 2100) : " + compteEpargne.afficherSolde());

        // Test compte courant (test du découvert autorisé)
        System.out.println("\n--- Test Compte Courant ---");
        System.out.println(compteCourant.afficherSolde());
        compteCourant.retirer(600); // Autorisé : Le solde va passer à -100 (limite -200)
        System.out.println("Après retrait de 600 : " + compteCourant.afficherSolde());
        compteCourant.retirer(150); // Refusé : -100 - 150 = -250 (dépasse la limite de -200)
    }
}
