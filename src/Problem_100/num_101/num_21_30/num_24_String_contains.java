package Problem_100.num_101.num_21_30;

public class num_24_String_contains {
    public static void main(String[] args) {
        class Solution {
            public int solution(String str1, String str2) {
                int answer = 0;

                if (str1.contains(str2)){
                    answer = 1;
                } else {
                    answer = 2;
                }
                return answer;
            }
        }
    }
}
