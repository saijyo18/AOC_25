import java.util.*;
import java.io.*;

public class adjacent2 {
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

        // Directions: 8 neighbors
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        int totalRemoved = 0;
        boolean changed = true;

        while (changed) {
            changed = false;
            List<int[]> toRemove = new ArrayList<>();

            // FIND ALL ROLLS TO REMOVE
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
                            toRemove.add(new int[]{r, c});
                        }
                    }
                }
            }

            // REMOVE THEM
            if (!toRemove.isEmpty()) {
                changed = true;
                totalRemoved += toRemove.size();

                for (int[] pos : toRemove) {
                    grid[pos[0]][pos[1]] = '.';
                }
            }
        }

        System.out.println("Total rolls removed: " + totalRemoved);
    }
}
