package tools;

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
    }

    public Position getEnd () {
        Position end = new Position(start);

        double xOffset = Math.cos(Math.toRadians(degrees)) * magnitude;
        double yOffset = Math.sin(Math.toRadians(degrees)) * magnitude;

        end.offset(xOffset, yOffset);

        return end;
    }

    public Position intersects (Vector vector) {

    }
}
