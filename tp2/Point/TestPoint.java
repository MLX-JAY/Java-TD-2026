package tp2.Point;

public class TestPoint {
	public static void main(String[] args) 
    {
        System.out.println("\n\n=== PARTIE 3 : POINTS 2D ET 3D ===");
        
        Point2D p1 = new Point2D(1.0, 2.0);
        Point2D p2 = new Point2D(4.0, 6.0);
        
        Point3D p3 = new Point3D(1.0, 2.0, 3.0);
        Point3D p4 = new Point3D(4.0, 6.0, 5.0);

        System.out.println("--- Test en 2D ---");
        System.out.println("Distance entre p1(1,2) et p2(4,6) : " + p1.distance(p2)); // Attendu : 5.0
        
        System.out.println("\n--- Test en 3D ---");
        System.out.println("Distance entre p3(1,2,3) et p4(4,6,5) : " + p3.distance(p4));
        
        // Test de l'addition de deux Point3D avec la méthode héritée
        Point3D somme3D = p3.add(p4);
        System.out.println("Somme de p3 et p4 : (" + somme3D.getX() + ", " + somme3D.getY() + ", " + somme3D.getZ() + ")");
	}
}