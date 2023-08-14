public class num_38_number_pare {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int n) {
            int answer = 0;
            for (int i = 1; i <= n; i++) {  // int i = 1 부터 시작해야 한다!
                if (n % i == 0) {
                    answer++;
                }
            }
            return answer;
        }

    }
}


