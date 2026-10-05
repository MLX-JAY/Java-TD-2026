package tp2.Animal;

// Question 2 : La sous-classe Chien
public class Chien extends Animal {
    public Chien(String nom, int age) {
        super(nom, age); // Appelle le constructeur de la classe parente Animal
    }

    @Override
    public void communiquer() {
        santeMentale = Math.min(santeMentale + 3, 100);
        energie = Math.max(energie - 2, 0);
        System.out.println(nom + " aboie.");
    }
}
