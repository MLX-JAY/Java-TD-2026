package tp2.Point;
// Question 8 : Point en 3 dimensions (Héritage)
public class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y); // Initialise le x et le y en appelant Point2D
        this.z = z;
    }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    @Override
    public double dot(Point2D other) {
        // L'astuce fournie permet d'extraire le Z si "other" est un Point3D, sinon on lui donne 0.0
        double otherZ = (other instanceof Point3D) ? ((Point3D) other).getZ() : 0.0;
        // On fait le produit scalaire 2D (super.dot) auquel on ajoute le produit de la profondeur Z
        return super.dot(other) + (this.z * otherZ);
    }

    @Override
    public Point3D add(Point2D other) {
        double otherZ = (other instanceof Point3D) ? ((Point3D) other).getZ() : 0.0;
        // On additionne x et y séparément, et z avec otherZ
        return new Point3D(super.getX() + other.getX(), super.getY() + other.getY(), this.z + otherZ);
    }

    @Override
    public double distance(Point2D other) {
        double otherZ = (other instanceof Point3D) ? ((Point3D) other).getZ() : 0.0;
        return Math.sqrt(Math.pow(this.getX() - other.getX(), 2) + 
                         Math.pow(this.getY() - other.getY(), 2) + 
                         Math.pow(this.z - otherZ, 2));
    }

    @Override
    public double distanceManhattan(Point2D other) {
        double otherZ = (other instanceof Point3D) ? ((Point3D) other).getZ() : 0.0;
        // Distance 2D calculée par le parent + l'écart des Z
        return super.distanceManhattan(other) + Math.abs(this.z - otherZ);
    }

    @Override
    public double norm() {
        // La racine des composantes au carré
        return Math.sqrt(Math.pow(super.getX(), 2) + Math.pow(super.getY(), 2) + Math.pow(this.z, 2));
    }
}
