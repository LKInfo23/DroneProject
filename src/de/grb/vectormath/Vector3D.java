package de.grb.vectormath;

public class Vector3D {

    double x;
    double y;
    double z;

    /**
     * Class representing a three dimensional vector, which is used to control the Drone's movement.
     * The vector's components (x,y,z) are all of type double.
     * (If created without any constructor-parameters, all three components of the vector will be initialized as 0.)
     */
    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Class representing a three dimensional vector, which is used to control the Drone's movement.
     * The vector's components (x,y,z) are all of type double.
     * @param x the x-component of the vector
     * @param y the y-component of the vector
     * @param z the z-component of the vector
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Class representing a three dimensional vector, which is used to control the Drone's movement.
     * The vector's components (x,y,z) are all of type double.
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
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    /**
     * Method for subtracting a vector from another vector.
     * @param v The vector to be subtracted.
     * @return The resulting vector.
     */
    public Vector3D sub(Vector3D v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        return this;
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
     * Method to normalize a vector. This means to maintain the direction of the vector while scaling it, so its'
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
}
