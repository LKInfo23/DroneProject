package de.grb.vectormath;

import de.grb.vectormath.LinearFunctionRelation;
import de.grb.vectormath.Vector3D;

public class LinearFunctionSolution {

    LinearFunctionRelation Solution;
    Vector3D Point;
    /**
     * This is a class representing the solution to the problem of the relation of two
     * Linear Functions. It consists of the Solution Name and a vector to the point of
     * intersection if they intersect.
     */

    /**
     * Constructor to Construct a Solution with a point
     */
    public LinearFunctionSolution(LinearFunctionRelation Solution, Vector3D Point) {
        this.Solution = Solution;
        this.Point = Point;
    }

    /**
     * Constructor to Construct a Solution without a point
     * @param Solution
     */
    public LinearFunctionSolution(LinearFunctionRelation Solution) {
        this.Solution = Solution;
        this.Point = new Vector3D();
    }
}
