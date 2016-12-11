package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by magnusfrater on 12/10/16.
 */
public class Utils {

    public static ArrayList<String> parseFile (String filePath) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            lines.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void printArray (ArrayList<String> al) {
        System.out.print("[");
        for (int i=0; i<al.size() - 1; i++) {
            System.out.print(al.get(i) +", ");
        }
        System.out.println(al.get(al.size()-1) +"]");
    }
}
