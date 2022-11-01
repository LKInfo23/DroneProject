package de.grb.vectormath;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Vector3D {

    double x;
    double y;
    double z;

    /**
     * Class representing a three-dimensional vector, which is used to control the Drone's movement.
     * The vector's components (x,y,z) are all the type double.
     * (If created without any constructor-parameters, all three components of the vector will be initialized as 0.)
     */
    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Constructor to construct a random vector given an upper and lower bound.
     * @param upperBound Upper bound of the random values to be generated.
     * @param lowerBound Lower bound of the random values to be generated.
     */
    public Vector3D(int upperBound, int lowerBound) {
        Random random = new Random();
        this.x = random.nextInt(upperBound - lowerBound) + lowerBound;
        this.y = random.nextInt(upperBound - lowerBound) + lowerBound;
        this.z = random.nextInt(upperBound - lowerBound) + lowerBound;
    }


    /**
     * Class representing a three-dimensional vector, which is used to control the Drone's movement.
     * The vector's components (x,y,z) are all the type double.
     * @param x the x-component of the vector
     * @param y the y-component of the vector
     * @param z the z-component of the vector
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(double[] a) {
        if(a.length != 3) {
            this.x = this.y = this.z = 0;
            return;
        }
        this.x = a[0];
        this.y = a[1];
        this.z = a[2];
    }

    /**
     * Class representing a three-dimensional vector, which is used to control the Drone's movement.
     * The vector's components (x,y,z) are all the type double.
     * (If a vector created with another vector as a constructor-parameter, the vector will be a copied.)
     * @param v The vector to be copied.
     */
    public Vector3D(Vector3D v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    /**
     * Method returning the magnitude (length) of the given vector.
     * @return The magnitude of the vector. The magnitude is equal to sqrt(x²+y²+z²).
     */
    public double magnitude() {
        return Math.sqrt(
                this.x * this.x +
                this.y * this.y +
                this.z * this.z
        );
    }

    /**
     * Method for adding a vector to another vector.
     * @param v The vector to be added.
     * @return The resulting vector.
     */
    public Vector3D add(Vector3D v) {
        //for some reason the previous solution did not work;
        Vector3D sol = new Vector3D();
        sol.x = this.x + v.x;
        sol.y = this.y + v.y;
        sol.z = this.z + v.z;
        return sol;
    }

    /**
     * Method for subtracting a vector from another vector.
     * @param v The vector to be subtracted.
     * @return The resulting vector.
     */
    public Vector3D sub(Vector3D v) {
        //for some reason the previous solution did not work;
        Vector3D sol = new Vector3D();
        sol.x = this.x - v.x;
        sol.y = this.y - v.y;
        sol.z = this.z - v.z;
        return sol;
    }

    /**
     * Method to calculate the cross product of two vectors.
     * @param v The vector to calculate the cross product with.
     * @return The resulting vector.
     */
    public Vector3D cross(Vector3D v) {
        this.x = this.y * v.z - this.z * v.y;
        this.y = this.z * v.x - this.x * v.z;
        this.z = this.x * v.y - this.y * v.x;
        return this;
    }

    /**
     * Method to calculate the dot product of two vectors.
     * @param v The vector to calculate the dot product with.
     * @return The resulting product.
     */
    public double dot(Vector3D v) {
        return (
            this.x * v.x +
            this.y * v.y +
            this.z * v.z
        );
    }

    /**
     * Method to normalize a vector. This means to maintain the direction of the vector while scaling it, so its
     * length equates to 1, making it a unit vector.
     * @return The resulting normalized vector.
     */
    public Vector3D normalize() {
        Vector3D unitVector = new Vector3D();
        unitVector.x = this.x / this.magnitude();
        unitVector.y = this.y / this.magnitude();
        unitVector.z = this.z / this.magnitude();
        return unitVector;
    }

    /**
     * Method to multiply a vector with a scalar.
     * @param scalar the scalar to multiply the vector with.
     * @return The scaled vector.
     */
    public Vector3D scalarMultiplication(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    /**
     * Method to make a Vector into a String.
     * @return the Vector in String form.
     */
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    public String[] toStringArr() {
        String[] v = new String[3];
        v[0] = Double.toString(this.x);
        v[1] = Double.toString(this.y);
        v[2] = Double.toString(this.z);

        return v;
    }

    /**
     * Method to find if two vectors are collinear
     * @param v the vector where the collinearity needs to be found with
     * @return if the vectors are collinear
     */
    public boolean isCollinear(Vector3D v) {
        Vector3D Zero = new Vector3D();
        return (this.cross(v).equals(Zero));
        //if the cross product of the vectors equals the Zero element they are collinear
    }

    /**
     * Method to return a normalized vector that is orthogonal on the XY-Axis
     * @return normalized orthogonal Vector
     */
    public Vector3D OrthogonalXY() {
        return new Vector3D(1, -this.x/this.y, 0); //.normalize();
    }

    public void readVectorFromStdIO() {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        this.x = in.nextDouble();
        this.y = in.nextDouble();
        this.z = in.nextDouble();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Double.compare(vector3D.x, x) == 0 && Double.compare(vector3D.y, y) == 0 && Double.compare(vector3D.z, z) == 0;
    }

    public double distance(Vector3D v) {
        return Math.sqrt((this.x - v.x)*(this.x - v.x) + (this.y - v.y)*(this.y - v.y) + (this.z + v.z)*(this.z + v.z));
    }

    public double AngleBetween(Vector3D v) {
        return Math.acos(this.dot(v) / this.magnitude() * v.magnitude());
    }

}
