import tools.*;

/**
 * Created by magnusfrater on 12/10/16.
 */
public class Day_1 {

    public static void main (String[] args) {
        Day_1 d1 = new Day_1();

        int bunnyHQ = 0;
        int firstIntersection = 0;

        Vector v1 = new Vector(new Position(0,0), 3, 90);
        Vector v2 = new Vector(new Position(-1,1), 3, 0);

        Position intersection = v1.intersects(v2);

        System.out.println(intersection.getX() +" "+ intersection.getY());

        System.out.println("The distance to the Easter Bunny's HQ is "+ bunnyHQ +" blocks.");
        System.out.println("The first position we visit twice is "+ firstIntersection +" blocks away.");
    }
}
