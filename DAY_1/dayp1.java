import java.io.*;
import java.util.*;

public class dayp1 {
    public static void main(String[] args) throws Exception {

        List<String> rotations = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            rotations.add(line.trim());
        }
        br.close();

        int clock = 50;   // starting position
        int count = 0;    // number of times clock becomes 0

        for (String instr : rotations) {
            char dir = instr.charAt(0);        // L or R
            int distance = Integer.parseInt(instr.substring(1));

            if (dir == 'L') {
                clock = (clock - distance) % 100;
                if (clock < 0) clock += 100;   // fix negative values
            } else { // dir == 'R'
                clock = (clock + distance) % 100;
            }

            if (clock == 0) {
                count++;
            }
        }

        System.out.println("Password = " + count);
    }
}
