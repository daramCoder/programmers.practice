package num_71_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class num_74_StringSort2 {
    public static void main(String[] args) {

    }
    class Solution {
        public String solution(String my_string) {
            String answer = "";
            String s = my_string.toLowerCase();

            String[] arr = s.split("");
            Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++){
                answer += arr[i];
            }

            return answer;
        }
    }


}
