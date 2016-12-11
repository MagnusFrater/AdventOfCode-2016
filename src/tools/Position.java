package tools;

/**
 * Created by magnusfrater on 12/10/16.
 */
public class Position {

    public double x;
    public double y;

    public Position (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position (Position position) {
        this(position.getX(), position.getY());
    }

    public int getX() {
        return (int)x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getY() {
        return (int)y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void offset (double xOffset, double yOffset) {
        x += xOffset;
        y += yOffset;
    }
}
