public class num_23_converse_arrayList {
    public static void main(String[] args) {
    }

    class Solution {
        public int[] solution(int[] num_list) {
            int[] answer = {};

            for(int i = 0; i < num_list.length; i++){
                answer[num_list.length - i] = i;

            }

            return answer;
        }
    }
}
