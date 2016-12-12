package tools;

import java.awt.geom.Line2D;

/**
 * Created by magnusfrater on 12/10/16.
 */
public class Vector {

    private Position start;
    private double magnitude;

    private double degrees;

    public Vector (Position start, double magnitude, double degrees){
        this.start = start;
        this.magnitude = magnitude;
        this.degrees = degrees;

        fixDegrees();
    }

    public Vector (Position start, Position end) {
        this.start = start;

        // if a vertical line
        if (end.getX() == start.getX()) {
            this.magnitude = Math.abs(end.getY() - start.getY());
        } else {
            this.magnitude = Math.abs(end.getY() - start.getY()) / Math.abs(end.getX() - start.getX());
        }

        this.degrees = Math.atan2(end.getY() - start.getY(), end.getX() - start.getX());

        fixDegrees();
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;

        fixDegrees();
    }

    // -360 <= degrees <= 360
    public void fixDegrees () {
        if (degrees > 360) {
            degrees -= 360;
        }

        if (degrees < -360) {
            degrees += 360;
        }
    }

    public Position getEnd () {
        Position end = new Position(start);

        double xOffset = Math.cos(Math.toRadians(degrees)) * magnitude;
        double yOffset = Math.sin(Math.toRadians(degrees)) * magnitude;

        end.offset(xOffset, yOffset);

        return end;
    }

    // returns a double length difference between end.x and start.x
    public double getXOffset () {
        return getEnd().getX() - start.getX();
    }

    // returns a double length difference between end.y and start.y
    public double getYOffset () {
        return getEnd().getY() - start.getY();
    }

    public Position getIntersection (Vector vector) {

        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = getEnd().getX();
        double y2 = getEnd().getY();

        double x3 = vector.getStart().getX();
        double y3 = vector.getStart().getY();
        double x4 = vector.getEnd().getX();
        double y4 = vector.getEnd().getY();

        double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        if (denom == 0.0) { // Lines are parallel.
            return null;
        }
        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denom;
        double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denom;
        if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
            // Get the intersection point.
            return new Position((x1 + ua * (x2 - x1)), (int) (y1 + ua * (y2 - y1)));
        }

        return null;
    }

    public boolean doesIntersect (Vector vector) {
        return Line2D.linesIntersect(getStart().getX(), getStart().getY(), getEnd().getX(), getEnd().getY(), vector.getStart().getX(), vector.getStart().getY(), vector.getEnd().getX(), vector.getEnd().getY());
    }
}
