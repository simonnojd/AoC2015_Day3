package Puzzle1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Gifts {

    static String code;

    public static void main(String[] args) throws IOException {
        FileInputStream fstream = new FileInputStream("src\\Puzzle1\\Database");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        code = br.readLine();
        br.close();

        firstPart();
        secondPart();
    }
    
    public static void firstPart() {

        int x = 0;
        int y = 0;

        List<String> visited = new ArrayList<>();
        visited.add("0:0");

        for (char ch : code.toCharArray()) {
            if (ch == '^') y++;
            if (ch == '>') x++;
            if (ch == 'v') y--;
            if (ch == '<') x--;

            String currentPosition = x + ":" + y;
            if (!visited.contains(currentPosition)) visited.add(currentPosition);
        }
        System.out.println(visited.size() + " houses have at least received 1 present.");
    }

    public static void secondPart() {

        int x_santa = 0;
        int y_santa = 0;
        int x_robo = 0;
        int y_robo = 0;

        List<String> visited = new ArrayList<>();
        visited.add("0:0");

        boolean robot = false;
        String currentPosition;

        for (char ch : code.toCharArray()) {
            if (robot) {
                if (ch == '^') y_robo++;
                if (ch == '>') x_robo++;
                if (ch == 'v') y_robo--;
                if (ch == '<') x_robo--;
                currentPosition = x_robo + ":" + y_robo;
            } else {
                if (ch == '^') y_santa++;
                if (ch == '>') x_santa++;
                if (ch == 'v') y_santa--;
                if (ch == '<') x_santa--;
                currentPosition = x_santa + ":" + y_santa;
            }

            if (!visited.contains(currentPosition)) visited.add(currentPosition);
            robot = !robot;
        }

        System.out.println(visited.size() + " houses have at least received 1 present.");
    }
}