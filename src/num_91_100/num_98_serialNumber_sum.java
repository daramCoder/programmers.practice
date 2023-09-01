package num_91_100;

public class num_98_serialNumber_sum {
    public void main(String[] args) {
        int numA = 3;
        int numB = 12;
        Solution solution = new Solution(numA, numB);
    }
    static class Solution {
        int[] answer;
        public  Solution(int num, int total) {
            int[] answer = new int[num];
            int start = (total/num) - ((num - 1)/2);

            for(int i = 0; i < num; i++) {
                answer[i] = start;
                start++;
            }

        }
    }


}
