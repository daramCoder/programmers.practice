package codeKata.level_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// 대충 만든 자판
public class Num_66 {

    public static void main(String[] args) {

        String[] keymap =  {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        solution(keymap, targets);

    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character, Integer> keypad = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {   // ABACD, BCEFD
            for (int j = 0; j < keymap[i].length(); j++) { // ABACD
                char c  = keymap[i].charAt(j); // A, B, A, C, D

                if(keypad.containsKey(c)){
                    int inx = keypad.get(c);  // Index
                    keypad.put(c, Math.min(inx, j + 1)); // index, 순서대로 한거랑 비교
                }
                else keypad.put(c, j+1); // 없으면!! 저장! c(알파벳), 순서 1,2,3,4,5

            }
        }
        for (int i = 0; i < targets.length; i++) { // ABCD, AABB
            String target = targets[i]; // ABCD
            int count = 0;
            boolean flag = true;
            for (char c : target.toCharArray()) { // A, B, C, D
                if(keypad.containsKey(c)){  // target 첫번째 알파멧 A 포함하면
                    count += keypad.get(c); // 알파멧의 인덱스인 1을 가지고 온다.
                }else {
                    flag = false; // 없다면
                    break;
                }
            }
            answer[i] = (flag == false) ? -1 : count; // 없으면 -1, 있으면 인덱스를 저장해준다.
        }
        return answer;
    }

}
