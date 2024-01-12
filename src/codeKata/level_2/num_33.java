package codeKata.level_2;

public class num_33 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            int range = left;
            int count = 0;

            for (int i = range; i <= right; i++) {
                for (int j = 1; j <= i; j++) {
                    // 각수의 약수 구하기
                    if(range % j == 0){
                        count ++;
                    }
                }
                if (count % 2 == 0){
                    answer += i;
                }else{
                    answer -= i;
                }
                range++;
            }
            return answer;
        }
    }
}
