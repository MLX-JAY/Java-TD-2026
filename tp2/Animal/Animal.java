package tp2.Animal;

// Question 1 : La classe de base Animal
public class Animal {
    protected String nom;
    protected int age;
    protected int santePhysique;
    // Ajout des attributs manquants demandés par l'énoncé
    protected int santeMentale;
    protected int energie;

    public Animal(String nom, int age) {
        this.nom = nom;
        this.age = age;
        // Initialisation à 100 pour la santé et l'énergie
        this.energie = 100;
        this.santePhysique = 100;
        this.santeMentale = 100;
    }

    public void communiquer() {
        energie = Math.max(energie - 1, 0); // Math.max empêche de descendre sous 0
        System.out.println(nom + " émet un son.");
    }

    public void manger() {
        // On utilise Math.min pour s'assurer que les valeurs ne dépassent pas 100
        santePhysique = Math.min(santePhysique + 10, 100);
        santeMentale = Math.min(santeMentale + 5, 100);
        energie = Math.min(energie + 10, 100);
        System.out.println(nom + " mange.");
    }

    public void jouer() {
        santeMentale = Math.min(santeMentale + 10, 100);
        energie = Math.max(energie - 20, 0);
        System.out.println(nom + " joue.");
    }

    public void dormir() {
        energie = Math.min(energie + 30, 100);
        santePhysique = Math.min(santePhysique + 5, 100);
        santeMentale = Math.min(santeMentale + 5, 100);
        System.out.println(nom + " dort.");
    }

    public boolean estSouffrant() {
        // Retourne true si au moins une statistique est sous la barre des 10
        return (santePhysique < 10 || santeMentale < 10 || energie < 10);
    }

    public String affichageEtat() {
        return "Nom : " + nom + "\n"
             + "Énergie : " + energie + "\n"
             + "Santé Physique : " + santePhysique + "\n"
             + "Santé Mentale : " + santeMentale + "\n";
    }
}



