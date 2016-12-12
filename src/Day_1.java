import tools.*;

import java.util.ArrayList;

/**
 * Created by magnusfrater on 12/10/16.
 */
public class Day_1 {

    private ArrayList<Vector> directions = new ArrayList<>();

    public int getDistanceToHQ () {
        String[] input = Utils.parseFile("DirectionsToBunnyHQ.txt").get(0).split(", ");

        directions = new ArrayList<>();

        directions.add(new Vector(new Position(0,0), 0, 90));

        for (String s : input) {
            Vector lastVector = directions.get(directions.size() - 1);
            double degrees = lastVector.getDegrees();

            if (s.contains("L")) {
                degrees += 90;
            } else {
                degrees -= 90;
            }

            Vector nextVector = new Vector(lastVector.getEnd(), Integer.parseInt(s.substring(1)), degrees);
            directions.add(nextVector);
        }

        Vector finalVector = directions.get(directions.size() - 1);

        return Math.abs(finalVector.getEnd().getX()) + Math.abs(finalVector.getEnd().getY());
    }

    public int getFirstIntersection () {
        // can't intersect with the line before it
        for (int i=0; i<directions.size(); i++) {
            for (int j=0; j<i - 1; j++) {
                // if the lines intersect
                if (directions.get(i).doesIntersect(directions.get(j))) {

                    // get the exact point of the intersection, recreate that intersected line using that point as the end
                    Position intersection = directions.get(i).getIntersection(directions.get(j));
                    Vector intersected = new Vector(directions.get(j).getStart(), intersection);

                    // get the total x & y offset (to total the blocks)
                    double xOffset = Math.abs(intersected.getStart().getX());
                    double yOffset = Math.abs(intersected.getStart().getY());

                    Vector v1 = directions.get(i);
                    Vector v2 = directions.get(j);

                    System.out.println(i +" "+ j);
                    System.out.println(v1.getStart().getX() +" "+ v1.getStart().getY() +" "+ v1.getEnd().getX() +" "+ v1.getEnd().getY());
                    System.out.println(v2.getStart().getX() +" "+ v2.getStart().getY() +" "+ v2.getEnd().getX() +" "+ v2.getEnd().getY());
                    System.out.println(xOffset +" "+ yOffset);

                    return (int)(xOffset + yOffset);
                }
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        Day_1 d1 = new Day_1();

        int bunnyHQ = d1.getDistanceToHQ();
        int firstIntersection = d1.getFirstIntersection();

        System.out.println("The distance to the Easter Bunny's HQ is "+ bunnyHQ +" blocks.");
        System.out.println("The first position we visit twice is "+ firstIntersection +" blocks away.");
    }
}
