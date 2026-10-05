package tp1;
import java.util.Scanner;

public class Exercice3 
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("donne un nombre");
        int nombre;
        try {
            nombre = scan.nextInt();
        } catch (Exception e) {
            System.err.print(e.getMessage());
            return;
        }
        
        if (nombre > 0) {
            System.out.println("strictement positif");
        } else if (nombre < 0) {
            System.out.println("strictement négatif");
        } else {
            System.out.println("nul");
        }
        scan.close();
    }
}
