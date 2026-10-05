package tp1;
public class Vecteur {
    int[] donnees;
    int taille;

    public Vecteur(int capacite) {
        if (capacite < 0) {
            throw new IllegalArgumentException("La capacite ne peut pas etre negative");
        }
        donnees = new int[capacite];
        taille = 0;
    }

    public Vecteur(int[] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau ne peut pas etre null");
        }
        donnees = tab;
        taille = tab.length;
    }

    public Vecteur(int[] tab, int i, int j) {
        if (tab == null) {
            throw new IllegalArgumentException("Le tableau ne peut pas etre null");
        }
        if (i < 0 || j < i || j > tab.length) {
            throw new IndexOutOfBoundsException("Intervalle [" + i + ", " + j + "[ invalide");
        }
        donnees = new int[j - i];
        System.arraycopy(tab, i, donnees, 0, j - i);
        taille = j - i;
    }

    public int getTaille() {
        return taille;
    }

    public void ajouter(int ind, int val) {
        if (ind < 0 || ind > taille) {
            throw new IndexOutOfBoundsException("Indice d'insertion invalide : " + ind);
        }
        if (taille == donnees.length) {
            throw new IllegalStateException("La capacite du vecteur est atteinte");
        }
        System.arraycopy(donnees, ind, donnees, ind + 1, taille - ind);
        donnees[ind] = val;
        taille++;
    }

    public void supprimer(int ind) {
        if (ind < 0 || ind >= taille) {
            throw new IndexOutOfBoundsException("Indice de suppression invalide : " + ind);
        }
        System.arraycopy(donnees, ind + 1, donnees, ind, taille - ind - 1);
        taille--;
        donnees[taille] = 0;
    }
    public int getVal(int i) {
        return donnees[i];
    }

    public void setVal(int i, int v) {
        donnees[i] = v;
    }
    public int somme() {
        int s = 0;
        for (int i = 0; i < taille; i++) {
            s += donnees[i];
        }
        return s;
    }

    public int min() {
        int minimum = donnees[0];
        for (int i = 1; i < taille; i++) {
            if (donnees[i] < minimum) {
                minimum = donnees[i];
            }
        }
        return minimum;
    }

    public void trier() {
        for (int i = 0; i < taille - 1; i++) {
            for (int j = i + 1; j < taille; j++) {
                if (donnees[i] > donnees[j]) {
                    int temp = donnees[i];
                    donnees[i] = donnees[j];
                    donnees[j] = temp;
                }
            }
        }
    }
    public String affichage() {
    if (taille == 0) {
        return "";
    }
    String res = "" + donnees[0];
    for (int i = 1; i < taille; i++) {
        res += "," + donnees[i];
    }
    return res;
    }

    // Question 14 : Renverse les éléments du vecteur courant
    public void reverse() {
        for (int i = 0; i < taille / 2; i++) {
            int temp = donnees[i];
            donnees[i] = donnees[taille - 1 - i];
            donnees[taille - 1 - i] = temp;
        }
    }

    // Question 15 : Renvoie l'indice de la dernière occurrence d'un entier, ou -1 si inexistant
    public int occ(int v) {
        int i = taille - 1;
        // On utilise un while (boucle non définie) plutôt qu'un for, comme demandé
        while (i >= 0 && donnees[i] != v) {
            i--;
        }
        return i; 
    }

    // Question 16 : Vérifie si tous les éléments sont strictement positifs
    public boolean proprieteUniverselle() {
        int i = 0;
        while (i < taille && donnees[i] > 0) {
            i++;
        }
        return i == taille;
    }

    // Question 17 : Vérifie si au moins un élément est négatif ou nul 
    // En utilisant l'indication mathématique ¬(∀e ∈ T, P(e)) ⇔ ∃e ∈ T, ¬P(e)
    public boolean proprieteExistentielle() {
        return !proprieteUniverselle(); 
    }

    // Question 18 : Recherche dichotomique (suppose que le vecteur est déjà trié)
    public int rechercheDico(int v) {
        int debut = 0;
        int fin = taille - 1;
        
        while (debut <= fin) {
            int milieu = (debut + fin) / 2;
            if (donnees[milieu] == v) {
                return milieu; // Élément trouvé
            } else if (donnees[milieu] < v) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }
        return -1; // Élément non trouvé
    }

    // Question 19 : Supprime toutes les occurrences d'un entier passé en paramètre
    public void supprAll(int v) {
        int index;
        // On utilise la méthode occ() (Q15) et la méthode supprimer() existante
        while ((index = occ(v)) != -1) {
            supprimer(index);
        }
    }
public static void main(String[] args) {
        // 1. Initialisation
        System.out.println("--- 1. INITIALISATION ET AJOUTS ---");
        Vecteur v = new Vecteur(10);
        v.ajouter(0, 4);
        v.ajouter(1, 9);
        v.ajouter(2, 6);
        v.ajouter(3, 9);
        v.ajouter(4, 9);
        v.ajouter(5, 5);
        System.out.println("Vecteur initial : " + v.affichage());
        System.out.println("Taille actuelle : " + v.getTaille());

        // 2. Tests des méthodes de base (Q8 à Q12)
        System.out.println("\n--- 2. OPÉRATIONS DE BASE ---");
        System.out.println("Valeur à l'indice 2 (getVal) : " + v.getVal(2)); // Doit afficher 6
        v.setVal(2, 7);
        System.out.println("Après setVal(2, 7) : " + v.affichage()); // Le 6 devient 7
        System.out.println("Somme des éléments : " + v.somme());
        System.out.println("Minimum du vecteur : " + v.min()); // Doit afficher 4

        // 3. Tests des propriétés booléennes (Q16 et Q17)
        System.out.println("\n--- 3. PROPRIÉTÉS ---");
        System.out.println("Tous strictement positifs ? (proprieteUniverselle) : " + v.proprieteUniverselle());
        System.out.println("Au moins un négatif ou nul ? (proprieteExistentielle) : " + v.proprieteExistentielle());
        
        // Ajout temporaire d'un négatif pour tester
        v.ajouter(6, -2);
        System.out.println("Après ajout de -2, au moins un négatif ? : " + v.proprieteExistentielle());
        v.supprimer(6); // On l'enlève pour la suite

        // 4. Test du reverse (Q14)
        System.out.println("\n--- 4. RENVERSEMENT ---");
        v.reverse();
        System.out.println("Après reverse() : " + v.affichage()); 

        // 5. Test des occurrences et suppressions (Q15 et Q19)
        System.out.println("\n--- 5. RECHERCHE ET SUPPRESSION ---");
        System.out.println("Dernière occurrence de 9 (occ) : " + v.occ(9));
        v.supprAll(9);
        System.out.println("Après supprAll(9) : " + v.affichage());

        // 6. Test du tri et de la recherche dichotomique (Q13 et Q18)
        System.out.println("\n--- 6. TRI ET RECHERCHE DICHOTOMIQUE ---");
        v.trier();
        System.out.println("Après trier() : " + v.affichage());
        System.out.println("Recherche dichotomique de 5 : trouvé à l'indice " + v.rechercheDico(5));
        System.out.println("Recherche dichotomique de 10 : trouvé à l'indice " + v.rechercheDico(10)); // Doit renvoyer -1
    }
}
