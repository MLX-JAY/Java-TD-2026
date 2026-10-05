package tp2.Animal;

// Question 3 : La sous-classe Chat
public class Chat extends Animal {
    public Chat(String nom, int age) {
        super(nom, age);
    }

    @Override
    public void communiquer() {
        santeMentale = Math.min(santeMentale + 2, 100);
        energie = Math.max(energie - 1, 0);
        System.out.println(nom + " miaule.");
    }
}
