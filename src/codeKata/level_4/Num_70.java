package codeKata.level_4;

import java.util.Arrays;
import java.util.HashMap;

// 바탕화면 정리
public class Num_70 {

    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        solution(wallpaper);
    }
    public static int[] solution(String[] wallpaper) {
        int[] answer = {};
        HashMap<Integer, Integer> wallMap = new HashMap<>();
       int rdx = 0;
       int rdy = 0;
       int lux = 0;
       int luy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            String wall = Arrays.toString(wallpaper[i].split("")); // ".#...",    "..#..",    "...#."
            for (int j = 0; j < wall.length(); j++) {   // .#...
                String[] wList = wall.split("");
               if(wList[j].equals("#")){
                   wallMap.put(j, j);
                   System.out.println("i | " + i + "j | " + j);
               }
            }
        }
        System.out.println();
        return answer;
    }
}
