package de.grb.vectormath;

import java.util.Random;


public class LinearFunction {
    Vector3D StartingPoint;
    Vector3D Direction;

    /**
     * This is a class to represent a Linear function in 3d using 2 vectors. One vector to point to one
     * point on the line and one vector to give the direction.
     * the StartingPoint and the direction are of the Vector3D type
     * (if created with any parameters it will be initialized with zero elements
     */
    public LinearFunction() {
        this.StartingPoint = new Vector3D();
        this.Direction = new Vector3D();
    }

    /**
     * Constructor to construct a linear function using two vectors
     * @param StartingPoint the starting point
     * @param Direction the direction
     */
    public LinearFunction(Vector3D StartingPoint, Vector3D Direction) {
        this.StartingPoint = StartingPoint;
        this.Direction = Direction;
    }

    /**
     * Method to see if two Linear functions are Parallel (doesn't check for Identical functions)
     * @param f a linear function
     * @return if they are parallel
     */
    public boolean isParallel(LinearFunction f) {
        return (f.Direction.isCollinear(this.Direction));
    }

    /**
     * Method to see if two linear functions are Identical
     * @param f a linear function
     * @return if they are Identical
     */
    public boolean isIdentical(LinearFunction f) {
        return (this.isParallel(f) && this.StartingPoint.sub(f.StartingPoint).isCollinear(this.Direction));
        //checks to see if the Lines are parallel and then checks
        //if the Vector between the Starting points is collinear to the direction vectors
    }

    public void ReconfigureStartingPoint() {
        Random random = new Random();
        StartingPoint.add(Direction.scalarMultiplication(random.nextInt(10) - 5));
    }

    public String toString() {
        return "x = " + StartingPoint.toString() + " + r * " + Direction.toString();
    }

    /**
     * Method to get the Relation of two linear functions.
     * @param f a LinearFunction
     * @return a solution
     */
    public LinearFunctionSolution getRelationTo(LinearFunction f) {
        if(this.isIdentical(f)) {
            return new LinearFunctionSolution(LinearFunctionRelation.IDENTICAL);
        }
        if(this.isParallel(f)) {
            return new LinearFunctionSolution(LinearFunctionRelation.PARALLEL);
        }
        /*first solving the first two lines of the equation using Matrix determinants
        * 1. the equation looks like this:
        * this.StartingPoint + this.Direction * r = f.StartingPoint + f.Direction * v
        * expanded:
        * this.StartingPoint.x + this.Direction.x * r = f.StartingPoint.x + f.Direction.x * v
        * this.StartingPoint.y + this.Direction.y * r = f.StartingPoint.y + f.Direction.y * v
        * this.StartingPoint.z + this.Direction.z * r = f.StartingPoint.z + f.Direction.z * v
        *
        * 2. this needs to be rearranged to:
        * this.Direction * r - f.Direction * v = f.StartingPoint - this.StartingPoint
        * neater form:
        * this.Direction * r + negFDirection * v = SubFThis
        * expanded:
        * this.Direction.x * r + negFDirection.x * v = SubFThis.x
        * this.Direction.y * r + negFDirection.y * v = SubFThis.y
        * this.Direction.z * r + negFDirection.z * v = SubFThis.z
        *
        * 3. now the Solutions are given by
        *
        * r = det((SubFThis.x, SubFTHis.y), (negFDirection.x, negFDirection.y)) /
        *     det((this.Direction.x, this.Direction.y), (negFDirection.x, negFDirection.y))
        *
        * v = det((this.Direction.x, this.Direction.y),(SubFThis.x, SubFThis.y)) /
        *     det((this.Direction.x, this.Direction.y), (negFDirection.x, negFDirection.y))
        *
        * or written out:
        * RSub = this.Direction.x * negFDirection.y - this.Direction.y * negFDirection.x
        *
        * r = SubFThis.x * negFDirection.y - SubFThis.y * negFDirection.x / RSub
        *
        * v = this.Direction.x * SubFThis.y - this.Direction.y * SubFThis.x
        *
        */
        Vector3D negFDirection = f.Direction.scalarMultiplication(-1); // the direction of but negative
        double RSub = this.Direction.x * negFDirection.y - this.Direction.y * negFDirection.x;
        if(RSub == 0) { //if the 2x2 doesn't have a solution
            return new LinearFunctionSolution(LinearFunctionRelation.SKEWED);
        }
        Vector3D SubFThis = f.StartingPoint.sub(this.StartingPoint);
        double r = SubFThis.x * negFDirection.y - SubFThis.y * negFDirection.x;
        double v = this.Direction.x * SubFThis.y - this.Direction.y * SubFThis.x;
        //4. check the final equation:
        //this.Direction.z * r + negFDirection.z * v = SubFThis.z
        if(this.Direction.z * r + negFDirection.z * v != SubFThis.z) {
            return new LinearFunctionSolution(LinearFunctionRelation.SKEWED);
        }
        Vector3D Intersection = this.StartingPoint.add(this.Direction.scalarMultiplication(r));
        return new LinearFunctionSolution(LinearFunctionRelation.INTERSECT, Intersection);
    }

    public Vector3D pointAt(int x) {
        return new Vector3D(this.StartingPoint.add(this.Direction.scalarMultiplication(x)));
    }

    public Vector3D getDirection() {
        return Direction;
    }

    public String withoutDirection() {
        return "x = " + StartingPoint.toString() + " + r * (";
    }
}