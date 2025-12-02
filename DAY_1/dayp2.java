import java.util.*;
import java.io.*;

public class dayp2 {

    public static void main(String[] args) throws Exception {

        List<String> instructions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            instructions.add(line.trim());
        }
        br.close();

        int clock = 50;
        int count = 0;

        for (String instr : instructions) {
            char dir = instr.charAt(0);
            int distance = Integer.parseInt(instr.substring(1));

            for (int i = 0; i < distance; i++) {
                if (dir == 'L') {
                    clock = (clock - 1 + 100) % 100;
                } else {
                    clock = (clock + 1) % 100;
                }

                if (clock == 0) {
                    count++;
                }
            }
        }

        System.out.println("Count = " + count);
    }
}
