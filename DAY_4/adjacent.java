import java.util.*;
import java.io.*;
import java.util.*;

public class adjacent {
    public static void main(String[] args) throws Exception {

        // Step 1: Read file lines
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();

        int rows = lines.size();
        int cols = lines.get(0).length();

        // Step 2: Convert to 2D matrix
        char[][] grid = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            grid[r] = lines.get(r).toCharArray();
        }

        int accessible = 0;

        // directions: 8 neighbors
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        // Step 3: Check each position
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '@') {
                    int count = 0;

                    for (int k = 0; k < 8; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                            grid[nr][nc] == '@') {
                            count++;
                        }
                    }

                    if (count < 4) {
                        accessible++;
                    }
                }
            }
        }

        System.out.println("Accessible rolls: " + accessible);
    }
}
