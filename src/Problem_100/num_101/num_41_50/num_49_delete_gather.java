package Problem_100.num_101.num_41_50;

public class num_49_delete_gather {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(String my_string) {
            String answer = "";

            String charsToRemove = "aeiou";

            for (char c : charsToRemove.toCharArray()) {
                my_string = my_string.replace(String.valueOf(c), "");
            }
            answer = my_string;

            return answer;
        }
    }
}



